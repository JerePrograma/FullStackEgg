package servicios;

import entidades.Cliente;
import entidades.Libro;
import entidades.Prestamo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import persistencia.PrestamoDAO;

public class PrestamoServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    PrestamoDAO dao = new PrestamoDAO();
    LibroServicio ls = new LibroServicio();
    ClienteServicio cs = new ClienteServicio();

    public void darPrestamo() {
        Prestamo prestamo = new Prestamo();
        boolean bucleTitulo = true;
        do {
            do {
                System.out.println("Ingrese el título del libro que desea retirar");
                String titulo = leer.next();
                if (ls.buscarLibroTitulo(titulo).isEmpty()) {
                    System.out.println("El libro no está en stock.");
                    System.out.println("¿Desea buscar otro libro? S/N");
                    String respuesta = leer.next();
                    if (!respuesta.equalsIgnoreCase("S")) {
                        break;
                    }
                } else {
                    Libro libro = ls.buscarLibroTitulo(titulo).get(0);
                    if (libro.getEjemplaresRestantes() > 0) {
                        libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() + 1);
                        libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() - 1);
                        prestamo.setLibro(libro);
                        ls.dao.actualizarEntidad(libro);
                        System.out.println("Libro encontrado!");
                        break;
                    } else {
                        System.out.println("Ya no quedan ejemplares del libro para prestar :c");
                        System.out.println("¿Desea buscar otro libro? S/N");
                        String respuesta = leer.next();
                        if (!respuesta.equalsIgnoreCase("S")) {
                            break;
                        }
                    }
                }
            } while (bucleTitulo);
            Cliente cliente;
            do {
                System.out.println("Ingrese el DNI del cliente");
                long dni = leer.nextLong();
                if (cs.buscarClienteDNI(dni).isEmpty()) {
                    System.out.println("Cliente no registrado, ¿desea ingresarlo? S/N");
                    String respuesta2 = leer.next();
                    if (respuesta2.equalsIgnoreCase("S")) {
                        cliente = cs.crearCliente();
                    }
                } else {
                    cliente = cs.buscarClienteDNI(dni).get(0);
                    prestamo.setCliente(cliente);
                    break;
                }
            } while (true);

            Date fechaPrestamo = new Date();
            prestamo.setFechaPrestamo(fechaPrestamo);
            do {
                try {
                    System.out.println("¿Cuándo hará la devolución?");
                    System.out.println("DD/MM/AAAA");
                    String fechaDevo = leer.next();
                    int dia = Integer.parseInt(fechaDevo.substring(0, 2));
                    int mes = Integer.parseInt(fechaDevo.substring(3, 5));
                    int anio = Integer.parseInt(fechaDevo.substring(6, 10));
                    Date fechaDevolucion = new Date(anio - 1900, mes - 1, dia);
                    if (fechaDevolucion.before(fechaPrestamo)) {
                        System.out.println("Fecha mal ingresada, ingrese nuevamente");
                    } else {
                        prestamo.setFechaDevolucion(fechaDevolucion);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("No se reconoce el formato de la fecha.");
                }
            } while (true);
            prestamo.setAlta(true);
            dao.persistirEntidad(prestamo);
            System.out.println("¿Desea efectuar otro préstamo? S/N");
            String respuesta = leer.next();
            if (!respuesta.equalsIgnoreCase("S")) {
                break;
            }
        } while (true);
    }

    public void devolverLibro() {
        long dni;
        do {
            try {
                System.out.println("Ingrese el DNI del cliente");
                dni = leer.nextInt();
                if (cs.buscarClienteDNI(dni).isEmpty()) {
                    System.out.println("DNI no encontrado.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("DNI mal ingresado.");
                leer.next();
            }
        } while (true);
        List<Prestamo> prestamos = busquedaLibrosCliente(dni);
        int numero = 0;
        if (prestamos.isEmpty()) {
            System.out.println("No tenés libros para devolver!");
        } else {
            ArrayList<Integer> numeroPrestamos = new ArrayList<>();
            System.out.println("Seleccione cuál libro desea devolver: ");
            int i = 1;
            for (Prestamo prestamo : prestamos) {
                System.out.println(i + ". " + prestamo);
                i++;
                numeroPrestamos.add(prestamo.getId());
            }
            boolean bandera = false;
            do {
                try {
                    System.out.println("Ingrese el ID del préstamo que desea finalizar");
                    numero = leer.nextInt();
                    for (Integer numeros : numeroPrestamos) {
                        if (numero == numeros) {
                            bandera = true;
                        }
                    }
                    if (bandera) {
                        break;
                    } else {
                        System.out.println("ID no reconocido");
                    }
                } catch (Exception e) {
                    System.out.println("Número mal ingresado.");
                    leer.next();
                }
            } while (true);
        }
        darBajaPrestamo(numero);
    }

    public List<Prestamo> busquedaLibrosCliente(long dni) {
        return dao.buscarPrestamoCliente(dni);
    }

    public void darBajaPrestamo(Integer id) {
        Prestamo prestamo = dao.buscarPrestamoId(id);
        if (prestamo.isAlta()) {
            prestamo.setAlta(false);
            dao.actualizarEntidad(prestamo);
            Libro libro = ls.traerLibroISBN(prestamo.getLibro().getISBN());
            if (libro.getEjemplaresPrestados() < libro.getEjemplares() && libro.getEjemplaresPrestados() > 0) {
                libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() - 1);
                libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() + 1);
                prestamo.setLibro(libro);
                ls.dao.actualizarEntidad(libro);
            }
        }
    }
}
