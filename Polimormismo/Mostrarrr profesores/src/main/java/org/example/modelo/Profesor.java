package org.example.modelo;

public class Profesor extends PersonaUT implements Ensenador, Evaluador {

    private int numEmpleado;
    private String puesto;
    private double sueldo;

    public Profesor() {
    }

    public Profesor(String nombre, String curp, int numEmpleado, String puesto, double sueldo) {
        super(nombre, curp);
        setNumEmpleado(numEmpleado);
        setPuesto(puesto);
        setSueldo(sueldo);
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        if (numEmpleado > 0) {
            this.numEmpleado = numEmpleado;
        } else {
            System.out.println("El numero de empleado debe ser mayor que cero.");
        }
    }

    public String getPuesto() {
        return puesto == null ? "" : puesto;
    }

    public void setPuesto(String puesto) {
        if (puesto != null && !puesto.isBlank()) {
            this.puesto = puesto.trim();
        } else {
            System.out.println("El puesto es requerido.");
        }
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        if (sueldo >= 0) {
            this.sueldo = sueldo;
        } else {
            System.out.println("El sueldo no puede ser negativo.");
        }
    }

    @Override
    public String mostrarTipoPersona() {
        return "Tipo de persona: Profesor";
    }

    @Override
    public String ensenar() {
        return "Actividad: comparte sus conocimientos con los alumnos.";
    }

    @Override
    public String evaluar() {
        return "Evaluacion: revisa el aprendizaje y da retroalimentacion.";
    }

    @Override
    public String toString() {
        return mostrarTipoPersona() + "\n" +
                "Numero de empleado: " + getNumEmpleado() + "\n" +
                super.toString() + "\n" +
                "Puesto: " + getPuesto() + "\n" +
                "Sueldo: $" + getSueldo() + "\n" +
                ensenar() + "\n" +
                evaluar() + "\n" +
                "=====================================";
    }
}
