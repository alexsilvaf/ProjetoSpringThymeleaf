package com.projetoinicial.services;

import com.projetoinicial.models.SateliteEntity;
import com.projetoinicial.repositories.SateliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SateliteService {

    @Autowired
    SateliteRepository sateliteRepository;

    public void buscarSatelite(){
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate = restTemplateBuilder.build();

        SateliteEntity satelite = restTemplate.getForObject("https://api.wheretheiss.at/v1/satellites/25544", SateliteEntity.class);
        save(satelite);
    }

    public void save(SateliteEntity sateliteEntityJson){

        SateliteEntity sateliteEntityEncontrado = sateliteRepository.findSateliteEntityById(sateliteEntityJson.getId());

        if(sateliteEntityEncontrado == null){
            sateliteRepository.save(sateliteEntityJson);
        } else{
            update(sateliteEntityEncontrado, sateliteEntityJson);
        }

    }

    public void update(SateliteEntity sateliteEntityEncontrado, SateliteEntity sateliteEntityJson){

        sateliteEntityEncontrado.update(sateliteEntityJson);

        sateliteRepository.save(sateliteEntityEncontrado);
    }
}
