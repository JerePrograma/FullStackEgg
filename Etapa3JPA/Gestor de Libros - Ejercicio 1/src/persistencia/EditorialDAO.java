package persistencia;

import java.util.List;
import libreria.entidades.Editorial;

public class EditorialDAO extends DAO {

    public void persisitrEditorial(Editorial editorial) {

        persisitrEntidad(editorial);

    }

    public void actualizarEstadoEditorial(Editorial editorial) {

        actualizarEstadoEntidad(editorial);
    }

    public List consultarEditorial() {
        String jpql = "SELECT e FROM Editorial e";
        return em.createQuery(jpql).getResultList();
    }
}
