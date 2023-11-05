package com.ejemplo.controladores;

import com.ejemplo.entidades.Noticia;
import com.ejemplo.excepciones.MiExcepcion;
import com.ejemplo.servicios.NoticiaServicio;
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
    public String crearNoticia(ModelMap modelo) {
        return "noticia_form";
    }

    @PostMapping("/registro")
    public String crearNoticia(ModelMap modelo,
            @RequestParam("titulo") String titulo,
            @RequestParam("cuerpo") String cuerpo
    ) throws MiExcepcion {
        noticiaServicio.crearNoticia(titulo, cuerpo);
        return "index.html";
    }

    @GetMapping("/lista")
    public String listarNoticias(ModelMap modelo) {
        List<Noticia> noticias = noticiaServicio.listarNoticias();
        modelo.addAttribute("noticias", noticias);
        return "noticia_list.html";
    }

    @GetMapping("/modificar/{id}")
    public String modificarNoticia(ModelMap modelo,
            @PathVariable String id) {
        modelo.put("noticia", noticiaServicio.getOne(id));
        return "noticia_modificar.html";
    }

    @PostMapping("/modificar/{id}")
    public String modificarNoticia(ModelMap modelo,
            @PathVariable String id,
            @RequestParam("titulo") String titulo,
            @RequestParam("cuerpo") String cuerpo) throws MiExcepcion {
        noticiaServicio.modificar(id, titulo, cuerpo);
        return "redirect:../lista";
    }

    @GetMapping("/baja/{id}")
    public String bajaNoticia(ModelMap modelo,
            @PathVariable String id
    ) throws MiExcepcion {
        noticiaServicio.darDeBaja(id);
        return "redirect:../lista";
    }

    @GetMapping("/alta/{id}")
    public String altaNoticia(ModelMap modelo,
            @PathVariable String id
    ) throws MiExcepcion {
        noticiaServicio.darDeAlta(id);
        return "redirect:../lista";
    }
}
