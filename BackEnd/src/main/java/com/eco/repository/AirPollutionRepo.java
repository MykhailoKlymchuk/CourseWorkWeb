package com.eco.repository;

import com.eco.model.AirPollution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirPollutionRepo extends JpaRepository<AirPollution, Long> {
    void deleteAirPollutionById(Long id);
    Optional<AirPollution> findAirPollutionById(Long id);
}
