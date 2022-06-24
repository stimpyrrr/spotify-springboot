package com.proyecto.spotify.service.impl;

import com.proyecto.spotify.model.Plan;
import com.proyecto.spotify.repository.PlanRepository;
import com.proyecto.spotify.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    @Autowired
    public PlanServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    @Override
    public Plan save(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public List<Plan> findAllByName(String nombre) {
        return null;
    }
}
