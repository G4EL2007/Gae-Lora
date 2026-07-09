package org.example.modelo;

public class PersonaUt {
    private String nombre;
    private String curp;

    public PersonaUt() {
    }

    public PersonaUt(String nombre, String curp) {
        setNombre(nombre);
        setCurp(curp);
    }

    public String getNombre() {
        return nombre == null ? "" : nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = formatearNombre(nombre);
        } else {
            System.out.println("El nombre es requerido");
        }
    }

    public String getCurp() {
        return curp == null ? "" : curp;
    }

    public void setCurp(String curp) {
        if (curp != null) {
            String curpFormateada = curp.trim().toUpperCase();
            if (curpFormateada.length() == 18 && curpFormateada.matches("[A-Z0-9]+")) {
                this.curp = curpFormateada;
            } else {
                System.out.println("CURP invalido. Debe tener 18 caracteres alfanumericos");
            }
        } else {
            System.out.println("CURP invalido");
        }
    }

    protected String formatearNombre(String texto) {
        String[] palabras = texto.trim().toLowerCase().split("\\s+");
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                resultado.append(Character.toUpperCase(palabra.charAt(0)))
                        .append(palabra.substring(1))
                        .append(" ");
            }
        }
        return resultado.toString().trim();
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + "\n" +
                "CURP: " + getCurp();
    }
}
