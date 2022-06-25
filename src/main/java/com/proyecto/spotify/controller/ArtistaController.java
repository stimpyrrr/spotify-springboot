package com.proyecto.spotify.controller;

import com.proyecto.spotify.model.Artista;
import com.proyecto.spotify.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artista")
public class ArtistaController {

    @Autowired
    private final ArtistaService artistaService;

    @Autowired
    //por si hacemos unos test unitarios en medico controller, nos pida private final MedicoService medicoService; como dependencia el test
    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    @GetMapping
    public List<Artista> findAll(){
        return artistaService.findAll();
    }

    @GetMapping("{id}")
    public Artista findById(@PathVariable("id") Integer id){
        return artistaService.findById(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Artista> findAllByName(@PathVariable("nombre") String nombre){
        return artistaService.findAllByName(nombre);
    }

    @PostMapping
    public Artista save(@RequestBody Artista artista){
        return artistaService.save(artista);
    }

    @PutMapping("/{id}")
    public Artista update(@RequestBody Artista artista, @PathVariable("id") Integer id){
        return artistaService.update(artista, id);
    }
}
