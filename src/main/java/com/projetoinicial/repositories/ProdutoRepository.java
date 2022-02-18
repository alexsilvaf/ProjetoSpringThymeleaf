package com.projetoinicial.repositories;

import com.projetoinicial.models.ProdutoEntity;
import com.projetoinicial.models.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    ProdutoEntity findProdutoEntityById(Long id);
    ProdutoEntity findProdutoEntityByNome(String nome);
}
