/*En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
crear otra Pelicula o no.
//    Después de ese bucle realizaremos las siguientes acciones:
//• Mostrar en pantalla todas las películas.
//• Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
//• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en
//pantalla.
//• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en
//pantalla.
//• Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.
//• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
 */
package servicio;

import entidad.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PeliculaServicio {

    public ArrayList<Pelicula> crearListaPeliculas() {
        ArrayList<Pelicula> peliculas = new ArrayList();
        boolean confirmacion = true;
        do {
            Pelicula pelicula = new Pelicula();
            Scanner leer = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Ingrese el nombre del director");
            pelicula.setDirector(leer.next());
            System.out.println("Ingrese el título de la película");
            pelicula.setTitulo(leer.next());
            System.out.println("Ingrese la duración de la película");
            pelicula.setDuracion(leer.nextDouble());
            peliculas.add(pelicula);
            System.out.println("Desea ingresar otra pelicula? S/N");
            if (leer.next().equalsIgnoreCase("N")) {
                confirmacion = false;
            }
        } while (confirmacion);
        return peliculas;
    }


    public void mostrarPeliculas(ArrayList<Pelicula> peliculas) {
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    public void mostrarPeliculasDuracion(ArrayList<Pelicula> peliculas) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getDuracion() > 1) {
                System.out.println(pelicula);
            }
        }
    }

    public void ordenarDuracionMayor(ArrayList<Pelicula> peliculas) {
        peliculas.sort(Pelicula.compararDuracion);
        Collections.reverse(peliculas);
        mostrarPeliculas(peliculas);
    }

    public void mostrarDuracionMenor(ArrayList<Pelicula> peliculas) {
        peliculas.sort(Pelicula.compararDuracion);
        mostrarPeliculas(peliculas);
    }

    public void mostrarTitulo(ArrayList<Pelicula> peliculas) {
        peliculas.sort(Pelicula.compararTitulo);
        mostrarPeliculas(peliculas);
    }

    public void mostrarDirector(ArrayList<Pelicula> peliculas) {
        peliculas.sort(Pelicula.compararDirector);
        mostrarPeliculas(peliculas);
    }
}
