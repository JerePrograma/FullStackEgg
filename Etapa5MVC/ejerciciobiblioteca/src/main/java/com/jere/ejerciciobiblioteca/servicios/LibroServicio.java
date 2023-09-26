package com.jere.ejerciciobiblioteca.servicios;

import com.jere.ejerciciobiblioteca.entidades.Autor;
import com.jere.ejerciciobiblioteca.entidades.Editorial;
import com.jere.ejerciciobiblioteca.entidades.Libro;
import com.jere.ejerciciobiblioteca.repositorios.AutorRepositorio;
import com.jere.ejerciciobiblioteca.repositorios.EditorialRepositorio;
import com.jere.ejerciciobiblioteca.repositorios.LibroRepositorio;
import com.jere.ejerciciobiblioteca.excepciones.MiException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;
    @Autowired
    private AutorRepositorio autorRepositorio;
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException {
        validar(isbn, titulo, ejemplares, idAutor, idEditorial);
        Autor autor = autorRepositorio.findById(idAutor).get();
        Editorial editorial = editorialRepositorio.findById(idEditorial).get();
        Libro libro = new Libro();

        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAlta(new Date());

        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro);
    }

    public List<Libro> listarLibros() {
        List<Libro> libros = new ArrayList();

        libros = libroRepositorio.findAll();

        return libros;
    }

    public void modificarLibro(Long isbn, String titulo, String idAutor, String idEditorial, Integer ejemplares) throws MiException {
        validar(isbn, titulo, ejemplares, idAutor, idEditorial);
        Optional<Libro> respuesta = libroRepositorio.findById(isbn);
        Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);

        Autor autor = new Autor();
        Editorial editorial = new Editorial();
        if (respuestaAutor.isPresent()) {
            autor = respuestaAutor.get();
        }
        if (respuestaEditorial.isPresent()) {
            editorial = respuestaEditorial.get();
        }
        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();

            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setEjemplares(ejemplares);
            libroRepositorio.save(libro);
        }
    }

    public Libro getOne(Long id) {
        return libroRepositorio.getOne(id);
    }

    private void validar(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException {
        if (isbn == null) {
            throw new MiException("El isbn no puede ser nulo");
        }

        if (titulo == null || titulo.isEmpty()) {
            throw new MiException("El título no puede estar vacío o ser nulo");
        }
        if (ejemplares == null) {
            throw new MiException("Los ejemplares no pueden ser nulo");
        }

        if (idAutor == null || idAutor.isEmpty()) {
            throw new MiException("El ID del autor no puede estar vacío o ser nulo");
        }

        if (idEditorial == null || idEditorial.isEmpty()) {
            throw new MiException("El ID del editorial no puede estar vacío o ser nulo");
        }
    }
}
