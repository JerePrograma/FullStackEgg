package libreria.servicios;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import persistencia.PrestamoDao;

public class PrestamoServicio {

    private PrestamoDao dao = new PrestamoDao();
    private ClienteServicio cs = new ClienteServicio();
    private LibroServicio ls = new LibroServicio();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void prestamoLibro() {
        try {
            Prestamo prestamo = new Prestamo();
            Libro libro = null;
            boolean bucleLibro = true;
            do {
                try {
                    libro = ls.buscarLibroTitulo();
                    if (libro.getEjemplaresRestantes() < 1) {
                        System.out.println("No quedan más ejemplares para prestar de este libro");
                        return;
                    }
                    break;
                } catch (NullPointerException e) {
                    System.out.println("El libro no existe.");
                }
            } while (bucleLibro);

            prestamo.setLibro(libro);

            int opcion;
            Cliente cliente = null;
            do {
                System.out.println("¿Es un cliente ya registrado?");
                System.out.println("1- Si");
                System.out.println("2- No");
                try {
                    opcion = leer.nextInt();
                    if (opcion == 1 || opcion == 2) {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opcion no reconocida, ingrese nuevamente");
                    leer.next();
                }
            } while (true);

            switch (opcion) {
                case 1:
                    do {
                        try {
                            System.out.println("Ingrese su documento");
                            int documento = leer.nextInt();
                            cliente = dao.buscarPorClienteId(documento);
                            if (cliente != null) {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Documento no válido.");
                            leer.next();
                        }
                    } while (true);
                    break;
                case 2:
                    cliente = cs.crearCliente();
                    break;
            }

            prestamo.setCliente(cliente);

            Date fechaActual = new Date();
            Date fechaPrestamo;
            do {
                try {
                    System.out.println("Ingrese la fecha de prestamo (dd/mm/aaaa)");
                    String fecha = leer.next();
                    fechaPrestamo = new Date(Integer.parseInt(fecha.substring(6, 10)) - 1900, Integer.parseInt(fecha.substring(3, 5)) - 1, Integer.parseInt(fecha.substring(0, 2)));
                    break;
                } catch (Exception e) {
                    System.out.println("Formato de fecha incorrecto.");
                }
            } while (true);

            do {
                try {
                    System.out.println("Ingrese la fecha de devolucion (dd/mm/aaaa)");
                    String fecha = leer.next();
                    Date fechaDevolucion = new Date(Integer.parseInt(fecha.substring(6, 10)) - 1900, Integer.parseInt(fecha.substring(3, 5)) - 1, Integer.parseInt(fecha.substring(0, 2)));
                    if (fechaDevolucion.before(fechaPrestamo)) {
                        System.out.println("La fecha de devolución no puede ser anterior a la fecha de préstamo.");
                    } else {
                        prestamo.setFechaFin(fechaDevolucion);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Formato de fecha incorrecto.");
                }
            } while (true);
            ls.prestarLibro(libro);
            try {
                dao.persistirPrestamo(prestamo);
                System.out.println("Préstamo registrado exitosamente!");
            } catch (Exception e) {
                System.out.println("No se pudo guardar el préstamo en la base de datos.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al realizar el préstamo.");
            e.printStackTrace();
        }
    }

    public void devolverLibro() {
        try {
            System.out.println("Ingrese su documento");
            int documento = leerInteger();
            Cliente cliente = dao.buscarPorClienteId(documento);

            if (cliente != null) {
                List<Prestamo> prestamos = dao.buscarPrestamosPorClienteId(cliente.getId());

                if (prestamos.isEmpty()) {
                    System.out.println("No se encontraron préstamos para este cliente");
                    return;
                }

                System.out.println("Por favor elija el número del préstamo que desea devolver:");
                for (int i = 0; i < prestamos.size(); i++) {
                    System.out.println((i + 1) + " - " + prestamos.get(i).getLibro().getTitulo());
                }

                int opcion = leerInteger();
                Prestamo prestamo = prestamos.get(opcion - 1);

                if (prestamo != null && prestamo.getFechaFin() == null) {
                    Date fechaActual = new Date();
                    if (fechaActual.before(prestamo.getFechaInicio())) {
                        System.out.println("La fecha actual no puede ser anterior a la fecha de préstamo.");
                    } else {
                        prestamo.setFechaFin(fechaActual);
                        synchronized (this) {
                            ls.devolverLibro(prestamo.getLibro());
                        }
                        dao.actualizarEstadoPrestamo(prestamo);
                    }
                } else {
                    System.out.println("El préstamo seleccionado no existe o ya fue devuelto.");
                }
            } else {
                System.out.println("El cliente no existe.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Documento no válido.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al devolver el libro.");
        }
    }

    private int leerInteger() {
        while (true) {
            try {
                return leer.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opcion no reconocida, ingrese nuevamente");
                leer.next();
            }
        }
    }
}
