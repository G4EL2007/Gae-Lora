package org.example.vista;

import org.example.dao.AlumnoDAO;
import org.example.dao.ProfesorDAO;
import org.example.modelo.Alumno;
import org.example.modelo.Profesor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {

    static AlumnoDAO alumnoDAO = new AlumnoDAO();
    static Alumno alumno = new Alumno();

    static ProfesorDAO profesorDAO = new ProfesorDAO();
    static Profesor profesor = new Profesor();

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    // ---------- ALUMNOS ----------

    private static void inscribir() throws IOException {
        System.out.print("Nombre: ");
        alumno.setNombre(leer.readLine());
        System.out.print("CURP: ");
        alumno.setCurp(leer.readLine());
        System.out.print("Numero de Expediente: ");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));
        System.out.print("Grupo: ");
        alumno.setGrupo(leer.readLine());
        System.out.print("Promedio: ");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));

        alumnoDAO.inscribirAlumno(alumno);
    }

    private static void mostrarAlumnos() {
        ArrayList<Alumno> alumnos = alumnoDAO.extraerAlumno();

        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    private static void actualizarAlumno() throws IOException {
        System.out.print("Numero de Expediente: ");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));
        System.out.print("Nombre: ");
        alumno.setNombre(leer.readLine());
        System.out.print("CURP: ");
        alumno.setCurp(leer.readLine());
        System.out.print("Grupo: ");
        alumno.setGrupo(leer.readLine());
        System.out.print("Promedio: ");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));

        alumnoDAO.actualizar(alumno);
    }

    private static void borrarAlumno() throws IOException {
        try {
            System.out.println("\n===== BORRAR ALUMNO =====");
            System.out.print("Numero de expediente del alumno: ");
            int numExpediente = Integer.parseInt(leer.readLine());

            System.out.print("Escribe S para confirmar el borrado: ");
            String confirmacion = leer.readLine();

            if (confirmacion.equalsIgnoreCase("S")) {
                alumnoDAO.eliminar(numExpediente);
            } else {
                System.out.println("Borrado de alumno cancelado.");
            }
        } catch (NumberFormatException err) {
            System.out.println("El numero de expediente debe ser numerico.");
        }
    }

    // ---------- PROFESORES ----------

    private static void registrarProfesor() throws IOException {
        System.out.print("Nombre: ");
        profesor.setNombre(leer.readLine());
        System.out.print("CURP: ");
        profesor.setCurp(leer.readLine());
        System.out.print("Numero de Empleado: ");
        profesor.setNumEmpleado(Integer.parseInt(leer.readLine()));
        System.out.print("Puesto: ");
        profesor.setPuesto(leer.readLine());
        System.out.print("Sueldo: ");
        profesor.setSueldo(Double.parseDouble(leer.readLine()));

        profesorDAO.registrarProfesor(profesor);
    }

    private static void mostrarProfesores() {
        ArrayList<Profesor> profesores = profesorDAO.extraerProfesores();

        for (Profesor profesor : profesores) {
            System.out.println(profesor);
        }
    }

    private static void actualizarProfesor() throws IOException {
        Profesor profesorModificar = new Profesor();

        try {
            System.out.println("\n===== ACTUALIZAR PROFESOR =====");
            System.out.print("Numero de empleado del profesor: ");
            profesorModificar.setNumEmpleado(Integer.parseInt(leer.readLine()));

            System.out.print("Nuevo nombre: ");
            profesorModificar.setNombre(leer.readLine());

            System.out.print("Nueva CURP: ");
            profesorModificar.setCurp(leer.readLine());

            System.out.print("Nuevo puesto: ");
            profesorModificar.setPuesto(leer.readLine());

            System.out.print("Nuevo sueldo: ");
            profesorModificar.setSueldo(Double.parseDouble(leer.readLine()));

            profesorDAO.actualizar(profesorModificar);
        } catch (NumberFormatException err) {
            System.out.println("El numero de empleado y el sueldo deben ser numericos.");
        }
    }

    private static void borrarProfesor() throws IOException {
        try {
            System.out.println("\n===== BORRAR PROFESOR =====");
            System.out.print("Numero de empleado del profesor: ");
            int numEmpleado = Integer.parseInt(leer.readLine());

            System.out.print("Escribe S para confirmar el borrado: ");
            String confirmacion = leer.readLine();

            if (confirmacion.equalsIgnoreCase("S")) {
                profesorDAO.eliminar(numEmpleado);
            } else {
                System.out.println("Borrado de profesor cancelado.");
            }
        } catch (NumberFormatException err) {
            System.out.println("El numero de empleado debe ser numerico.");
        }
    }

    // ---------- MENU ----------

    public static void menu() throws IOException {
        int opcion = 0;

        do {
            System.out.println("\n========== MODULO DE GAEL LORA ==========");
            System.out.println("1.- Inscribir Alumno");
            System.out.println("2.- Mostrar Alumno");
            System.out.println("3.- Registrar Profesor");
            System.out.println("4.- Mostrar Profesor");
            System.out.println("5.- Actualizar Profesor");
            System.out.println("6.- Borrar Alumno");
            System.out.println("7.- Borrar Profesor");
            System.out.println("8.- Salir");
            System.out.print("Opcion: ");

            try {
                opcion = Integer.parseInt(leer.readLine());

                switch (opcion) {
                    case 1:
                        inscribir();
                        break;
                    case 2:
                        mostrarAlumnos();
                        break;
                    case 3:
                        registrarProfesor();
                        break;
                    case 4:
                        mostrarProfesores();
                        break;
                    case 5:
                        actualizarProfesor();
                        break;
                    case 6:
                        borrarAlumno();
                        break;
                    case 7:
                        borrarProfesor();
                        break;
                    case 8:
                        System.out.println("Programa finalizado.");
                        break;
                    default:
                        System.out.println("Opcion invalida.");
                }
            } catch (NumberFormatException err) {
                System.out.println("Debes escribir un numero del 1 al 8.");
            }
        } while (opcion != 8);
    }
}
