package persistencia;

import entidades.Libro;
import java.util.List;

public class LibroDAO extends DAO<Libro> {

    @Override
    public void persistirEntidad(Libro libro) {
        super.persistirEntidad(libro);
    }

    @Override
    public void actualizarEntidad(Libro libro) {
        super.actualizarEntidad(libro);
    }

    @Override
    public void borrarEntidad(Libro libro) {
        super.borrarEntidad(libro);
    }

    public Libro buscarLibroISBN(Long ISBN) {
        conectarBase();
        Libro libro = em.find(Libro.class, ISBN);
        desconectarBase();
        return libro;
    }

    public List<Libro> buscarLibroTitulo(String titulo) {
        conectarBase();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo AND l.alta = TRUE").setParameter("titulo", titulo).getResultList();
        desconectarBase();
        return libros;
    }

    public List<Libro> buscarLibroAutor(String nombre) {
        conectarBase();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.autor.id = (SELECT a.id FROM Autor a where a.nombre = :nombre AND a.alta = TRUE)").setParameter("nombre", nombre).getResultList();
        desconectarBase();
        return libros;
    }

    public List<Libro> buscarLibroEditorial(String nombre) {
        conectarBase();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.id = (SELECT e.id FROM Editorial e where e.nombre = :nombre AND e.alta = TRUE)").setParameter("nombre", nombre).getResultList();
        desconectarBase();
        return libros;
    }
}
