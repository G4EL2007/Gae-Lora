package org.example;

public class Serie extends ContenidoMultimedia {

    private int temporadas;
    private int episodios;
    private int duracionEpisodio;

    public Serie(String titulo, String autor, int anio,
                 int temporadas, int episodios, int duracionEpisodio) {

        super(titulo, autor, anio);

        this.temporadas = temporadas;
        this.episodios = episodios;
        this.duracionEpisodio = duracionEpisodio;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo serie: " + titulo);
    }

    @Override
    public String obtenerTipoContenido() {
        return "Serie";
    }

    @Override
    public int obtenerTiempoTotal() {
        return episodios * duracionEpisodio;
    }

    public int numeroDeEpisodios() {
        return episodios;
    }

    @Override
    public String obtenerDatosParticulares() {
        return "Temporadas: " + temporadas +
                "\nEpisodios: " + episodios;
    }
}