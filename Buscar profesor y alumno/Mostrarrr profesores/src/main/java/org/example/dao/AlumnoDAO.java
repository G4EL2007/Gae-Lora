package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoDAO {
    public boolean inscribirAlumno(Alumno alumno) {
        boolean inscrito = false;
        String sql = "INSERT INTO alumnos (numExpediente, nombre, curp, grupo, promedio) VALUES (?,?,?,?,?)";
        if (alumno == null || alumno.getNumExpediente() <= 0) {
            System.out.println("No se puede registrar: el numero de expediente es invalido.");
            return false;
        }

        Connection conexion = Conexion.conectar();
        if (conexion == null) {
            return inscrito;
        }
        try(Connection con = conexion;
            PreparedStatement stm =  con.prepareStatement(sql);) {

            stm.setInt(1,alumno.getNumExpediente());
            stm.setString(2, alumno.getNombre());
            stm.setString(3, alumno.getCurp());
            stm.setString(4,alumno.getGrupo());
            stm.setDouble(5,alumno.getPromedio());
            stm.executeUpdate();
            inscrito = true;
            System.out.println("Registro realizado correctamente");

        } catch (SQLException err) {
            if (err.getErrorCode() == 1062) {
                System.out.println("Ya existe un alumno con ese numero de expediente.");
            } else {
                System.out.println("Error al registrar alumno: " + err.getMessage());
            }
        }

        return inscrito;
    }
    public ArrayList<Alumno> extraerAlumno(){
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        String  sql = "SELECT * FROM alumnos";
        Connection conexion = Conexion.conectar();
        if (conexion == null) {
            return alumnos;
        }
        try(Connection con = conexion;
        PreparedStatement stm = con.prepareStatement(sql);){
           ResultSet rs = stm.executeQuery();
           while (rs.next()){
               Alumno alumno = new Alumno();
               alumno.setNumExpediente(rs.getInt("numExpediente"));
               alumno.setNombre(rs.getString("nombre"));
               alumno.setCurp(rs.getString("curp"));
               alumno.setGrupo(rs.getString("grupo"));
               alumno.setPromedio(rs.getDouble("promedio"));
               alumnos.add(alumno);
           }

        }catch(SQLException err){
            System.out.println("Error al extraer alumnos"+err.getMessage());
        }
        return alumnos;

    }

    public Alumno buscarPorExpediente(int numExpediente) {
        String sql = "SELECT numExpediente, nombre, curp, grupo, promedio " +
                "FROM alumnos WHERE numExpediente = ?";
        Connection conexion = Conexion.conectar();

        if (conexion == null) {
            return null;
        }

        try (Connection con = conexion;
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(1, numExpediente);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    Alumno alumnoEncontrado = new Alumno();
                    alumnoEncontrado.setNumExpediente(rs.getInt("numExpediente"));
                    alumnoEncontrado.setNombre(rs.getString("nombre"));
                    alumnoEncontrado.setCurp(rs.getString("curp"));
                    alumnoEncontrado.setGrupo(rs.getString("grupo"));
                    alumnoEncontrado.setPromedio(rs.getDouble("promedio"));
                    return alumnoEncontrado;
                }
            }

        } catch (SQLException err) {
            System.out.println("Error al buscar alumno: " + err.getMessage());
        }

        return null;
    }

    public boolean actualizar(Alumno alumno){
        boolean actualizado = false;
        String sql = "UPDATE alumnos SET nombre = ?, curp = ?, grupo = ?, promedio = ? WHERE numExpediente = ? ";
        Connection conexion = Conexion.conectar();
        if (conexion == null) {
            return actualizado;
        }
        try(Connection con = conexion;
        PreparedStatement stm =  con.prepareStatement(sql);){
           stm.setString(1,alumno.getNombre());
            stm.setString(2,alumno.getCurp());
            stm.setString(3,alumno.getGrupo());
            stm.setDouble(4,alumno.getPromedio());
            stm.setInt(5,alumno.getNumExpediente());
            int registrosAfectados = stm.executeUpdate();
            if(registrosAfectados > 0 ){
                System.out.println("Alumno Actualizado Correctamente");
                actualizado = true;
            }else{
                System.out.println("Te la volaste master tu Expediente no existe");
            }
        }catch(SQLException err){
            System.out.println("Error al actualizar Alumno"+err.getMessage());
        }
        return actualizado;
    }

    public boolean eliminar(int numExpediente) {
        boolean eliminado = false;
        String sql = "DELETE FROM alumnos WHERE numExpediente = ?";
        Connection conexion = Conexion.conectar();

        if (conexion == null) {
            return eliminado;
        }

        try (Connection con = conexion;
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(1, numExpediente);
            int registrosAfectados = stm.executeUpdate();

            if (registrosAfectados > 0) {
                eliminado = true;
                System.out.println("Alumno borrado correctamente.");
            } else {
                System.out.println("No existe un alumno con ese numero de expediente.");
            }
        } catch (SQLException err) {
            System.out.println("Error al borrar alumno: " + err.getMessage());
        }

        return eliminado;
    }

}


