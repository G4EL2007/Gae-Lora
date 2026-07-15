package org.example.modelo;

public class Alumno extends PersonaUT implements Ensenable, Evaluable {
    private int numExpediente;
    private String grupo;
    private double promedio;

    public Alumno() {
    }

    public Alumno(String nombre, String curp, int numExpediente, String grupo, double promedio) {
        super(nombre, curp);
        setNumExpediente(numExpediente);
        setGrupo(grupo);
        setPromedio(promedio);
    }

    public int getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(int numExpediente) {
        if (numExpediente > 0) {
            this.numExpediente = numExpediente;
        } else {
            System.out.println("El numero de expediente debe ser mayor que cero.");
        }
    }

    public String getGrupo() {
        return grupo == null ? "" : grupo;
    }

    public void setGrupo(String grupo) {
        if (grupo != null && !grupo.isBlank()) {
            this.grupo = grupo.trim().toUpperCase();
        } else {
            System.out.println("El grupo es requerido.");
        }
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        if (promedio >= 0 && promedio <= 10) {
            this.promedio = promedio;
        } else {
            System.out.println("El promedio debe estar entre 0 y 10.");
        }
    }

    @Override
    public String mostrarTipoPersona() {
        return "Tipo de persona: Alumno";
    }

    @Override
    public String aprender() {
        return "Actividad: aprende y participa en sus clases.";
    }

    @Override
    public String recibirEvaluacion() {
        return "Evaluacion: recibe calificaciones para conocer su avance.";
    }

    @Override
    public String toString() {
        return mostrarTipoPersona() + "\n" +
                "Numero de expediente: " + getNumExpediente() + "\n" +
                super.toString() + "\n" +
                "Grupo: " + getGrupo() + "\n" +
                "Promedio: " + getPromedio() + "\n" +
                aprender() + "\n" +
                recibirEvaluacion() + "\n" +
                "=====================================";
    }
}
