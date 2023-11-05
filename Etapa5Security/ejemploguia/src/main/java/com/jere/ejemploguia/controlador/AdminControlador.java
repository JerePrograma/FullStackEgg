package com.jere.ejemploguia.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

    @GetMapping("/dashboard")
    public String panelAdministrativo() {
        return "panel.html";
    }
}
