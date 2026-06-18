package org.example;

public class Podcast extends ContenidoMultimedia {

    private int capitulos;
    private int duracionPromedio;

    public Podcast(String titulo, String autor, int anio,
                   int capitulos, int duracionPromedio) {

        super(titulo, autor, anio);

        this.capitulos = capitulos;
        this.duracionPromedio = duracionPromedio;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo podcast: " + titulo);
    }

    @Override
    public String obtenerTipoContenido() {
        return "Podcast";
    }

    @Override
    public int obtenerTiempoTotal() {
        return capitulos * duracionPromedio;
    }

    @Override
    public String obtenerDatosParticulares() {
        return "Capitulos: " + capitulos +
                "\nDuracion promedio: " + duracionPromedio + " minutos";
    }
}