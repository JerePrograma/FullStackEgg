package servicios;

import entidades.Cliente;
import java.util.List;
import java.util.Scanner;
import persistencia.ClienteDAO;

public class ClienteServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ClienteDAO dao = new ClienteDAO();

    public Cliente crearCliente() {
        Cliente cliente = new Cliente();
        System.out.println("Ingrese el nombre del cliente");
        String nombre = leer.next();
        cliente.setNombre(nombre);
        System.out.println("Ingrese el apellido del cliente");
        String apellido = leer.next();
        cliente.setApellido(apellido);
        System.out.println("Ingrese el teléfono del cliente");
        String telefono = leer.next();
        cliente.setTelefono(telefono);

        do {
            try {
                System.out.println("Ingrese el DNI del cliente");
                long dni = leer.nextLong();
                cliente.setDocumento(dni);
                if (buscarClienteDNI(dni).isEmpty()) {
                    break;
                } else {
                    System.out.println("DNI de cliente ya registrado.");
                }
            } catch (Exception e) {
                leer.next();
            }
        } while (true);

        cliente.setAlta(true);

        dao.persistirEntidad(cliente);
        System.out.println("Cliente guardado exitosamente!");
        return cliente;
    }

    public Cliente crearCliente(String nombre) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setAlta(true);

        dao.persistirEntidad(cliente);
        System.out.println("Cliente guardado exitosamente!");
        return cliente;
    }

    public void darAltaBajaModificar() {
        Integer id;
        do {
            System.out.println("Ingrese el id del cliente que desea dar alta/baja/modificar");
            try {
                id = leer.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Error al ingresar el id");
            }
        } while (true);
        Cliente cliente = dao.buscarCliente(id);
        int opcion;
        do {
            System.out.println("1- Alta/Baja \n2-Modificar");
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
                if (cliente.isAlta()) {
                    cliente.setAlta(false);
                } else {
                    cliente.setAlta(true);
                }
                break;
            case 2:
//                System.out.println("Seleccione qué desea cambiar:");
//                System.out.println("1- Año de edición");
//                System.out.println("2- El autor");
//                System.out.println("3- La editorial");
//                System.out.println("4- El título");
//                System.out.println("5- La cantidad de ejemplares");
//                opcion = leer.nextInt();
//                switch (opcion) {
//                    case 1:
//                        System.out.println("Ingrese el año:");
//                        int anio = leer.nextInt();
//                        libro.setAnio(anio);
//                        break;
//                    case 2:
//                        do {
//                            System.out.println("Ingrese el nombre del autor");
//                            String nombreAutor = leer.next();
//                            if (as.buscarAutorNombre(nombreAutor).isEmpty()) {
//                                System.out.println("Autor no encontrado, ¿desea registrarlo? S/N");
//                                String respuesta = leer.next();
//                                if (respuesta.equalsIgnoreCase("S")) {
//                                    Autor autor = as.crearAutor(nombreAutor);
//                                    libro.setAutor(autor);
//                                    break;
//                                }
//                            } else {
//                                System.out.println("Autor ya registrado");
//                                libro.setAutor(as.buscarAutorNombre(nombreAutor).get(0));
//                                break;
//                            }
//                        } while (true);
//                        break;
//                    case 3:
//                        do {
//                            System.out.println("Ingrese el nombre de la editorial");
//                            String nombreEditorial = leer.next();
//                            if (es.buscarEditorialNombre(nombreEditorial).isEmpty()) {
//                                System.out.println("Editorial no encontrada, ¿desea registrarla? S/N");
//                                String respuesta = leer.next();
//                                if (respuesta.equalsIgnoreCase("S")) {
//                                    Editorial editorial = es.crearEditorial(respuesta);
//                                    libro.setEditorial(editorial);
//                                    break;
//                                }
//                            } else {
//                                System.out.println("Editorial ya registrada");
//                                libro.setEditorial(es.buscarEditorialNombre(nombreEditorial).get(0));
//                                break;
//                            }
//                        } while (true);
//                        break;
//                    case 4:
//                        System.out.println("Ingrese el titulo que desea modificar");
//                        String titulo = leer.next();
//                        libro.setTitulo(titulo);
//                        break;
//                    case 5:
//                        System.out.println("Ingrese la nueva cantidad de ejemplares");
//                        int cantidadEjemplares = leer.nextInt();
//                        if (libro.getEjemplaresRestantes() == libro.getEjemplares()) {
//                            libro.setEjemplaresRestantes(cantidadEjemplares);
//                        }
//                        libro.setEjemplares(cantidadEjemplares);
//                        break;
//                }
        }
        dao.actualizarEntidad(cliente);
    }

    public List<Cliente> buscarClienteNombre() {
        System.out.println("Ingrese el nombre del cliente");
        String nombre = leer.next();
        return dao.buscarClienteNombre(nombre);
    }

    public List<Cliente> buscarClienteNombre(String nombre) {
        return dao.buscarClienteNombre(nombre);
    }

    public List<Cliente> buscarClienteDNI(long dni) {
        List<Cliente> clientes = dao.buscarClienteDocumento(dni);
        return clientes;
    }
}
