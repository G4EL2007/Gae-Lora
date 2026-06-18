package org.example;

public class Main {

    public static void main(String[] args) {

        Serie serie = new Serie(
                "Breaking Bad",
                "Vince Gilligan",
                2008,
                5,
                62,
                47
        );

        Peliculas pelicula = new Peliculas(
                "Avatar",
                "James Cameron",
                2009,
                162
        );

        Podcast podcast = new Podcast(
                "Tecnologia Hoy",
                "Juan Perez",
                2024,
                50,
                30
        );

        System.out.println("=== TIPOS DE CONTENIDO ===");
        System.out.println(serie.obtenerTipoContenido());
        System.out.println(pelicula.obtenerTipoContenido());
        System.out.println(podcast.obtenerTipoContenido());

        System.out.println("\n=== TIEMPO TOTAL ===");
        System.out.println("Serie: " + serie.obtenerTiempoTotal() + " minutos");
        System.out.println("Pelicula: " + pelicula.obtenerTiempoTotal() + " minutos");
        System.out.println("Podcast: " + podcast.obtenerTiempoTotal() + " minutos");

        System.out.println("\n=== DATOS GENERALES ===");
        System.out.println(serie.obtenerDatosGenerales());

        System.out.println("\n=== DATOS PARTICULARES ===");
        System.out.println(serie.obtenerDatosParticulares());

        System.out.println("\n=== NUMERO DE EPISODIOS ===");
        System.out.println(serie.numeroDeEpisodios());

    }
}