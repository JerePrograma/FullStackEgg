package com.jere.ejemploguia.servicio;

import com.jere.ejemploguia.entidades.Editorial;
import com.jere.ejemploguia.excepciones.MiException;
import com.jere.ejemploguia.repositorio.EditorialRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServicio {

    @Autowired
    EditorialRepositorio editorialRepositorio;

    public void crearEditorial(String nombre) throws MiException {
        validarNombre(nombre);
        Editorial editorial = new Editorial();

        editorial.setNombre(nombre);

        editorialRepositorio.save(editorial);
    }

    public List<Editorial> listarEditoriales() {
        List<Editorial> libros = new ArrayList();

        libros = editorialRepositorio.findAll();

        return libros;
    }

    public void modificarEditorial(String nombre, String id) throws MiException {
        validar(nombre, id);
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Editorial editorial = respuesta.get();

            editorial.setNombre(nombre);

            editorialRepositorio.save(editorial);
        }
    }

    private void validar(String nombre, String id) throws MiException {

        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("El nombre no puede estar vacío o ser nulo");
        }

        if (id == null || id.isEmpty()) {
            throw new MiException("El ID del editorial no puede estar vacío o ser nulo");
        }
    }

    public Editorial getOne(String id) {
        return editorialRepositorio.getOne(id);
    }

    private void validarNombre(String nombre) throws MiException {

        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("El nombre no puede estar vacío o ser nulo");
        }

    }
}
