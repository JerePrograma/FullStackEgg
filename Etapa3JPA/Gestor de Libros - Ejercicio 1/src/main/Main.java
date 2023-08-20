package main;

import java.util.Scanner;
import servicios.AutorServicio;
import servicios.ClienteServicio;
import servicios.EditorialServicio;
import servicios.LibroServicio;
import servicios.PrestamoServicio;

public class Main {

    public static void main(String[] args) {
        AutorServicio as = new AutorServicio();
        EditorialServicio es = new EditorialServicio();
        LibroServicio ls = new LibroServicio();
        PrestamoServicio ps = new PrestamoServicio();
        ClienteServicio cs = new ClienteServicio();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean menu = true;
        do {
            int opcion = 0;
            do {
                try {

                    System.out.println("\n");
                    System.out.println("1. Agregar autor, editorial, libro o cliente.");
                    System.out.println("2. Dar de alta/baja autor, editorial, libro o cliente.");
                    System.out.println("3. Buscar Autor por nombre");
                    System.out.println("4. Buscar libro por ISBN");
                    System.out.println("5. Buscar libro por Título");
                    System.out.println("6. Buscar libro/s por nombre de Autor");
                    System.out.println("7. Buscar libro/s por nombre de Editorial");
                    System.out.println("8. Registrar préstamo");
                    System.out.println("9. Devolver préstamo");
                    System.out.println("10. Salir");

                    opcion = leer.nextInt();
                    break;
                } catch (Exception e) {
                    leer.next();
                    System.out.println("");
                    System.out.println("Opción no válida.");
                }
            } while (menu);
            switch (opcion) {
                case 1:
                    do {
                        try {
                            System.out.println("1. Autor");
                            System.out.println("2. Editorial");
                            System.out.println("3. Libro");
                            System.out.println("4. Cliente");
                            opcion = leer.nextInt();
                            break;
                        } catch (Exception e) {
                            leer.next();
                            System.out.println("Opción no válida");
                        }
                    } while (true);
                    switch (opcion) {
                        case 1:
                            as.crearAutor();
                            break;
                        case 2:
                            es.crearEditorial();
                            break;
                        case 3:
                            ls.crearLibro();
                            break;
                        case 4:
                            cs.crearCliente();
                            break;
                        default:
                            System.out.println("Opción no reconocida.");
                    }
                    break;
                case 2:
                    do {
                        try {
                            System.out.println("1. Autor");
                            System.out.println("2. Editorial");
                            System.out.println("3. Libro");
                            System.out.println("4. Cliente");
                            opcion = leer.nextInt();
                            break;
                        } catch (Exception e) {
                            leer.next();
                            System.out.println("Opción no válida");
                        }
                    } while (true);

                    switch (opcion) {
                        case 1:
                            as.darAltaBajaModificar();
                            break;
                        case 2:
                            es.darAltaBajaModifcar();
                            break;
                        case 3:
                            ls.darAltaBajaModificar();
                            break;
                        case 4:
                            cs.darAltaBajaModificar();
                            break;
                        default:
                            System.out.println("Opción no reconocida.");
                    }
                    break;
                case 3:
                    System.out.println(as.buscarAutorNombre());
                    break;
                case 4:
                    ls.buscarLibroISBN();
                    break;
                case 5:
                    ls.buscarLibroTitulo();
                    break;
                case 6:
                    ls.buscarLibroAutor();
                    break;
                case 7:
                    ls.buscarLibroEditorial();
                    break;
                case 8:
                    ps.darPrestamo();
                    break;
                case 9:
                    ps.devolverLibro();
                case 10:
                    menu = false;
                    System.out.println("Gracias por usar mi programa!");
                    break;
                default:
                    System.out.println("Opción no reconocida. Por favor, elige una opción del menú.");
            }
        } while (menu);
        System.out.println("\n\n");
        System.out.println("*************** Jeremías Rivelli ***************");
        System.out.println("\n\n");
    }
}
