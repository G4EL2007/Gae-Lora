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
        System.out.print("Numero de Empleado: ");
        profesor.setNumEmpleado(Integer.parseInt(leer.readLine()));
        System.out.print("Nombre: ");
        profesor.setNombre(leer.readLine());
        System.out.print("CURP: ");
        profesor.setCurp(leer.readLine());
        System.out.print("Puesto: ");
        profesor.setPuesto(leer.readLine());
        System.out.print("Sueldo: ");
        profesor.setSueldo(Double.parseDouble(leer.readLine()));

        profesorDAO.actualizar(profesor);
    }

    // ---------- MENU ----------

    public static void menu() throws IOException {

        int opcion = 0;

        do {
            System.out.println("========== MENU ==========");
            System.out.println("1.- Inscribir Alumno");
            System.out.println("2.- Mostrar Alumnos");
            System.out.println("3.- Actualizar Alumno");
            System.out.println("4.- Registrar Profesor");
            System.out.println("5.- Mostrar Profesores");
            System.out.println("6.- Actualizar Profesor");
            System.out.println("7.- Salir");
            System.out.print("Opcion: ");

            opcion = Integer.parseInt(leer.readLine());

            switch (opcion) {
                case 1:
                    inscribir();
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
                    actualizarProfesor();
                    break;
                case 7:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 7);
    }
}