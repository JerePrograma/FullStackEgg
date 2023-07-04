package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import persistencia.LibroDao;

public class LibroServicio {

    private LibroDao dao = new LibroDao();

    public void guardarLibro() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean bucle2;
        do {
            bucle2 = false;
            System.out.println("Ingrese el título del libro");
            String nombre = leer.next();
            Libro libro = buscarLibroTitulo();
            if (libro == null) {
                libro.setTitulo(nombre);
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
                    List<Autor> autores = dao.consultaGenerica("autor", "nombre", nombreAutor);
                    for (Autor autor : autores) {
                        if (autor.getNombre().equalsIgnoreCase(nombreAutor)) {
                            libro.setAutor(autor);
                            noEncontrado = false;
                        }
                    }
                    if (noEncontrado) {
                        System.out.println("Autor no encontrado");
                    }
                } while (noEncontrado);
                noEncontrado = true;
                do {
                    System.out.println("Ingrese el nombre de la editorial");
                    String nombreEditorial = leer.next();
                    List<Editorial> editoriales = dao.consultaGenerica("editorial", "nombre", nombreEditorial);
                    for (Editorial editorial : editoriales) {
                        if (editorial.getNombre().equalsIgnoreCase(nombreEditorial)) {
                            libro.setEditorial(editorial);
                            noEncontrado = false;
                        }
                    }
                    if (noEncontrado) {
                        System.out.println("Editorial no encontrada");
                    }

                } while (noEncontrado);

                dao.persistirLibro(libro);
                System.out.println("¿Desea cargar otro libro? S/N");
                if (leer.next().equalsIgnoreCase("S")) {
                    bucle2 = true;
                }
            } else {
                System.out.println("Libro ya cargado.");
            }
        } while (bucle2);
    }

    public void prestarLibro(Libro libro) {
        if (libro.getEjemplaresPrestados() < libro.getEjemplares()) {
            libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() + 1);
            libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() - 1);
            dao.actualizarLibro(libro);
        } else {
            System.out.println("No hay más libros para prestar");
        }
    }

    public void devolverLibro(Libro libro) {
        if (libro.getEjemplaresPrestados() > 0) {
            libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() - 1);
            libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() + 1);
            dao.actualizarLibro(libro);
        } else {
            System.out.println("No hAy ningún libro que devolver");
        }
    }

    public void darBajaLibro() {
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
                    libro = buscarLibroIsbn();
                    break;
                case 2:
                    libro = buscarLibroTitulo();
                    break;
                case 3:
                    libro = buscarLibroAutor();
                    break;
                case 4:
                    libro = buscarLibroEditorial();
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
            dao.actualizarLibro(libro);
        }

        if (noEncontrado) {
            System.out.println("Libro no encontrado");
            leer.next();
        }
    }

    public Libro buscarLibroIsbn() {
        boolean noEncontrado = true;
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el ISBN del libro");
        long isbn = leer.nextLong();
        List<Libro> libros = dao.consultaLibros();
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
        return null;
    }

    public Libro buscarLibroTitulo() {
        boolean noEncontrado = true;
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el titulo del libro");
        String tituloLibro = leer.next();
        List<Libro> libros = dao.consultaGenerica("Libro", "titulo", tituloLibro);
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
        return null;
    }

    public Libro buscarLibroAutor() {
        boolean noEncontrado = true;
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre del autor");
        String nombreAutor = leer.next();
        List<Libro> libros = dao.consultaGenerica("Libro", "autor.nombre", nombreAutor);
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
        return libro2;
    }

    public Libro buscarLibroEditorial() {
        boolean noEncontrado = true;
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el nombre de la editorial");
        String nombreEditorial = leer.next();
        List<Libro> libros = dao.consultaGenerica("Libro", "editorial.nombre", nombreEditorial);
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
        return libro2;
    }

}
