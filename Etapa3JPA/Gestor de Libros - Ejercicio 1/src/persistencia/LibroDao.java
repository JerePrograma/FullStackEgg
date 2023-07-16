package persistencia;

import java.util.List;
import javax.persistence.Query;
import libreria.entidades.Libro;

public class LibroDao extends DAO {

    public void persistirLibro(Libro libro) {
        persisitrEntidad(libro);
    }

    public void actualizarLibro(Libro libro) {
        actualizarEstadoEntidad(libro);
    }

    public List consultaGenerica(String entidad, String atributo, String variable) {
        String jpql = "SELECT e FROM " + entidad + " e WHERE e." + atributo + " LIKE :variable";
        Query query = em.createQuery(jpql);
        query.setParameter("variable", "%" + variable + "%");
        return query.getResultList();
    }

    public List consultaLibros() {
        String jpql = "SELECT l FROM Libro l";
        return em.createQuery(jpql).getResultList();
    }

    public Libro buscarPorIsbn(long id) {
        return em.find(Libro.class, id);
    }

}
