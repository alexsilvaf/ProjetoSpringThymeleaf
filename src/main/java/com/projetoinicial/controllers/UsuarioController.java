package com.projetoinicial.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping
    public String listarUsuarios(){
        return "usuarios_listar";
    }

    @GetMapping("/add")
    public String addUsuario(){
        return "usuarios_add";
    }
}
