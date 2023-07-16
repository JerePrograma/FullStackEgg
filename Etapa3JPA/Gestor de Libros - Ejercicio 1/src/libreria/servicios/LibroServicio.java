package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import persistencia.LibroDao;

public class LibroServicio {

    private LibroDao dao = new LibroDao();
    private AutorServicio as = new AutorServicio();
    private EditorialServicio es = new EditorialServicio();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void guardarLibro() {
        boolean bucle2;
        do {
            bucle2 = false;
            System.out.println("Ingrese el título del libro");
            String nombre = leer.next();
            Libro libro = buscarLibroTitulo(nombre);
            if (libro.getTitulo() == null) {
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
                        if (anio <= 2023) {
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
                    try {
                        List<Autor> autores = dao.consultaGenerica("Autor", "nombre", nombreAutor);
                        for (Autor autor : autores) {
                            if (autor.getNombre().equalsIgnoreCase(nombreAutor)) {
                                libro.setAutor(autor);
                                noEncontrado = false;
                            }
                        }
                    } catch (Exception e) {

                    }
                    if (noEncontrado) {
                        System.out.println("Autor no encontrado");
                        System.out.println("¿Desea registrarlo? S/N");
                        String respuesta = leer.next();
                        if (respuesta.equalsIgnoreCase("S")) {
                            Autor autor = new Autor();
                            autor.setNombre(nombreAutor);
                            autor.setAlta(true);
                            as.guardarAutor(autor);
                            libro.setAutor(autor);
                            noEncontrado = false;
                        }
                    }
                } while (noEncontrado);
                noEncontrado = true;
                do {
                    System.out.println("Ingrese el nombre de la editorial");
                    String nombreEditorial = leer.next();
                    try {
                        List<Editorial> editoriales = dao.consultaGenerica("Editorial", "nombre", nombreEditorial);
                        for (Editorial editorial : editoriales) {
                            if (editorial.getNombre().equalsIgnoreCase(nombreEditorial)) {
                                libro.setEditorial(editorial);
                                noEncontrado = false;
                            }
                        }
                    } catch (Exception e) {
                    }
                    if (noEncontrado) {
                        System.out.println("Editorial no encontrada");
                        System.out.println("¿Desea registrarla? S/N");
                        String respuesta = leer.next();
                        if (respuesta.equalsIgnoreCase("S")) {
                            Editorial editorial = new Editorial();
                            editorial.setNombre(nombreEditorial);
                            editorial.setAlta(true);
                            es.guardarEditorial(editorial);
                            libro.setEditorial(editorial);
                            noEncontrado = false;
                        }
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
        if (libro.getEjemplaresPrestados() < libro.getEjemplaresRestantes()) {
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
            System.out.println("No hay ningún libro que devolver");
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
                    System.out.println("Ingrese el nombre del autor:");
                    String autor = leer.next();
                    List<Libro> librosAutor = buscarLibroAutor(autor);
                    if (librosAutor.isEmpty()) {
                        System.out.println("No se encontraron libros de " + autor);
                    } else {
                        System.out.println("Libros de " + autor + ":");
                        for (int i = 0; i < librosAutor.size(); i++) {
                            System.out.println((i + 1) + ". " + librosAutor.get(i));
                        }
                        System.out.println("Seleccione un libro (1-" + librosAutor.size() + "):");
                        int indiceAutor = leer.nextInt() - 1;
                        libro = librosAutor.get(indiceAutor);
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de la editorial:");
                    String editorial = leer.next();
                    List<Libro> librosEditorial = buscarLibroEditorial(editorial);
                    if (librosEditorial.isEmpty()) {
                        System.out.println("No se encontraron libros de la editorial " + editorial);
                    } else {
                        System.out.println("Libros de la editorial " + editorial + ":");
                        for (int i = 0; i < librosEditorial.size(); i++) {
                            System.out.println((i + 1) + ". " + librosEditorial.get(i));
                        }
                        System.out.println("Seleccione un libro (1-" + librosEditorial.size() + "):");
                        int indiceEditorial = leer.nextInt() - 1;
                        libro = librosEditorial.get(indiceEditorial);
                    }
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
                        bucle2 = true;
                }
            } while (bucle2);
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
        Libro libro = (Libro) dao.buscarPorIsbn(isbn);
        if (libro != null) {
            System.out.println("Libro encontrado");
            System.out.println(libro);
            noEncontrado = false;
        }

        if (noEncontrado) {
            System.out.println("Libro no encontrado");
            leer.next();
        }

        return libro;
    }

    public Libro buscarLibroTitulo(String tituloLibro) {
        boolean noEncontrado = true;
        List<Libro> libros = dao.consultaGenerica("Libro", "titulo", tituloLibro);
        if (!libros.isEmpty()) {
            for (Libro libro : libros) {
                if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                    System.out.println("Libro ya registrado");
                    System.out.println(libro);
                    return libro;
                }
            }
        }
        return new Libro();
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
        }
        return null;
    }

    public void buscarLibroAutor() {
        System.out.println("Ingrese el nombre del autor");
        String nombreAutor = leer.next();
        List<Libro> librosCoincidentes = dao.consultaGenerica("Libro", "autor.nombre", nombreAutor);
        if (librosCoincidentes.isEmpty()) {
            System.out.println("No se encontraron libros del autor " + nombreAutor);
        } else {
            System.out.println("Libros de " + nombreAutor + ":");
            for (Libro libro : librosCoincidentes) {
                System.out.println(libro);
            }
        }
    }

    public void buscarLibroEditorial() {
        System.out.println("Ingrese el nombre de la editorial");
        String nombreEditorial = leer.next();
        List<Libro> librosCoincidentes = dao.consultaGenerica("Libro", "editorial.nombre", nombreEditorial);
        if (librosCoincidentes.isEmpty()) {
            System.out.println("No se encontraron libros de la editorial " + nombreEditorial);
        } else {
            System.out.println("Libros de " + nombreEditorial + ":");
            for (Libro libro : librosCoincidentes) {
                System.out.println(libro);
            }
        }
    }

    public List<Libro> buscarLibroAutor(String autor) {
        return dao.consultaGenerica("Libro", "autor.nombre", autor);
    }

    public List<Libro> buscarLibroEditorial(String editorial) {
        return dao.consultaGenerica("Libro", "editorial.nombre", editorial);
    }
}
