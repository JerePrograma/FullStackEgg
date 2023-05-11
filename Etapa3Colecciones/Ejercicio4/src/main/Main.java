/*Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
tendremos una clase Pelicula con el título, director y duración de la película (en horas).
Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
que se pide a continuación:
En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones: */
package main;

import entidad.Pelicula;
import java.util.ArrayList;
import servicio.PeliculaServicio;

public class Main {

    public static void main(String[] args) {
        ArrayList<Pelicula> pelis = new ArrayList();
        PeliculaServicio ps = new PeliculaServicio();

        System.out.println("---------------------------------");
        ps.crearPelicula(pelis);
        System.out.println("---------------------------------");
        ps.mostrarPeliculas(pelis);
        System.out.println("---------------------------------");
        ps.mostrarPeliculasDuracion(pelis);
        System.out.println("---------------------------------");
        ps.mostrarPelisOrdenadasMayor(pelis);
        System.out.println("---------------------------------");
        ps.mostrarPelisOrdenadasMenor(pelis);
        System.out.println("---------------------------------");
        ps.mostrarPelisPorDirector(pelis);
        System.out.println("---------------------------------");
        ps.mostrarPelisPorTitulo(pelis);
        System.out.println("---------------------------------");

    }
}
