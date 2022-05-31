package com.eco.repository;

import com.eco.model.SoilPollution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SoilPollutionRepo extends JpaRepository<SoilPollution, Long> {
    void deleteSoilPollutionById(Long id);
    Optional<SoilPollution> findSoilPollutionById(Long id);
}