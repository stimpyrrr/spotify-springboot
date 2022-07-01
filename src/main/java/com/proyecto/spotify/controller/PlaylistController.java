package com.proyecto.spotify.controller;

import com.proyecto.spotify.dto.PlaylistDTO;
import com.proyecto.spotify.exception.ModeloNotFoundException;
import com.proyecto.spotify.model.Cancion;
import com.proyecto.spotify.model.Playlist;
import com.proyecto.spotify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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

    /*@GetMapping("{id}")
    public Playlist findById(@PathVariable("id") Integer id){
        return playlistService.findById(id);
    }*/

    @GetMapping("/nombre/{nombre}")
    public List<Playlist> findAllByName(@PathVariable("nombre") String nombre){
        return playlistService.findAllByName(nombre);
    }

    public ResponseEntity<Playlist> listarPorId(@PathVariable("id") Integer id){
        Playlist obj = playlistService.leerPorId(id);
        if(obj.getIdPlaylist() == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        return new ResponseEntity<Playlist>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlaylistDTO> listarHateoas() {
        List<Playlist> playlists = new ArrayList<>();
        List<PlaylistDTO> playlistsDTO = new ArrayList<>();
        playlists = playlistService.findAll();

        for (Playlist p : playlists){
            PlaylistDTO d = new PlaylistDTO();
            d.setIdPlaylist(d.getIdPlaylist());

            // localhost:8080/playlist/1
            ControllerLinkBuilder linkTo = linkTo(methodOn(PlaylistController.class).listarPorId((p.getIdPlaylist())));
            d.add(linkTo.withSelfRel());
            playlistsDTO.add(d);

            // localhost:8080/cancion/1
            //ControllerLinkBuilder linkTo1 = linkTo(methodOn(CancionController.class).findById((p.getPaciente().getIdPaciente())));
            //d.add(linkTo1.withSelfRel());
            //consultasDTO.add(d);
        }
        return playlistsDTO;

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
