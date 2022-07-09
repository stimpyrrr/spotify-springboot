package com.proyecto.spotify.controller;

import com.proyecto.spotify.dto.ArtistaListaCancionDTO;
import com.proyecto.spotify.model.Artista;
import com.proyecto.spotify.service.ArtistaService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @ApiOperation(value = "Obtener todos los artistas",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Artistas")
    @ApiResponse(code = 200, message = "ApiResponseMesages.ITEM_FETCHED",
            response = Artista.class, responseContainer = "List")
    @ApiImplicitParams({ @ApiImplicitParam(name = "artista", value = "List of strings", paramType = "body", dataType =
            "Artista") })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron artistas en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping
    public List<Artista> findAll(){
        return artistaService.findAll();
    }

    @ApiOperation(value = "Obtener a un artista en específico",
            notes = "Se necesita parámetro de entrada",
            response = Artista.class,
            responseContainer = "Artistas")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron artistas en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("{id}")
    public Artista findById(@PathVariable("id") Integer id){
        return artistaService.findById(id);
    }

    @ApiOperation(value = "Obtener a un artista por nombre",
            notes = "Se necesita parámetro de entrada",
            response = Artista.class,
            responseContainer = "Artistas")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron artistas en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/nombre/{nombre}")
    public List<Artista> findAllByName(@PathVariable("nombre") String nombre){
        return artistaService.findAllByName(nombre);
    }

    @ApiOperation(value = "Guardar Artista",
            notes = "Se necesita parámetro de entrada",
            response = Artista.class,
            responseContainer = "Artistas")
    @ApiResponse(code = 200, message = "ApiResponseMesages.ITEM_FETCHED",
            response = Artista.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron artistas en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody ArtistaListaCancionDTO artistaDTO){
        Artista obj = artistaService.registrarTransaccional(artistaDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdArtista()).toUri();
        //return ResponseEntity.created(location).build();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    /*@PostMapping
    public Artista save(@RequestBody Artista artista){
        return artistaService.save(artista);
    }*/

    @ApiOperation(value = "Actualizar Artista",
            notes = "Se necesita parámetro de entrada",
            response = Artista.class,
            responseContainer = "Artistas")
    @ApiResponse(code = 200, message = "ApiResponseMesages.ITEM_FETCHED",
            response = Artista.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron artistas en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping("/{id}")
    public Artista update(@RequestBody Artista artista, @PathVariable("id") Integer id){
        return artistaService.update(artista, id);
    }
}
