package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesorDAO {
    private static final String TABLA_PROFESORES = "profesores";

    public boolean agregarProfesor(Profesor profesor) {
        boolean agregado = false;
        String sql = "INSERT INTO " + TABLA_PROFESORES + " (numEmpleado, nombre, curp, puesto, sueldo) VALUES (?, ?, ?, ?, ?)";
        Connection conexion = null;

        if (profesor == null || !profesor.esValido()) {
            System.out.println("No se puede registrar el profesor porque hay datos invalidos");
            return false;
        }

        try {
            conexion = Conexion.conectar();
            if (conexion == null) {
                System.out.println("No se pudo iniciar la transaccion porque no hay conexion con MySQL");
                return false;
            }

            conexion.setAutoCommit(false);

            try (PreparedStatement stm = conexion.prepareStatement(sql)) {
                stm.setInt(1, profesor.getNumEmpleado());
                stm.setString(2, profesor.getNombre());
                stm.setString(3, profesor.getCurp());
                stm.setString(4, profesor.getPuesto());
                stm.setDouble(5, profesor.getSueldo());

                int registros = stm.executeUpdate();

                if (registros > 0) {
                    conexion.commit();
                    agregado = true;
                    System.out.println("Profesor registrado correctamente");
                } else {
                    conexion.rollback();
                    System.out.println("No se registro ningun profesor. Transaccion revertida");
                }
            }
        } catch (SQLException err) {
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException rollbackErr) {
                System.out.println("Error al revertir la transaccion: " + rollbackErr.getMessage());
            }
            System.out.println("Error al registrar profesor: " + err.getMessage());
        } finally {
            try {
                if (conexion != null) {
                    conexion.setAutoCommit(true);
                    conexion.close();
                }
            } catch (SQLException closeErr) {
                System.out.println("Error al cerrar la conexion: " + closeErr.getMessage());
            }
        }

        return agregado;
    }

    public ArrayList<Profesor> extraerProfesores() {
        ArrayList<Profesor> profesores = new ArrayList<>();
        String sql = "SELECT numEmpleado, nombre, curp, puesto, sueldo FROM " + TABLA_PROFESORES;

        try (Connection conexion = Conexion.conectar()) {
            if (conexion == null) {
                System.out.println("No se pudieron consultar profesores porque no hay conexion con MySQL");
                return profesores;
            }

            try (PreparedStatement stm = conexion.prepareStatement(sql);
                 ResultSet rs = stm.executeQuery()) {

                while (rs.next()) {
                    Profesor profesor = new Profesor();
                    profesor.setNumEmpleado(rs.getInt("numEmpleado"));
                    profesor.setNombre(rs.getString("nombre"));
                    profesor.setCurp(rs.getString("curp"));
                    profesor.setPuesto(rs.getString("puesto"));
                    profesor.setSueldo(rs.getDouble("sueldo"));
                    profesores.add(profesor);
                }
            }
        } catch (SQLException err) {
            System.out.println("Error al extraer profesores: " + err.getMessage());
        }

        return profesores;
    }
}
