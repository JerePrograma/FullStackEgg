package persistencia;

import entidades.Autor;
import java.util.List;

public class AutorDAO extends DAO<Autor> {

    @Override
    public void persistirEntidad(Autor autor) {
        super.persistirEntidad(autor);
    }

    @Override
    public void actualizarEntidad(Autor autor) {
        super.actualizarEntidad(autor);
    }

    @Override
    public void borrarEntidad(Autor autor) {
        super.borrarEntidad(autor);
    }

    public Autor buscarAutor(Integer id) {
        conectarBase();
        Autor autor = em.find(Autor.class, id);
        desconectarBase();
        return autor;
    }

    public List<Autor> buscarAutorNombre(String nombre) {
        conectarBase();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a where a.nombre = :nombre AND a.alta = TRUE").setParameter("nombre", nombre).getResultList();
        desconectarBase();
        return autores;
    }

    public List<Autor> validarNombreAutor(String nombre) {
        conectarBase();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a where a.nombre = :nombre").setParameter("nombre", nombre).getResultList();
        desconectarBase();
        return autores;
    }
}
