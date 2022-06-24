package com.proyecto.spotify.repository;

import com.proyecto.spotify.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
}
