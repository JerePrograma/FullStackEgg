/*Para esto,tendremos una clase Pelicula con el título, director y duración de la película (en duracion).
 */
package entidad;

import java.util.Comparator;

public class Pelicula {

    private String titulo;

    private String director;
    private Double duracion;

    public Pelicula(String titulo, String director, Double horas) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = horas;
    }

    public Pelicula() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double horas) {
        this.duracion = horas;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", director=" + director + ", horas=" + duracion + '}';
    }

    public static Comparator<Pelicula> compararDuracion = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            return p1.getDuracion().compareTo(p2.getDuracion());
        }
    };
    public static Comparator<Pelicula> compararTitulo = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            return p1.getTitulo().compareTo(p2.getTitulo());
        }
    };
    public static Comparator<Pelicula> compararDirector = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            return p1.getDirector().compareTo(p2.getDirector());
        }
    };
}
