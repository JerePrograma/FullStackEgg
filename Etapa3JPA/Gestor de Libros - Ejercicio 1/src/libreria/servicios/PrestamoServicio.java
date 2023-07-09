package libreria.servicios;

import java.util.Date;
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
        Prestamo prestamo = new Prestamo();
        Libro libro = null;
        boolean bucleLibro = true;
        do {
            try {
                libro = ls.buscarLibroTitulo();
                if (libro.getEjemplaresRestantes() < 1) {
                    System.out.println("No quedan más ejemplares para prestar de este libro");
                } else {
                    bucleLibro = false;
                }
            } catch (NullPointerException e) {

            }
        } while (bucleLibro);
        prestamo.setLibro(libro);
        System.out.println("Es un cliente ya registrado?");
        System.out.println("1- Si");
        System.out.println("2- No");
        int opcion;
        Cliente cliente = null;
        do {
            try {
                opcion = leer.nextInt();
                if (opcion == 1 || opcion == 2) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Opcion no reconocida, ingrese nuevamente");
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
                    } catch (Exception e) {
                        System.out.println("Documento no reconocido");
                    }
                } while (true);
                break;
            case 2:
                cliente = cs.crearCliente();
                break;
        }
        prestamo.setCliente(cliente);
        String fecha;
        do {
            try {
                System.out.println("Ingrese la fecha de prestamo (dd/mm/aaaa)");
                fecha = leer.next();
                prestamo.setFechaPrestamo(new Date(Integer.parseInt(fecha.substring(6, 10)) - 1900, Integer.parseInt(fecha.substring(3, 4)) - 1, Integer.parseInt(fecha.substring(0, 2))));
                break;
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Formato de fecha incrrecto.");
            }
        } while (true);
        do {
            try {
                System.out.println("Ingrese la fecha de devolucion (dd/mm/aaaa)");
                fecha = leer.next();
                prestamo.setFechaDevolucion(new Date(Integer.parseInt(fecha.substring(6, 10)) - 1900, Integer.parseInt(fecha.substring(3, 4)) - 1, Integer.parseInt(fecha.substring(0, 2))));
                break;
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Formato de fecha incrrecto.");
            }
        } while (true);
        ls.prestarLibro(libro);
        dao.persistirPrestamo(prestamo);
    }

    public void devolverLibro() {
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

            if (prestamo != null && prestamo.getFechaDevolucion() == null) {
                prestamo.setFechaDevolucion(new Date());
                dao.actualizarEstadoPrestamo(prestamo);
                ls.devolverLibro(prestamo.getLibro());
                System.out.println("Libro devuelto con éxito");
            } else {
                System.out.println("No se encontró un préstamo válido para este libro y cliente");
            }
        } else {
            System.out.println("No se encontró un cliente con ese documento");
        }
    }

    public Integer leerInteger() {
        Integer resultado = null;
        while (resultado == null) {
            try {
                resultado = leer.nextInt();
            } catch (Exception e) {
                System.out.println("No ingresaste un número entero válido");
                leer.next();
            }
        }
        return resultado;
    }
}
