package com.projetoinicial.controllers;

import com.projetoinicial.models.LocalizacaoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("localizacao")
public class LocalizacaoController {

    @GetMapping
    public String showLocalPage(){

        return "localizacao";
    }

    @PostMapping
    public @ResponseBody ModelAndView salvarLocalizacao(@RequestBody LocalizacaoEntity localizacao){

        ModelAndView modelAndView = new ModelAndView("usuarios_listar");

        return modelAndView;
    }
}
