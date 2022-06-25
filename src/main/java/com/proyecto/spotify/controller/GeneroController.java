package com.proyecto.spotify.controller;

import com.proyecto.spotify.model.Genero;
import com.proyecto.spotify.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private final GeneroService generoService;

    @Autowired
    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @GetMapping
    public List<Genero> findAll(){
        return generoService.findAll();
    }

    @GetMapping("{id}")
    public Genero findById(@PathVariable("id") Integer id){
        return generoService.findById(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Genero> findAllByName(@PathVariable("nombre") String nombre){
        return generoService.findAllByName(nombre);
    }

    @PostMapping
    public Genero save(@RequestBody Genero genero){
        return generoService.save(genero);
    }

    @PutMapping("/{id}")
    public Genero update(@RequestBody Genero genero, @PathVariable("id") Integer id){
        return generoService.update(genero, id);
    }
}
