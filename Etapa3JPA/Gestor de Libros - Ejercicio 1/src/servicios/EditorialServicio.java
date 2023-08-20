package servicios;

import entidades.Editorial;
import java.util.List;
import java.util.Scanner;
import persistencia.EditorialDAO;

public class EditorialServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    EditorialDAO dao = new EditorialDAO();

    public Editorial crearEditorial() {
        Editorial editorial = new Editorial();
        do {
            System.out.println("Ingrese el nombre de la editorial");
            String nombre = leer.next();
            editorial.setNombre(nombre);
            if(dao.validarEditorialNombre(nombre).isEmpty()){
                break;
            }else{
                System.out.println("Nombre de editorial ya registrada");
            }
        } while (true);
        editorial.setAlta(true);
        dao.persistirEntidad(editorial);
        System.out.println("Se guardó exitosamente la editorial");
        return editorial;
    }

    public Editorial crearEditorial(String nombre) {
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setAlta(true);

        dao.persistirEntidad(editorial);
        System.out.println("Se guardó exitosamente la editorial");
        return editorial;
    }

    public void darAltaBajaModifcar() {
        Integer id;
        do {
            System.out.println("Ingrese el id del autor que desea dar alta/baja/modificar");
            try {
                id = leer.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Error al ingresar el id");
            }
        } while (true);
        Editorial editorial = dao.buscarEditorial(id);
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
                if (editorial.getAlta()) {
                    editorial.setAlta(false);
                } else {
                    editorial.setAlta(true);
                }
                break;
            case 2:
                System.out.println("Ingrese el nombre que desea modificar");
                String nombreEditorial = leer.next();
                editorial.setNombre(nombreEditorial);
                break;
        }
        dao.actualizarEntidad(editorial);
    }

    public List<Editorial> buscarEditorialNombre() {
        System.out.println("Ingrese el nombre de la editorial");
        String nombre = leer.next();
        return dao.buscarEditorialNombre(nombre);
    }

    public List<Editorial> buscarEditorialNombre(String nombre) {
        return dao.buscarEditorialNombre(nombre);
    }
}
