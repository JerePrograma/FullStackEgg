package persistencia;

import entidades.Prestamo;
import java.util.List;

public class PrestamoDAO extends DAO<Prestamo> {

    @Override
    public void persistirEntidad(Prestamo prestamo) {
        super.persistirEntidad(prestamo);
    }

    @Override
    public void actualizarEntidad(Prestamo prestamo) {
        super.actualizarEntidad(prestamo);
    }

    @Override
    public void borrarEntidad(Prestamo prestamo) {
        super.borrarEntidad(prestamo);
    }

    public Prestamo buscarPrestamoId(Integer id) {
        conectarBase();
        Prestamo prestamo = em.find(Prestamo.class, id);
        desconectarBase();
        return prestamo;
    }

    public List<Prestamo> buscarPrestamoCliente(long dni) {
        conectarBase();
        List<Prestamo> prestamos = em.createQuery("SELECT P FROM Prestamo p WHERE p.cliente.documento = :dni AND p.alta = TRUE").setParameter("dni", dni).getResultList();
        desconectarBase();
        return prestamos;
    }

    
}
