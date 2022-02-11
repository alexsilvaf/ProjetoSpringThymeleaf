package com.projetoinicial.repositories;

import com.projetoinicial.models.AcessoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessoRepository extends JpaRepository<AcessoEntity, Long> {
}
