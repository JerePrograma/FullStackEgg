package libreria.servicios;

import java.util.Scanner;
import javax.persistence.EntityManager;
import libreria.entidades.Autor;

public class AutorServicio {

    public void persistirAutor(EntityManager em) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        do {
            Autor autor = new Autor();
            System.out.println("Ingrese el nombre del autor");
            String nombre = leer.next();
            autor.setNombre(nombre);
            autor.setAlta(true);
            try {
                em.getTransaction().begin();
                em.persist(autor);
                em.getTransaction().commit();
                break;
            } catch (Exception e) {
                System.out.println("No se pudo cargar el autor");
            }
        } while (true);
    }
}
