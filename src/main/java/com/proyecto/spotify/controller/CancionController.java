package com.proyecto.spotify.controller;

import com.proyecto.spotify.model.Artista;
import com.proyecto.spotify.model.Cancion;
import com.proyecto.spotify.service.CancionService;
import io.swagger.annotations.*;
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

    @ApiOperation(value = "Obtener todas las canciones",
            notes = "No necesita parametros de entrada",
            response = Cancion.class,
            responseContainer = "Cancion")
    @ApiResponse(code = 200, message = "ApiResponseMesages.ITEM_FETCHED",
            response = Cancion.class, responseContainer = "List")
    @ApiImplicitParams({ @ApiImplicitParam(name = "cancion", value = "List of strings", paramType = "body", dataType =
            "Cancion") })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron canciones en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping
    public List<Cancion> findAll(){
        return cancionService.findAll();
    }

    @ApiOperation(value = "Obtener canciones por id",
            notes = "No necesita parametros de entrada",
            response = Cancion.class,
            responseContainer = "Cancion")
    @ApiResponse(code = 200, message = "ApiResponseMesages.ITEM_FETCHED",
            response = Cancion.class, responseContainer = "List")
    @ApiImplicitParams({ @ApiImplicitParam(name = "cancion", value = "List of strings", paramType = "body", dataType =
            "Cancion") })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron canciones en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("{id}")
    public Cancion findById(@PathVariable("id") Integer id){
        return cancionService.findById(id);
    }

    @ApiOperation(value = "Obtener canciones por nombre",
            notes = "No necesita parametros de entrada",
            response = Cancion.class,
            responseContainer = "Cancion")
    @ApiResponse(code = 200, message = "ApiResponseMesages.ITEM_FETCHED",
            response = Cancion.class, responseContainer = "List")
    @ApiImplicitParams({ @ApiImplicitParam(name = "cancion", value = "List of strings", paramType = "body", dataType =
            "Cancion") })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron canciones en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/nombre/{nombre}")
    public List<Cancion> findAllByName(@PathVariable("nombre") String nombre){
        return cancionService.findAllByName(nombre);
    }

    @ApiOperation(value = "Guardar canción",
            notes = "No necesita parametros de entrada",
            response = Cancion.class,
            responseContainer = "Cancion")
    @ApiResponse(code = 200, message = "ApiResponseMesages.ITEM_FETCHED",
            response = Cancion.class, responseContainer = "List")
    @ApiImplicitParams({ @ApiImplicitParam(name = "cancion", value = "List of strings", paramType = "body", dataType =
            "Cancion") })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron canciones en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping
    public Cancion save(@RequestBody Cancion cancion){
        return cancionService.save(cancion);
    }

    @ApiOperation(value = "Actualizar canción",
            notes = "No necesita parametros de entrada",
            response = Cancion.class,
            responseContainer = "Cancion")
    @ApiResponse(code = 200, message = "ApiResponseMesages.ITEM_FETCHED",
            response = Cancion.class, responseContainer = "List")
    @ApiImplicitParams({ @ApiImplicitParam(name = "cancion", value = "List of strings", paramType = "body", dataType =
            "Cancion") })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron canciones en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping("/{id}")
    public Cancion update(@RequestBody Cancion cancion, @PathVariable("id") Integer id){
        return cancionService.update(cancion, id);
    }
}
