package persistencia;

import java.util.ArrayList;
import java.util.List;
import libreria.entidades.Cliente;
import libreria.entidades.Prestamo;

public class PrestamoDao extends DAO {

    public void persistirPrestamo(Prestamo prestamo) {

        persisitrEntidad(prestamo);
    }

    public void actualizarEstadoPrestamo(Prestamo prestamo) {

        actualizarEstadoEntidad(prestamo);

    }

    public List buscarPrestamo() {

        return em.createQuery("SELECT p FROM Prestamo p").getResultList();

    }

    public Cliente buscarPorClienteId(int id) {
        return em.find(Cliente.class, id);
    }

    public List<Prestamo> buscarPrestamosPorClienteId(int id) {
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente == null) {
            return new ArrayList<>();
        } else {
            return em.createQuery("SELECT p FROM Prestamo p WHERE p.cliente.id = :clienteId", Prestamo.class)
                    .setParameter("clienteId", id)
                    .getResultList();
        }
    }

}
