package org.example.modelo;

public class Profesor extends PersonaUt {

    private int numEmpleado;
    private String puesto;
    private double sueldo;

    public Profesor(){}

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
        if(numEmpleado > 0){
            this.numEmpleado = numEmpleado;
        }else{
            System.out.println("Número de empleado inválido");
        }
    }

    public String getPuesto() {
        if(puesto == null || puesto.isBlank()){
            System.out.println("El puesto es requerido");
            return "";
        }
        return puesto;
    }

    public void setPuesto(String puesto) {
        if(puesto != null && !puesto.isBlank()){
            this.puesto = puesto;
        }else{
            System.out.println("El puesto es requerido");
        }
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        if(sueldo >= 0){
            this.sueldo = sueldo;
        }else{
            System.out.println("Sueldo inválido");
        }
    }

    @Override
    public String toString() {
        return "Número de Empleado: " + getNumEmpleado() + "\n" +
                super.toString() + "\n" +
                "Puesto: " + getPuesto() + "\n" +
                "Sueldo: $" + getSueldo() + "\n" +
                "=====================================";
    }
}