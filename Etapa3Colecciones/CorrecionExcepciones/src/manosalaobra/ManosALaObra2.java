package manosalaobra;

import entidad.Libro;
import java.util.ArrayList;

public class ManosALaObra2 {

    public static void main(String[] args) {
        ArrayList<Libro> libros = new ArrayList();
        Libro libro1 = new Libro("Esta noche digo adios");
        Libro libro2 = new Libro("A");
        Libro libro3 = new Libro("B");
        Libro libro4 = new Libro("C");
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);

        for (Libro libro : libros) {
            System.out.println(libro);
        }

    }
}
