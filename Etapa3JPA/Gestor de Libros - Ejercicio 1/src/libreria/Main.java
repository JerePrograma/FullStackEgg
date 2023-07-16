package libreria;

import java.util.Scanner;
import libreria.servicios.AutorServicio;
import libreria.servicios.ClienteServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;
import libreria.servicios.PrestamoServicio;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        AutorServicio as = new AutorServicio();
        EditorialServicio es = new EditorialServicio();
        LibroServicio ls = new LibroServicio();
        ClienteServicio cs = new ClienteServicio();
        PrestamoServicio ps = new PrestamoServicio();
        boolean menu = true;
        do {
            System.out.println("\n");
            System.out.println("1. Agregar autor, editorial, o libro.");
            System.out.println("2. Dar de alta/baja o editar autor, editorial, o libro.");
            System.out.println("3. Buscar Autor por nombre");
            System.out.println("4. Buscar libro por ISBN");
            System.out.println("5. Buscar libro por Título");
            System.out.println("6. Buscar libro/s por nombre de Autor");
            System.out.println("7. Buscar libro/s por nombre de Editorial");
            System.out.println("8. Prestar libro");
            System.out.println("9. Salir");

            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("1. Autor");
                    System.out.println("2. Editorial");
                    System.out.println("3. Libro");
                    opcion = leer.nextInt();
                    switch (opcion) {
                        case 1:
                            as.guardarAutor();
                            break;
                        case 2:
                            es.guardarEditorial();
                            break;
                        case 3:
                            ls.guardarLibro();
                            break;
                        default:
                            System.out.println("Opción no reconocida.");
                    }
                    break;
                case 2:
                    System.out.println("1. Autor");
                    System.out.println("2. Editorial");
                    System.out.println("3. Libro");
                    opcion = leer.nextInt();

                    switch (opcion) {
                        case 1:
                            as.darBajaAutor();
                            break;
                        case 2:
                            es.darBajaEditorial();
                            break;
                        case 3:
                            ls.darBajaLibro();
                            break;
                        default:
                            System.out.println("Opción no reconocida.");
                    }
                    break;
                case 3:
                    as.buscarAutorNombre();
                    break;
                case 4:
                    ls.buscarLibroIsbn();
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
                    ps.prestamoLibro();
                    break;
                case 9:
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
