package com.proyecto.spotify.controller;

import com.proyecto.spotify.model.Cancion;
import com.proyecto.spotify.service.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cancion")
public class CancionController {

    @Autowired
    private final CancionService cancionService;

    @Autowired
    public CancionController(CancionService cancionService) {
        this.cancionService = cancionService;
    }

    @GetMapping
    public List<Cancion> findAll(){
        return cancionService.findAll();
    }

    @GetMapping("{id}")
    public Cancion findById(@PathVariable("id") Integer id){
        return cancionService.findById(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Cancion> findAllByName(@PathVariable("nombre") String nombre){
        return cancionService.findAllByName(nombre);
    }

    @PostMapping
    public Cancion save(@RequestBody Cancion cancion){
        return cancionService.save(cancion);
    }

    @PutMapping("/{id}")
    public Cancion update(@RequestBody Cancion cancion, @PathVariable("id") Integer id){
        return cancionService.update(cancion, id);
    }
}
