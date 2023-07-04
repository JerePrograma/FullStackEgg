package libreria.servicios;

import java.util.Scanner;
import javax.persistence.EntityManager;
import libreria.entidades.Editorial;

public class EditorialServicio {

    public void persistirEditorial(EntityManager em) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        do {
            Editorial editorial = new Editorial();
            System.out.println("Ingrese el nombre de la editorial");
            String nombre = leer.next();
            editorial.setNombre(nombre);
            editorial.setAlta(true);
            try {
                em.getTransaction().begin();
                em.persist(editorial);
                em.getTransaction().commit();
                break;
            } catch (Exception e) {
                System.out.println("No se pudo cargar la editorial");
            }
        } while (true);
    }
}
