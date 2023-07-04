package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

public class LibroServicio {

    public void persistirLibro(EntityManager em) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean bucle2;
        do {
            bucle2 = false;
            Libro libro = new Libro();
            do {
                try {
                    System.out.println("Ingrese el ISBN del libro");
                    long isbn = leer.nextLong();
                    libro.setIsbn(isbn);
                    break;
                } catch (Exception e) {
                    System.out.println("No ingresaste un ISBN válido");
                    leer.next();
                }
            } while (true);

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
            System.out.println("¿Desea cargar otro libro? S/N");
            if (leer.next().equalsIgnoreCase("S")) {
                bucle2 = true;
            }
        } while (bucle2);
    }

    public void prestarLibro(EntityManager em, Libro libro) {
        if (libro.getEjemplaresPrestados() < libro.getEjemplares()) {
            libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() + 1);
            libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() - 1);
            try {
                em.getTransaction().begin();
                em.merge(libro);
                em.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("No se pudo actualizar el estado");
            } finally {
                em.close();
            }
        } else {
            System.out.println("No hay más libros para prestar");
        }
    }

    public void devolverLibro(EntityManager em, Libro libro) {
        if (libro.getEjemplaresPrestados() > 0) {
            libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() - 1);
            libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() + 1);
            try {
                em.getTransaction().begin();
                em.merge(libro);
                em.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("No se pudo actualizar el estado");
            } finally {
                em.close();
            }
        } else {
            System.out.println("No hAy ningún libro que devolver");
        }
    }

    public void darBajaLibro(EntityManager em) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Libro libro = null;
        boolean bucle;
        do {
            System.out.println("1. Buscar libro por ISBN");
            System.out.println("2. Buscar libro por Título");
            System.out.println("3. Buscar libro/s por nombre de Autor");
            System.out.println("4. Buscar libro/s por nombre de Editorial");
            int option = leer.nextInt();
            bucle = false;
            switch (option) {
                case 1:
                    libro = buscarLibroIsbn(em);
                    break;
                case 2:
                    libro = buscarLibroTitulo(em);
                    break;
                case 3:
                    libro = buscarLibroAutor(em);
                    break;
                case 4:
                    libro = buscarLibroEditorial(em);
                    break;
                default:
                    System.out.println("Opción no reconocida");
                    bucle = true;
            }
        } while (bucle);

        boolean noEncontrado = true;
        if (libro != null) {
            boolean alta = true;
            boolean bucle2;
            do {
                bucle2 = false;
                System.out.println("1- Darlo de baja");
                System.out.println("2- Darlo de alta");
                int opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        alta = false;
                        break;
                    case 2:
                        alta = true;
                        break;
                    default:
                        System.out.println("Opción no reconocida");
                        bucle = true;
                }
            } while (bucle);
            libro.setAlta(alta);
            noEncontrado = false;
            try {
                em.getTransaction().begin();
                em.persist(libro);
                em.getTransaction().commit();

            } catch (Exception e) {
                System.out.println("No se pudo actualizar el estado");
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            } finally {
                em.close();
            }
        }

        if (noEncontrado) {
            System.out.println("Libro no encontrado");
            leer.next();
        }
    }

    public Libro buscarLibroIsbn(EntityManager em) {
        em.getTransaction().begin();
        boolean noEncontrado = true;
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el ISBN del libro");
        long isbn = leer.nextLong();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
        for (Libro libro : libros) {
            if (libro.getIsbn() == isbn) {
                System.out.println("Libro encontrado");
                System.out.println(libro);
                return libro;
            }
        }
        if (noEncontrado) {
            System.out.println("Libro no encontrado");
            leer.next();
        }
        em.close();
        return null;
    }

    public Libro buscarLibroTitulo(EntityManager em) {
        em.getTransaction().begin();
        boolean noEncontrado = true;
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el titulo del libro");
        String tituloLibro = leer.next();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                System.out.println("Libro encontrado");
                System.out.println(libro);
                return libro;
            }
        }
        if (noEncontrado) {
            System.out.println("Libro no encontrado");
            leer.next();
        }
        em.close();
        return null;
    }

    public Libro buscarLibroAutor(EntityManager em) {
        em.getTransaction().begin();
        boolean noEncontrado = true;
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre del autor");
        String nombreAutor = leer.next();
        String jpql = "SELECT l FROM Libro l WHERE l.autor.nombre = :nombreAutor";
        TypedQuery<Libro> query = em.createQuery(jpql, Libro.class
        );
        query.setParameter("nombreAutor", nombreAutor);
        List<Libro> libros = query.getResultList();

        Libro libro2 = null;
        if (!libros.isEmpty()) {
            System.out.println("Libros encontrados");
            for (Libro libro : libros) {
                System.out.println(libro);
                libro2 = libro;
            }
            noEncontrado = false;
        }

        if (noEncontrado) {
            System.out.println("Libro no encontrado");
        }
        em.close();
        return libro2;
    }

    public Libro buscarLibroEditorial(EntityManager em) {
        em.getTransaction().begin();
        boolean noEncontrado = true;
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el nombre de la editorial");
        String nombreEditorial = leer.next();
        String jpql = "SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :nombreEditorial";
        TypedQuery<Libro> query = em.createQuery(jpql, Libro.class
        );
        query.setParameter("nombreEditorial", "%" + nombreEditorial + "%");
        List<Libro> libros = query.getResultList();

        Libro libro2 = null;
        if (!libros.isEmpty()) {
            System.out.println("Libros encontrados");
            for (Libro libro : libros) {
                System.out.println(libro);
                libro2 = libro;
            }
            noEncontrado = false;
        }
        if (noEncontrado) {
            System.out.println("Libro no encontrado");
        }
        em.close();
        return libro2;
    }

}
