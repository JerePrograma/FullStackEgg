package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Editorial;
import persistencia.EditorialDAO;

public class EditorialServicio {

    private EditorialDAO dao = new EditorialDAO();

    public void guardarEditorial() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean bucle2;
        do {
            bucle2 = false;
            Editorial editorial = new Editorial();
            System.out.println("Ingrese el nombre de la editorial");
            String nombre = leer.next();
            editorial.setNombre(nombre);
            editorial.setAlta(true);
            dao.persisitrEditorial(editorial);
            System.out.println("¿Desea cargar otra editorial? S/N");
            if (leer.next().equalsIgnoreCase("S")) {
                bucle2 = true;
            }
        } while (bucle2);
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
