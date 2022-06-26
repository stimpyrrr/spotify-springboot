package com.proyecto.spotify.service.impl;

import com.proyecto.spotify.exception.ModeloNotFoundException;
import com.proyecto.spotify.model.Usuario;
import com.proyecto.spotify.repository.UsuarioRepository;
import com.proyecto.spotify.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()){
            return usuario.get();
        }
        else{
            throw new ModeloNotFoundException("El usuario no fue encontrado o su valor es nulo");
        }
        //return usuario.isPresent() ? usuario.get() : new Usuario();
    }

    @Override
    public List<Usuario> findAllByName(String nombre) {
        return usuarioRepository.findAllByNombre(nombre);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    @Override
    public Usuario update(Usuario usuario, Integer id) {
        return save(usuario);
    }

    @Override
    public boolean deleteById(Integer id) {
        usuarioRepository.deleteById(id);
        return true;
    }

}
