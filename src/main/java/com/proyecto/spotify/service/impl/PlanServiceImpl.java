package com.proyecto.spotify.service.impl;

import com.proyecto.spotify.exception.ModeloNotFoundException;
import com.proyecto.spotify.model.Plan;
import com.proyecto.spotify.repository.PlanRepository;
import com.proyecto.spotify.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Plan findById(Integer id) {
        Optional<Plan> plan = planRepository.findById(id);
        if (plan.isPresent()){
            return plan.get();
        }else{
            throw new ModeloNotFoundException("Error al encontrar Plan");
        }
        //return plan.isPresent() ? plan.get() : new Plan();
    }

    @Override
    public Plan save(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public Plan update(Plan plan, Integer id) {
        Optional<Plan> findPlan = planRepository.findById(id);
        if (findPlan.isPresent()){
            plan.setIdPlan(id);
            return save(plan);
        }
        else{
            return new Plan();
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public List<Plan> findAllByName(String nombre) {
        return planRepository.findAllByNombre(nombre);
    }



}
