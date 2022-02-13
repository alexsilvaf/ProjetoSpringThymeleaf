package com.projetoinicial.controllers;

import com.projetoinicial.models.UsuarioEntity;
import com.projetoinicial.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ModelAndView listarUsuarios(){

        ModelAndView mav = new ModelAndView("usuarios_listar");

        mav.addObject("titulo", "Usuários");

        List<UsuarioEntity> usuarios = usuarioRepository.findAll();

        mav.addObject("listaDeUsuarios", usuarios);

        return mav;
    }

    @GetMapping("/add")
    public String addUsuarioPage(UsuarioEntity usuarioEntity){

        return "usuarios_add";
    }

    @PostMapping("/add")
    public String addUsuario(UsuarioEntity usuarioEntity){

        usuarioRepository.save(usuarioEntity);
        return "redirect:/usuarios/";
    }

    @GetMapping("/deletar/{id}")
    public String deletarUsuarioPage(@PathVariable(value= "id") Long id){

        UsuarioEntity usuarioEntity = usuarioRepository.findUsuarioEntityById(id);
        usuarioRepository.delete(usuarioEntity);

        return "redirect:/usuarios/";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarPage(@PathVariable(value= "id") Long id){

        UsuarioEntity usuarioEntity = usuarioRepository.findUsuarioEntityById(id);
        ModelAndView mav = new ModelAndView("usuarios_editar");
        mav.addObject(usuarioEntity);

        return mav;
    }

    @PutMapping("/editar/{id}")
    public String editarUsuario(@RequestBody UsuarioEntity usuarioEntity){

        UsuarioEntity novoUsuario = usuarioRepository.findUsuarioEntityById(usuarioEntity.getId());
        novoUsuario.setNome(usuarioEntity.getNome());
        novoUsuario.setEmail(usuarioEntity.getEmail());
        novoUsuario.setIdade(usuarioEntity.getIdade());
        usuarioRepository.save(novoUsuario);

        return "redirect:/usuarios/";
    }
}
