package servicios;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import java.util.List;
import java.util.Scanner;
import persistencia.LibroDAO;

public class LibroServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    LibroDAO dao = new LibroDAO();
    AutorServicio as = new AutorServicio();
    EditorialServicio es = new EditorialServicio();

    public void crearLibro() {
        Libro libro = new Libro();
        do {
            System.out.println("Ingrese el ISBN del libro");
            try {
                long ISBN = leer.nextLong();
                libro.setISBN(ISBN);
                if (buscarLibroISBN(ISBN)) {
                    break;
                } else {
                    System.out.println("ISBN ya está registrado");
                }
            } catch (Exception e) {
                System.out.println("Error al cargar el ISBN");
                leer.next();
            }
        } while (true);

        do {
            System.out.println("Ingrese el titulo del libro");
            String titulo = leer.next();
            libro.setTitulo(titulo);
            if (buscarLibroTitulo(titulo).isEmpty()) {
                break;
            } else {
                System.out.println("Titulo del libro ya existe");
            }
        } while (true);
        do {
            System.out.println("Ingrese el año de edición");
            try {
                int anio = leer.nextInt();
                libro.setAnio(anio);
                break;
            } catch (Exception e) {
                System.out.println("Error al cargar el año");
                leer.next();
            }
        } while (true);
        do {
            System.out.println("Ingrese la cantidad de ejemplares");
            try {
                int cantidadEjemplares = leer.nextInt();
                libro.setEjemplares(cantidadEjemplares);
                libro.setEjemplaresRestantes(cantidadEjemplares);
                libro.setEjemplaresPrestados(0);
                break;
            } catch (Exception e) {
                System.out.println("Error al ingresar la cantidad de ejemplares");
                leer.next();
            }
        } while (true);
        libro.setAlta(true);
        do {
            System.out.println("Ingrese el nombre del autor");
            String nombreAutor = leer.next();
            if (as.buscarAutorNombre(nombreAutor).isEmpty()) {
                System.out.println("Autor no encontrado, ¿desea registrarlo? S/N");
                String respuesta = leer.next();
                if (respuesta.equalsIgnoreCase("S")) {
                    Autor autor = as.crearAutor(nombreAutor);
                    libro.setAutor(autor);
                    break;
                }
            } else {
                System.out.println("Autor ya registrado");
                libro.setAutor(as.buscarAutorNombre(nombreAutor).get(0));
                break;
            }
        } while (true);
        do {
            System.out.println("Ingrese el nombre de la editorial");
            String nombreEditorial = leer.next();
            if (es.buscarEditorialNombre(nombreEditorial).isEmpty()) {
                System.out.println("Editorial no encontrada, ¿desea registrarla? S/N");
                String respuesta = leer.next();
                if (respuesta.equalsIgnoreCase("S")) {
                    Editorial editorial = es.crearEditorial(nombreEditorial);
                    libro.setEditorial(editorial);
                    break;
                }
            } else {
                System.out.println("Editorial ya registrada");
                libro.setEditorial(es.buscarEditorialNombre(nombreEditorial).get(0));
                break;
            }
        } while (true);
        dao.persistirEntidad(libro);
    }

    public void buscarLibroTitulo() {
        System.out.println("Ingrese el titulo del libro");
        String titulo = leer.next();
        List<Libro> libros = dao.buscarLibroTitulo(titulo);
        if (libros.isEmpty()) {
            System.out.println("No hay libros con ese título");
        } else {
            System.out.println(libros);
        }
    }

    public List<Libro> buscarLibroTitulo(String titulo) {
        List<Libro> libros = dao.buscarLibroTitulo(titulo);
        return libros;
    }

    public void buscarLibroAutor() {
        System.out.println("Ingrese el nombre del autor");
        String nombreAutor = leer.next();
        List<Libro> libros = dao.buscarLibroAutor(nombreAutor);
        if (libros.isEmpty()) {
            System.out.println("No hay libros de ese autor");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }

    public void buscarLibroEditorial() {
        System.out.println("Ingrese el nombre de la editorial");
        String editorial = leer.next();
        List<Libro> libros = dao.buscarLibroEditorial(editorial);
        if (libros.isEmpty()) {
            System.out.println("No hay libros de esa editorial");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }

    }

    public void darAltaBajaModificar() {
        long ISBN;
        do {
            System.out.println("Ingrese el ISBN del libro que desea dar alta/baja/modificar");
            try {
                ISBN = leer.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Error al ingresar el id");
            }
        } while (true);
        Libro libro = dao.buscarLibroISBN(ISBN);
        int opcion;
        do {
            System.out.println("1- Alta/Baja \n2 - Modificar");
            try {
                opcion = leer.nextInt();
                if (!(opcion == 1 || opcion == 2)) {
                    System.out.println("Opción mal ingresada");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Opción mal ingresada");
            }
        } while (true);
        switch (opcion) {
            case 1:
                if (libro.getAlta()) {
                    libro.setAlta(false);
                } else {
                    libro.setAlta(true);
                }
                break;
            case 2:
                System.out.println("Seleccione qué desea cambiar:");
                System.out.println("1- Año de edición");
                System.out.println("2- El autor");
                System.out.println("3- La editorial");
                System.out.println("4- El título");
                System.out.println("5- La cantidad de ejemplares");
                opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        do {
                            try {
                                System.out.println("Ingrese el año:");
                                int anio = leer.nextInt();
                                libro.setAnio(anio);
                                break;
                            } catch (Exception e) {
                                System.out.println("Formato no reconocido");
                                leer.next();
                            }
                        } while (true);

                    case 2:
                        do {
                            System.out.println("Ingrese el nombre del autor");
                            String nombreAutor = leer.next();
                            if (as.buscarAutorNombre(nombreAutor).isEmpty()) {
                                System.out.println("Autor no encontrado, ¿desea registrarlo? S/N");
                                String respuesta = leer.next();
                                if (respuesta.equalsIgnoreCase("S")) {
                                    Autor autor = as.crearAutor(nombreAutor);
                                    libro.setAutor(autor);
                                    break;
                                }
                            } else {
                                System.out.println("Autor ya registrado");
                                libro.setAutor(as.buscarAutorNombre(nombreAutor).get(0));
                                break;
                            }
                        } while (true);
                        break;
                    case 3:
                        do {
                            System.out.println("Ingrese el nombre de la editorial");
                            String nombreEditorial = leer.next();
                            if (es.buscarEditorialNombre(nombreEditorial).isEmpty()) {
                                System.out.println("Editorial no encontrada, ¿desea registrarla? S/N");
                                String respuesta = leer.next();
                                if (respuesta.equalsIgnoreCase("S")) {
                                    Editorial editorial = es.crearEditorial(respuesta);
                                    libro.setEditorial(editorial);
                                    break;
                                }
                            } else {
                                System.out.println("Editorial ya registrada");
                                libro.setEditorial(es.buscarEditorialNombre(nombreEditorial).get(0));
                                break;
                            }
                        } while (true);
                        break;
                    case 4:
                        System.out.println("Ingrese el titulo que desea modificar");
                        String titulo = leer.next();
                        libro.setTitulo(titulo);
                        break;
                    case 5:
                        do {
                            try {
                                System.out.println("Ingrese la nueva cantidad de ejemplares");
                                int cantidadEjemplares = leer.nextInt();
                                if (libro.getEjemplaresRestantes() == libro.getEjemplares()) {
                                    libro.setEjemplaresRestantes(cantidadEjemplares);
                                }
                                libro.setEjemplares(cantidadEjemplares);
                                break;
                            } catch (Exception e) {
                                leer.next();
                            }
                        } while (true);
                }
                break;
        }
        dao.actualizarEntidad(libro);
    }

    public void buscarLibroISBN() {
        long isbn;
        do {
            try {
                System.out.println("Ingrese el ISBN del libro que desea buscar");
                isbn = leer.nextLong();
                break;
            } catch (Exception e) {
                System.out.println("Número no reconocido");
            }
        } while (true);

        System.out.println(dao.buscarLibroISBN(isbn));
    }

    public boolean buscarLibroISBN(long ISBN) {
        try {
            if (dao.buscarLibroISBN(ISBN) == null) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public Libro traerLibroISBN(long ISBN) {
        return dao.buscarLibroISBN(ISBN);
    }

}
