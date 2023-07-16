package persistencia;

import java.util.List;
import libreria.entidades.Cliente;

public class ClienteDao extends DAO {

    public void persistirCliente(Cliente cliente) {

        persisitrEntidad(cliente);
    }

    public void actualizarEstadoCleinte(Cliente cliente) {

        actualizarEstadoEntidad(cliente);

    }

    public List buscarCliente() {

        return em.createQuery("SELECT c FROM Cliente c").getResultList();

    }

    public Cliente buscarCliente(int documento) {

        return em.find(Cliente.class, documento);

    }

}
