package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

public class LibroServicio {

    public void persistirLibro(EntityManager em) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Libro libro = new Libro();

        System.out.println("Ingrese el título del libro");
        String nombre = leer.next();
        libro.setTitulo(nombre);
        libro.setAlta(true);

        do {
            try {
                System.out.println("Ingrese el año de la edición del libro");
                int anio = leer.nextInt();
                if (anio > 1500 && anio < 2023) {
                    libro.setAnio(anio);
                    break;
                } else {
                    System.out.println("No está en el rango de fecha, tiene que ser entre 1500 y 2023");
                }
            } catch (Exception e) {
                System.out.println("No ingresaste un año válido");
                leer.next();
            }
        } while (true);

        do {
            try {
                System.out.println("Ingrese cuántos ejemplares tiene el libro");
                int ejemplares = leer.nextInt();
                libro.setEjemplares(ejemplares);
                libro.setEjemplaresRestantes(ejemplares);
                libro.setEjemplaresPrestados(0);
                break;
            } catch (Exception e) {
                System.out.println("No ingresaste un número válido");
                leer.next();
            }
        } while (true);
        boolean noEncontrado = true;
        do {
            System.out.println("Ingrese el nombre del autor");
            String nombreAutor = leer.next();
            List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
            for (Autor autor : autores) {
                if (autor.getNombre().equalsIgnoreCase(nombreAutor)) {
                    libro.setAutor(autor);
                    noEncontrado = false;
                }
            }
            if (noEncontrado) {
                System.out.println("Autor no encontrado");
                leer.next();
            }
        } while (noEncontrado);
        noEncontrado = true;
        do {
            System.out.println("Ingrese el nombre de la editorial");
            String nombreEditorial = leer.next();
            List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
            for (Editorial editorial : editoriales) {
                if (editorial.getNombre().equalsIgnoreCase(nombreEditorial)) {
                    libro.setEditorial(editorial);
                    noEncontrado = false;
                }
            }
            if (noEncontrado) {
                System.out.println("Editorial no encontrada");
                leer.next();
            }

        } while (noEncontrado);

        try {
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    public void prestarLibro(EntityManager em, Libro libro) {
        if (libro.getEjemplaresPrestados() < libro.getEjemplares()) {
            libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() + 1);
            libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() - 1);

            em.getTransaction().begin();
            em.merge(libro); // Actualiza el objeto libro en la base de datos
            em.getTransaction().commit();
        } else {
            System.out.println("No hay más libros para prestar");
        }
    }

    public void devolverLibro(EntityManager em, Libro libro) {
        if (libro.getEjemplaresPrestados() > 0) {
            libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() - 1);
            libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() + 1);

            em.getTransaction().begin();
            em.merge(libro); // Actualiza el objeto libro en la base de datos
            em.getTransaction().commit();
        } else {
            System.out.println("No hAy ningún libro que devolver");
        }
    }

}
