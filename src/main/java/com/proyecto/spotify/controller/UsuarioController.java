package com.proyecto.spotify.controller;

import com.proyecto.spotify.model.Usuario;
import com.proyecto.spotify.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/nombre/{nombre}")
    public List<Usuario> findAllByName(@PathVariable("nombre") String nombre){
        return usuarioService.findAllByName(nombre);
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@RequestBody Usuario plan, @PathVariable("id") Integer id){
        return usuarioService.update(plan, id);
    }
}
