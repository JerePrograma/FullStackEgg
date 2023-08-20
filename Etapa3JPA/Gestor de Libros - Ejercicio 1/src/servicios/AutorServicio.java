package servicios;

import entidades.Autor;
import java.util.List;
import java.util.Scanner;
import persistencia.AutorDAO;

public class AutorServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    AutorDAO dao = new AutorDAO();

    public Autor crearAutor() {
        Autor autor = new Autor();
        do {
            System.out.println("Ingrese el nombre del autor");
            String nombre = leer.next();
            autor.setNombre(nombre);
            if (dao.validarNombreAutor(nombre).isEmpty()) {
                break;
            } else {
                System.out.println("Nombre de autor ya registrado.");
            }
        } while (true);

        autor.setAlta(true);

        dao.persistirEntidad(autor);
        System.out.println("Autor guardado exitosamente!");
        return autor;
    }

    public Autor crearAutor(String nombre) {
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(true);

        dao.persistirEntidad(autor);
        System.out.println("Autor guardado exitosamente!");
        return autor;
    }

    public void darAltaBajaModificar() {
        Integer id;
        do {
            System.out.println("Ingrese el id del autor que desea dar alta/baja/modificar");
            try {
                id = leer.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Error al ingresar el id");
                leer.next();
            }
        } while (true);
        Autor autor = dao.buscarAutor(id);
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
                if (autor.getAlta()) {
                    autor.setAlta(false);
                } else {
                    autor.setAlta(true);
                }
                break;
            case 2:
                System.out.println("Ingrese el nombre que desea modificar");
                String nombreAutor = leer.next();
                autor.setNombre(nombreAutor);
                break;
        }
        dao.actualizarEntidad(autor);
    }

    public List<Autor> buscarAutorNombre() {
        System.out.println("Ingrese el nombre del autor");
        String nombre = leer.next();
        return dao.buscarAutorNombre(nombre);
    }

    public List<Autor> buscarAutorNombre(String nombre) {
        return dao.buscarAutorNombre(nombre);
    }
}
