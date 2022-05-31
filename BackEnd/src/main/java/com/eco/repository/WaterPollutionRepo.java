package com.eco.repository;

import com.eco.model.WaterPollution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WaterPollutionRepo extends JpaRepository<WaterPollution, Long> {
    void deleteWaterPollutionById(Long id);
    Optional<WaterPollution> findWaterPollutionById(Long id);
}