package org.example.modelo;

// Ajustes del modulo de profesores: Gael Lora
public class Profesor extends PersonaUt {
    private static final double SUELDO_MINIMO = 1.0;

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
            System.out.println("Numero de empleado invalido");
        }
    }

    public String getPuesto() {
        return puesto == null ? "" : puesto;
    }

    public void setPuesto(String puesto) {
        if (esTextoValido(puesto)) {
            this.puesto = formatearNombre(puesto);
        } else {
            System.out.println("El puesto es requerido");
        }
    }

    public double getSueldo() {
        return redondearSueldo(sueldo);
    }

    public void setSueldo(double sueldo) {
        if (sueldo >= SUELDO_MINIMO) {
            this.sueldo = redondearSueldo(sueldo);
        } else {
            System.out.println("Sueldo invalido. Debe ser mayor a 0");
        }
    }

    private boolean esTextoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    private double redondearSueldo(double cantidad) {
        return Math.round(cantidad * 100.0) / 100.0;
    }

    public boolean esValido() {
        return getNumEmpleado() > 0
                && !getNombre().isEmpty()
                && !getCurp().isEmpty()
                && !getPuesto().isEmpty()
                && getSueldo() >= SUELDO_MINIMO;
    }

    @Override
    public String toString() {
        return "Numero de empleado: " + getNumEmpleado() + "\n" +
                super.toString() + "\n" +
                "Puesto: " + getPuesto() + "\n" +
                "Sueldo: $" + String.format("%.2f", getSueldo()) + "\n" +
                "Modulo personalizado por: Gael Lora\n" +
                "=====================================";
    }
}
