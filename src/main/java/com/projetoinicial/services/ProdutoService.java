package com.projetoinicial.services;

import com.projetoinicial.models.ProdutoEntity;
import com.projetoinicial.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public List<ProdutoEntity> findAll(){

        return produtoRepository.findAll();
    }


    public boolean save(ProdutoEntity produtoEntity) {
        ProdutoEntity produtoEncontrado = produtoRepository.findProdutoEntityById(produtoEntity.getId());
        if(produtoEncontrado == null)
            produtoEncontrado = produtoRepository.findProdutoEntityByNome(produtoEntity.getNome());

        if(produtoEncontrado == null)
            produtoRepository.save(produtoEntity);

        return true;
    }

    public boolean update(ProdutoEntity produto, ProdutoEntity produtoAtualizado){
        produto.update(produtoAtualizado);
        produtoRepository.save(produto);
        return true;
    }

    public void delete(ProdutoEntity produtoEntity) {

        produtoRepository.delete(produtoEntity);
    }

    public ProdutoEntity findProdutoEntityById(Long id) {
        ProdutoEntity produtoEntity = produtoRepository.findProdutoEntityById(id);

        return produtoEntity;
    }
}
