package com.proyecto.spotify.controller;

import com.proyecto.spotify.model.Playlist;
import com.proyecto.spotify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public List<Playlist> findAll(){
        return playlistService.findAll();
    }

    @GetMapping("{id}")
    public Playlist findById(@PathVariable("id") Integer id){
        return playlistService.findById(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Playlist> findAllByName(@PathVariable("nombre") String nombre){
        return playlistService.findAllByName(nombre);
    }

    @PostMapping
    public Playlist save(@RequestBody Playlist playlist){
        return playlistService.save(playlist);
    }

    @PutMapping("/{id}")
    public Playlist update(@RequestBody Playlist playlist, @PathVariable("id") Integer id){
        return playlistService.update(playlist, id);
    }
}
