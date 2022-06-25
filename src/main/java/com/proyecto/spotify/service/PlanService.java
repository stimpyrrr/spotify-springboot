package com.proyecto.spotify.service;

import com.proyecto.spotify.model.Plan;

import java.util.List;

public interface PlanService extends ICRUD<Plan>{
    List<Plan> findAll();

    Plan save(Plan plan);

    List<Plan> findAllByName(String nombre);
}
