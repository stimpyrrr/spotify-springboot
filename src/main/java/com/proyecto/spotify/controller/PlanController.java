package com.proyecto.spotify.controller;

import com.proyecto.spotify.model.Plan;
import com.proyecto.spotify.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/plan")
public class PlanController {

    private final PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public List<Plan> findAll(){
        return planService.findAll();
    }

    @GetMapping("/nombre/{nombre}")
    public List<Plan> findAllByName(@PathVariable("nombre") String nombre){
        return planService.findAllByName(nombre);
    }

    @PostMapping
    public Plan save(@RequestBody Plan plan){
        return planService.save(plan);
    }
}
