package org.example;

public abstract class ContenidoMultimedia {

    protected String titulo;
    protected String autor;
    protected int anio;

    public ContenidoMultimedia(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public abstract void reproducir();

    public abstract String obtenerTipoContenido();

    public abstract int obtenerTiempoTotal();

    public abstract String obtenerDatosParticulares();

    public String obtenerDatosGenerales() {
        return "Titulo: " + titulo +
                "\nAutor: " + autor +
                "\nAño: " + anio;
    }
}