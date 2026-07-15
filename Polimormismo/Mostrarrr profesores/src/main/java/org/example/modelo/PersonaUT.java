package org.example.modelo;

// Es abstracta porque una persona de la universidad debe ser Alumno o Profesor.
public abstract class PersonaUT {
    private String nombre;
    private String curp;

    public PersonaUT() {
    }

    public PersonaUT(String nombre, String curp) {
        setNombre(nombre);
        setCurp(curp);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            System.out.println("El nombre no puede quedar vacio.");
        }
    }

    public String getCurp() {
        return curp == null ? "" : curp.toUpperCase();
    }

    public void setCurp(String curp) {
        if (curp != null && curp.trim().length() == 18) {
            this.curp = curp.trim().toUpperCase();
        } else {
            System.out.println("La CURP debe tener 18 caracteres.");
        }
    }

    // Cada clase hija debe indicar que tipo de persona representa.
    public abstract String mostrarTipoPersona();

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + "\n" +
                "CURP: " + getCurp();
    }
}
