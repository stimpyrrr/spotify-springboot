package com.proyecto.spotify.service.impl;

import com.proyecto.spotify.model.Playlist;
import com.proyecto.spotify.repository.PlaylistRepository;
import com.proyecto.spotify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Playlist findById(Integer id) {
        Optional<Playlist> playlist = playlistRepository.findById(id);
        return playlist.isPresent() ? playlist.get() : new Playlist();
    }

    @Override
    public List<Playlist> findAllByName(String nombre) {
        return playlistRepository.findAllByNombre(nombre);
    }

    @Override
    public Playlist save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist update(Playlist playlist, Integer id) {
        return save(playlist);
    }

    @Override
    public boolean deleteById(Integer id) {
        playlistRepository.deleteById(id);
        return true;
    }

}
