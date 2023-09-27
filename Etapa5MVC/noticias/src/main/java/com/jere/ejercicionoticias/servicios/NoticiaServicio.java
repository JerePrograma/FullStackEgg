package com.jere.ejercicionoticias.servicios;

import com.jere.ejercicionoticias.repositorios.NoticiaRepositorio;
import com.jere.ejercicionoticias.entidades.Noticia;
import com.jere.ejercicionoticias.excepciones.MiException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticiaServicio {

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    public void crearNoticia(String titulo, String cuerpo) throws MiException {
        validar(titulo, cuerpo);
        Noticia noticia = new Noticia();
        noticia.setCuerpo(cuerpo);
        noticia.setTitulo(titulo);
        noticia.setAlta(true);
        noticiaRepositorio.save(noticia);
    }

    public void modificarNoticia(Long id, String titulo, String cuerpo) throws MiException {
        validar(id, titulo, cuerpo);
        Optional<Noticia> respuesta = noticiaRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Noticia noticia = respuesta.get();

            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);

            noticiaRepositorio.save(noticia);
        }
    }

    public void borrarNoticia(Long id) {
        Optional<Noticia> validacion = noticiaRepositorio.findById(id);
        if (validacion.isPresent()) {
            Noticia noticia = validacion.get();
            noticia.setAlta(false);
            noticiaRepositorio.save(noticia);
        }
    }

    private void validar(Long id, String titulo, String cuerpo) throws MiException {
        if (id == null) {
            throw new MiException("El isbn no puede ser nulo");
        }
        if (titulo == null || titulo.isEmpty()) {
            throw new MiException("El nombre no puede estar vacío o ser nulo");
        }

        if (cuerpo == null || cuerpo.isEmpty()) {
            throw new MiException("El cuerpo no puede estar vacío o ser nulo");
        }
    }

    private void validar(String titulo, String cuerpo) throws MiException {
        if (titulo == null || titulo.isEmpty()) {
            throw new MiException("El nombre no puede estar vacío o ser nulo");
        }

        if (cuerpo == null || cuerpo.isEmpty()) {
            throw new MiException("El cuerpo no puede estar vacío o ser nulo");
        }
    }

    public List<Noticia> listarNoticias() {
        List<Noticia> noticias = new ArrayList<>();
        noticias = noticiaRepositorio.findAll();
        return noticias;
    }

    public Noticia getOne(Long id) {
        return noticiaRepositorio.getOne(id);
    }
}
