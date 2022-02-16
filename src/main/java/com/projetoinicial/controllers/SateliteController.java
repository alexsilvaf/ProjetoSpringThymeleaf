package com.projetoinicial.controllers;

import com.projetoinicial.services.SateliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/satelites")
public class SateliteController {

    @Autowired
    SateliteService sateliteService;

    @GetMapping
    public String verificarSatelite(){

        sateliteService.buscarSatelite();

        return "satelites";
    }
}
