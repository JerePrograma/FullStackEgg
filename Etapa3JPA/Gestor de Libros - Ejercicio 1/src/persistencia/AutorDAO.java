package persistencia;

import java.util.List;
import libreria.entidades.Autor;

public class AutorDAO extends DAO {

    public void persistirAutor(Autor autor) {
        persisitrEntidad(autor);
    }

    public void actualizarEstadoAutor(Autor autor) {

        actualizarEstadoEntidad(autor);

    }

    public List buscarAutor() {

        return em.createQuery("SELECT a FROM Autor a").getResultList();

    }

    public List<Autor> buscarAutoresPorNombre(String nombre) {
        String jpql = "SELECT a FROM Autor a WHERE a.nombre = :nombre";
        return em.createQuery(jpql, Autor.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }
}
