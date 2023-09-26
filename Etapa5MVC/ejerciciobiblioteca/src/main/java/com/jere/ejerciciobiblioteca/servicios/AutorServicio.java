package com.jere.ejerciciobiblioteca.servicios;

import com.jere.ejerciciobiblioteca.entidades.Autor;
import com.jere.ejerciciobiblioteca.repositorios.AutorRepositorio;
import com.jere.ejerciciobiblioteca.excepciones.MiException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServicio {

    @Autowired
    AutorRepositorio autorRepositorio;

    public void crearAutor(String nombre) throws MiException {
        validarNombre(nombre);
        Autor autor = new Autor();
        autor.setNombre(nombre);

        autorRepositorio.save(autor);
    }

    public List<Autor> listarAutores() {
        List<Autor> libros = new ArrayList();

        libros = autorRepositorio.findAll();

        return libros;
    }

    public void modificarAutor(String nombre, String id) throws MiException {
        validar(nombre, id);
        Optional<Autor> respuesta = autorRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();

            autor.setNombre(nombre);

            autorRepositorio.save(autor);
        }
    }

    public Autor getOne(String id) {
        return autorRepositorio.getOne(id);
    }

    private void validar(String nombre, String id) throws MiException {

        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("El nombre no puede estar vacío o ser nulo");
        }

        if (id == null || id.isEmpty()) {
            throw new MiException("El ID del autor no puede estar vacío o ser nulo");
        }
    }

    private void validarNombre(String nombre) throws MiException {

        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("El nombre no puede estar vacío o ser nulo");
        }

    }
}
