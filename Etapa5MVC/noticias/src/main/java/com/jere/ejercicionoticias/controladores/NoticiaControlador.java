package com.jere.ejercicionoticias.controladores;

import com.jere.ejercicionoticias.entidades.Noticia;
import com.jere.ejercicionoticias.excepciones.MiException;
import com.jere.ejercicionoticias.servicios.NoticiaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/noticia")
public class NoticiaControlador {

    @Autowired
    private NoticiaServicio noticiaServicio;

    @GetMapping("/registrar")
    public String index() {
        return "noticia_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String titulo, @RequestParam String cuerpo, ModelMap modelo) {
        try {
            noticiaServicio.crearNoticia(titulo, cuerpo);
            modelo.put("éxito", "Se cargó correctamente la noticia");
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "noticia_form.html";
        }
        return "index.html";
    }

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {
        List<Noticia> noticias = noticiaServicio.listarNoticias();

        modelo.addAttribute("noticias", noticias);

        return "noticia_list.html";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable(required = false) Long id, ModelMap modelo) {
        modelo.put("noticia", noticiaServicio.getOne(id));

        return "noticia_modificar.html";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable(required = false) Long id, String titulo, String cuerpo, ModelMap modelo) {
        try {
            noticiaServicio.modificarNoticia(id, titulo, cuerpo);
            modelo.put("éxito", "Se modificó correctamente la noticia");
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "noticia_modificar.html";
        }
        return "index.html";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(required = false) Long id, ModelMap modelo) {
        noticiaServicio.borrarNoticia(id);
        modelo.put("éxito", "Se eliminó correctamente la noticia");
        return "index.html";
    }

    @GetMapping("/detalle/{id}")
    public String detalle(@PathVariable(required = false) Long id, ModelMap modelo) {
        Noticia noticia = noticiaServicio.getOne(id);

        modelo.addAttribute("noticia", noticia);
        return "noticia_detalle.html";
    }
}
