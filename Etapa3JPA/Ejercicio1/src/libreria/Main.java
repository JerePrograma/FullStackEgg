package libreria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ejercicio1PU");
        EntityManager em = emf.createEntityManager();
        AutorServicio as = new AutorServicio();
        EditorialServicio es = new EditorialServicio();
//        es.persistirEditorial(em);
//        System.out.println("Ingresar editorial");
//        System.out.println("Ingresar autor");
//        System.out.println("Ingresar libro");
//        as.persistirAutor(em);
        
        LibroServicio ls = new LibroServicio();
        ls.persistirLibro(em);

    }
}
