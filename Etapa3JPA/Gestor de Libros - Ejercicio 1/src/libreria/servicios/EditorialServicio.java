package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Editorial;
import persistencia.EditorialDAO;

public class EditorialServicio {

    private EditorialDAO dao = new EditorialDAO();

    public void guardarEditorial() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean bucle;
        do {
            bucle = false;
            Editorial editorial = new Editorial();
            System.out.println("Ingrese el nombre de la editorial");
            String nombre = leer.next();
            editorial.setNombre(nombre);
            editorial.setAlta(true);

            // Busca si ya existe una editorial con el mismo nombre
            List<Editorial> editoriales = dao.buscarEditorialesPorNombre(nombre);
            if (!editoriales.isEmpty()) {
                System.out.println("Ya existe una editorial con ese nombre. Intente nuevamente.");
                continue;
            }

            dao.persisitrEditorial(editorial);
            System.out.println("Editorial guardada exitosamente.");

            System.out.println("¿Desea cargar otra editorial? S/N");
            if (leer.next().equalsIgnoreCase("S")) {
                bucle = true;
            }
        } while (bucle);
    }

    public void guardarEditorial(Editorial editorial) {

        dao.persisitrEditorial(editorial);
        System.out.println("Editorial guardada exitosamente.");

    }

    public void darBajaEditorial() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre de la editorial");
        String nombreEditorial = leer.next();
        boolean noEncontrado = true;
        boolean alta = true;
        boolean bucle;

        List<Editorial> editoriales = dao.consultarEditorial();
        for (Editorial editorial : editoriales) {
            if (editorial.getNombre().equalsIgnoreCase(nombreEditorial)) {
                do {
                    System.out.println("1- Darlo de baja");
                    System.out.println("2- Darlo de alta");
                    int opcion = leer.nextInt();
                    switch (opcion) {
                        case 1:
                            alta = false;
                            bucle = false;
                            break;
                        case 2:
                            alta = true;
                            bucle = false;
                            break;
                        default:
                            System.out.println("Opción no reconocida");
                            bucle = true;
                    }
                } while (bucle);
                editorial.setAlta(alta);
                noEncontrado = false;
                dao.actualizarEstadoEditorial(editorial);
                break;
            }
        }
        if (noEncontrado) {
            System.out.println("Editorial no encontrada");
            leer.next();
        }
    }
}
