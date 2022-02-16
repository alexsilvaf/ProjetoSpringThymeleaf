package com.projetoinicial.repositories;

import com.projetoinicial.models.SateliteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SateliteRepository extends JpaRepository<SateliteEntity, Long> {

    public SateliteEntity findSateliteEntityById(int id);
}
