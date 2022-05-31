package com.eco.repository;

import com.eco.model.RadiationState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RadiationStateRepo extends JpaRepository<RadiationState, Long> {
    void deleteRadiationStateById(Long id);
    Optional<RadiationState> findRadiationStateById(Long id);
}
