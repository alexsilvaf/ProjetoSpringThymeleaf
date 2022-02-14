package com.projetoinicial.services;

import com.projetoinicial.models.UsuarioEntity;
import com.projetoinicial.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioEntity> findAll(){
        return usuarioRepository.findAll();
    }


    public void save(UsuarioEntity usuarioEntity) {

        usuarioRepository.save(usuarioEntity);
    }

    public UsuarioEntity findUsuarioEntityById(Long id) {
        UsuarioEntity usuarioEntity = usuarioRepository.findUsuarioEntityById(id);

        return usuarioEntity;
    }

    public void delete(UsuarioEntity usuarioEntity) {

        usuarioRepository.delete(usuarioEntity);
    }
}
