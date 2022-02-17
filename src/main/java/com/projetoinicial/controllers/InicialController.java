package com.projetoinicial.controllers;

import com.projetoinicial.models.AcessoEntity;
import com.projetoinicial.repositories.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class InicialController {

    @Autowired
    AcessoRepository acessoRepository;

    @GetMapping
    public String inicial(){
        return "dashboard";
    }

    @GetMapping("/acessos")
    public String mostrarPaginaInicial(){

        AcessoEntity acessoEntity = new AcessoEntity();
        acessoEntity.setPagina("paginaInicial");
        acessoEntity.setData(new Date());

        acessoRepository.save(acessoEntity);

        List<AcessoEntity> acessoEntityList = acessoRepository.findAll();

        return "paginaInicial";
    }
}
