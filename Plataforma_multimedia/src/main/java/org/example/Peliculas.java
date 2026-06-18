package org.example;

public class Peliculas extends ContenidoMultimedia {

    private int duracion;

    public Peliculas(String titulo, String autor, int anio, int duracion) {
        super(titulo, autor, anio);
        this.duracion = duracion;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo pelicula: " + titulo);
    }

    @Override
    public String obtenerTipoContenido() {
        return "Pelicula";
    }

    @Override
    public int obtenerTiempoTotal() {
        return duracion;
    }

    @Override
    public String obtenerDatosParticulares() {
        return "Duracion: " + duracion + " minutos";
    }
}