package com.projetoinicial.controllers;

import com.projetoinicial.models.ProdutoEntity;
import com.projetoinicial.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("produtos");
        modelAndView.addObject("listaDeProdutos", produtoService.findAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView adicionarPage(ProdutoEntity produto){
        ModelAndView modelAndView = new ModelAndView("produtos_add");
        modelAndView.addObject(produto);

        return modelAndView;
    }

    @PostMapping("/add")
    public String adicionar(ProdutoEntity produto){
        produtoService.save(produto);

        return "redirect:/produtos/";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable(value = "id") Long id){
        ProdutoEntity produto = produtoService.findProdutoEntityById(id);
        produtoService.delete(produto);

        return "redirect:/produtos/";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarPage(@PathVariable(value = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("produtos_editar");

        ProdutoEntity produto = produtoService.findProdutoEntityById(id);
        modelAndView.addObject(produto);

        return modelAndView;
    }

    @PostMapping("/editar/{id}")
    public String editar(@PathVariable Long id, ProdutoEntity produtoNovo){

        ProdutoEntity produto = produtoService.findProdutoEntityById(id);
        produtoService.update(produto, produtoNovo);
        return "redirect:/produtos/";
    }
}
