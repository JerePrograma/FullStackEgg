/*En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
crear otra Pelicula o no.
 */
package servicio;

import entidad.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PeliculaServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearPelicula(ArrayList<Pelicula> peliculas) {
        boolean bucle = true;
        do {
            Pelicula pelicula = new Pelicula();
            System.out.println("Ingrese el nombre de la pelicula");
            pelicula.setTitulo(leer.next());
            System.out.println("Ingrese el nombre del director");
            pelicula.setDirector(leer.next());
            System.out.println("Ingrese la duración de la película (en horas)");
            pelicula.setDuracion(leer.nextInt());
            peliculas.add(pelicula);
            System.out.println("Desea cargar otra pelicula? S/N");
            String respuesta = leer.next();
            if (respuesta.equalsIgnoreCase("N")) {
                bucle = false;
            }
        } while (bucle);
    }

    //• Mostrar en pantalla todas las películas.
    public void mostrarPeliculas(ArrayList<Pelicula> peliculas) {
        System.out.println("Lista de películas:");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.getTitulo());
        }
    }
//• Mostrar en pantalla todas las películas con una duración mayor a 1 hora.

    public void mostrarPeliculasDuracion(ArrayList<Pelicula> peliculas) {
        System.out.println("Lista de películas que duran más de una hora:");
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getDuracion() > 1) {
                System.out.println(pelicula.getTitulo());
            }
        }
    }

    //• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en pantalla.
    public void mostrarPelisOrdenadasMayor(ArrayList<Pelicula> peliculas) {
        Collections.sort(peliculas, Pelicula.compararDuracion);
        Collections.reverse(peliculas);
        System.out.println("Las pelis ordenadas por duración mayor a menor: ");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.getTitulo() + " con duración de " + pelicula.getDuracion());
        }
    }

    //• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en pantalla.
    public void mostrarPelisOrdenadasMenor(ArrayList<Pelicula> peliculas) {
        Collections.sort(peliculas, Pelicula.compararDuracion);
        System.out.println("Las pelis ordenadas por duración menor a mayor: ");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.getTitulo() + " con duración de " + pelicula.getDuracion());
        }
    }
    //• Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.

    public void mostrarPelisPorTitulo(ArrayList<Pelicula> peliculas) {
        Collections.sort(peliculas, Pelicula.compararTitulo);
        System.out.println("Las pelis ordenadas por titulo alfabeticamente: ");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.getTitulo());
        }
    }

    //• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
    public void mostrarPelisPorDirector(ArrayList<Pelicula> peliculas) {
        Collections.sort(peliculas, Pelicula.comprarDirector);
        System.out.println("Las pelis ordenadas por nombre del director: ");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.getDirector() + " con la pelicula de " + pelicula.getTitulo());
        }
    }
}
