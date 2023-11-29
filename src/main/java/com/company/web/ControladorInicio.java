
package com.company.web;


import com.company.doman.Personas;
import com.company.service.PersonaService;
import jakarta.validation.Valid;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j

public class ControladorInicio {
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model model){
        
        var personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);
                  
        log.info("ejecutando el controlador Spring MVC");
        //model.addAttribute("personas", personas);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Personas personas){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Personas personas, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(personas);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Personas personas, Model model){
       personas = personaService.encontrarPersona(personas);
       model.addAttribute("personas", personas);
       return "modificar";
    }
    
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Personas personas){
        personaService.eliminar(personas);
        return "redirect:/";
    }
    
    
}
