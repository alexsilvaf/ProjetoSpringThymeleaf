package com.projetoinicial.controllers;

import com.projetoinicial.models.UsuarioEntity;
import com.projetoinicial.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ModelAndView listarUsuarios(){

        ModelAndView mav = new ModelAndView("usuarios_listar");

        mav.addObject("titulo", "Usuários");

        List<UsuarioEntity> usuarios = usuarioService.findAll();

        mav.addObject("listaDeUsuarios", usuarios);

        return mav;
    }

    @GetMapping("/add")
    public String addUsuarioPage(UsuarioEntity usuarioEntity){

        return "usuarios_add";
    }

    @PostMapping("/add")
    public String addUsuario(UsuarioEntity usuarioEntity){

        usuarioService.save(usuarioEntity);
        return "redirect:/usuarios/";
    }

    @GetMapping("/deletar/{id}")
    public String deletarUsuarioPage(@PathVariable(value= "id") Long id){

        UsuarioEntity usuarioEntity = usuarioService.findUsuarioEntityById(id);
        usuarioService.delete(usuarioEntity);

        return "redirect:/usuarios/";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarPage(@PathVariable(value= "id") Long id){

        UsuarioEntity usuarioEntity = usuarioService.findUsuarioEntityById(id);
        ModelAndView mav = new ModelAndView("usuarios_editar");
        mav.addObject(usuarioEntity);

        return mav;
    }

    @PostMapping("/editar/{id}")
    public String editarUsuario(UsuarioEntity usuarioEntity){

        usuarioService.save(usuarioEntity);

        return "redirect:/usuarios/";
    }
}
