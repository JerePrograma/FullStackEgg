package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import libreria.entidades.Autor;

public class AutorServicio {

    public void guardarAutor(EntityManager em) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean bucle;
        do {
            bucle = false;
            Autor autor = new Autor();
            System.out.println("Ingrese el nombre del autor");
            String nombre = leer.next();
            autor.setNombre(nombre);
            autor.setAlta(true);
            try {
                em.getTransaction().begin();
                em.persist(autor);
                em.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("No se pudo cargar el autor");
                leer.next();
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            } finally {
                em.close();
            }
            System.out.println("¿Desea cargar otro autor? S/N");
            if (leer.next().equalsIgnoreCase("S")) {
                bucle = true;
            }
        } while (bucle);
    }

    public void darBajaAutor(EntityManager em) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre del autor");
        String nombreEditorial = leer.next();
        boolean noEncontrado = true;
        boolean alta = true;
        boolean bucle;

        List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        for (Autor autor : autores) {
            if (autor.getNombre().equalsIgnoreCase(nombreEditorial)) {
                autor.setAlta(alta);
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
                noEncontrado = false;
                try {
                    em.getTransaction().begin();
                    em.persist(autor);
                    em.getTransaction().commit();
                    break;
                } catch (Exception e) {
                    System.out.println("No se pudo actualizar el estado");
                    if (em.getTransaction().isActive()) {
                        em.getTransaction().rollback();
                    }
                } finally {
                    em.close();
                }
            }
        }
        if (noEncontrado) {
            System.out.println("Autor no encontrado");
            leer.next();
        }
    }

    public void buscarAutorNombre(EntityManager em) {
        boolean noEncontrado = true;
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre del autor");
        String nombreAutor = leer.next();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        for (Autor autor : autores) {
            if (autor.getNombre().equalsIgnoreCase(nombreAutor)) {
                System.out.println("Autor encontrado");
                System.out.println(autor);
                noEncontrado = false;
            }
        }
        if (noEncontrado) {
            System.out.println("Autor no encontrado");
        }
    }
}
