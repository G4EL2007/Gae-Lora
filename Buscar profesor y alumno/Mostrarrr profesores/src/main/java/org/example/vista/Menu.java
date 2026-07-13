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
        Alumno alumnoNuevo = new Alumno();

        try {
            System.out.print("Nombre: ");
            alumnoNuevo.setNombre(leer.readLine());
            System.out.print("CURP: ");
            alumnoNuevo.setCurp(leer.readLine());
            System.out.print("Numero de Expediente: ");
            alumnoNuevo.setNumExpediente(Integer.parseInt(leer.readLine()));
            System.out.print("Grupo: ");
            alumnoNuevo.setGrupo(leer.readLine());
            System.out.print("Promedio: ");
            alumnoNuevo.setPromedio(Double.parseDouble(leer.readLine()));

            if (alumnoNuevo.getNumExpediente() <= 0) {
                System.out.println("Registro cancelado: expediente invalido.");
                return;
            }

            alumnoDAO.inscribirAlumno(alumnoNuevo);
        } catch (NumberFormatException err) {
            System.out.println("El expediente debe ser entero y el promedio debe ser numerico.");
        }
    }

    private static void mostrarAlumnos() {
        ArrayList<Alumno> alumnos = alumnoDAO.extraerAlumno();

        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }


    private static void buscarAlumno() throws IOException {
        try {
            System.out.println("\n===== BUSCAR ALUMNO =====");
            System.out.print("Numero de expediente: ");
            int numExpediente = Integer.parseInt(leer.readLine());

            if (numExpediente <= 0) {
                System.out.println("El numero de expediente debe ser mayor que cero.");
                return;
            }

            Alumno alumnoEncontrado = alumnoDAO.buscarPorExpediente(numExpediente);

            if (alumnoEncontrado != null) {
                System.out.println("\nAlumno encontrado:");
                System.out.println(alumnoEncontrado);
            } else {
                System.out.println("No existe un alumno con ese numero de expediente.");
            }
        } catch (NumberFormatException err) {
            System.out.println("El numero de expediente debe ser numerico.");
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


    private static void buscarProfesor() throws IOException {
        try {
            System.out.println("\n===== BUSCAR PROFESOR =====");
            System.out.print("Numero de empleado: ");
            int numEmpleado = Integer.parseInt(leer.readLine());

            if (numEmpleado <= 0) {
                System.out.println("El numero de empleado debe ser mayor que cero.");
                return;
            }

            Profesor profesorEncontrado = profesorDAO.buscarPorNumEmpleado(numEmpleado);

            if (profesorEncontrado != null) {
                System.out.println("\nProfesor encontrado:");
                System.out.println(profesorEncontrado);
            } else {
                System.out.println("No existe un profesor con ese numero de empleado.");
            }
        } catch (NumberFormatException err) {
            System.out.println("El numero de empleado debe ser numerico.");
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
            System.out.println("8.- Buscar Alumno");
            System.out.println("9.- Buscar Profesor");
            System.out.println("10.- Salir");
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
                        buscarAlumno();
                        break;
                    case 9:
                        buscarProfesor();
                        break;
                    case 10:
                        System.out.println("Programa finalizado.");
                        break;
                    default:
                        System.out.println("Opcion invalida.");
                }
            } catch (NumberFormatException err) {
                System.out.println("Debes escribir un numero del 1 al 10.");
            }
        } while (opcion != 10);
    }
}
