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
    private static final AlumnoDAO alumnoDAO = new AlumnoDAO();
    private static final ProfesorDAO profesorDAO = new ProfesorDAO();
    private static final BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    private static final String AUTOR_MODULO_PROFESORES = "Gael Lora";

    private static void inscribirAlumno() throws IOException {
        Alumno alumno = new Alumno();
        System.out.print("Nombre: ");
        alumno.setNombre(leer.readLine());
        System.out.print("CURP: ");
        alumno.setCurp(leer.readLine());
        System.out.print("Numero de expediente: ");
        alumno.setNumExpediente(leerEntero());
        System.out.print("Grupo: ");
        alumno.setGrupo(leer.readLine());
        System.out.print("Promedio: ");
        alumno.setPromedio(leerDouble());

        alumnoDAO.inscribirAlumno(alumno);
    }

    private static void mostrarAlumnos() {
        ArrayList<Alumno> alumnos = alumnoDAO.extraerAlumno();
        System.out.println("========== LISTA DE ALUMNOS ==========");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    private static void actualizarAlumno() throws IOException {
        Alumno alumno = new Alumno();
        System.out.print("Numero de expediente: ");
        alumno.setNumExpediente(leerEntero());
        System.out.print("Nombre: ");
        alumno.setNombre(leer.readLine());
        System.out.print("CURP: ");
        alumno.setCurp(leer.readLine());
        System.out.print("Grupo: ");
        alumno.setGrupo(leer.readLine());
        System.out.print("Promedio: ");
        alumno.setPromedio(leerDouble());

        alumnoDAO.actualizar(alumno);
    }

    private static void registrarProfesor() throws IOException {
        Profesor profesor = new Profesor();
        System.out.print("Numero de empleado: ");
        profesor.setNumEmpleado(leerEntero());
        System.out.print("Nombre: ");
        profesor.setNombre(leer.readLine());
        System.out.print("CURP: ");
        profesor.setCurp(leer.readLine());
        System.out.print("Puesto: ");
        profesor.setPuesto(leer.readLine());
        System.out.print("Sueldo: ");
        profesor.setSueldo(leerDouble());

        profesorDAO.agregarProfesor(profesor);
    }

    private static void mostrarProfesores() {
        ArrayList<Profesor> profesores = profesorDAO.extraerProfesores();
        System.out.println("========== LISTA DE PROFESORES ==========");
        for (Profesor profesor : profesores) {
            System.out.println(profesor);
        }
    }

    private static int leerEntero() throws IOException {
        while (true) {
            try {
                return Integer.parseInt(leer.readLine());
            } catch (NumberFormatException err) {
                System.out.print("Escribe un numero entero valido: ");
            }
        }
    }

    private static double leerDouble() throws IOException {
        while (true) {
            try {
                return Double.parseDouble(leer.readLine());
            } catch (NumberFormatException err) {
                System.out.print("Escribe un numero valido: ");
            }
        }
    }

    public static void menu() throws IOException {
        int opcion;
        do {
            System.out.println("========== MENU UNIVERSIDAD UT ==========");
            System.out.println("Modulo profesores personalizado por: " + AUTOR_MODULO_PROFESORES);
            System.out.println("1.- Inscribir alumno");
            System.out.println("2.- Mostrar alumnos");
            System.out.println("3.- Actualizar alumno");
            System.out.println("4.- Registrar profesor");
            System.out.println("5.- Mostrar profesores");
            System.out.println("6.- Salir");
            System.out.println("========================================");
            System.out.print("Elige tu opcion: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    inscribirAlumno();
                    break;
                case 2:
                    mostrarAlumnos();
                    break;
                case 3:
                    actualizarAlumno();
                    break;
                case 4:
                    registrarProfesor();
                    break;
                case 5:
                    mostrarProfesores();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 6);
    }
}
