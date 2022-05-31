package com.eco.service;

import com.eco.exception._NotFoundException;
import com.eco.model.RadiationState;
import com.eco.model.SoilPollution;
import com.eco.repository.SoilPollutionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class SoilPollutionService {
    private final SoilPollutionRepo soilPollutionRepo;

    @Autowired
    public SoilPollutionService(SoilPollutionRepo soilPollutionRepo) {
        this.soilPollutionRepo = soilPollutionRepo;
    }

    public SoilPollution addSoilPollution(SoilPollution soilPollution) {
        if (soilPollution.getDate() == null)
            soilPollution.setDate(
                    new SimpleDateFormat("yyyy-mm-dd")
                            .format(Calendar.getInstance()
                                    .getTime())
            );
        return soilPollutionRepo.save(soilPollution);
    }

    public List<SoilPollution> findAllSoilPollutions() {
        return soilPollutionRepo.findAll();
    }

    public SoilPollution updateSoilPollution(SoilPollution soilPollution) {
        return soilPollutionRepo.save(soilPollution);
    }

    public SoilPollution findSoilPollutionById(Long id) {
        return soilPollutionRepo.findSoilPollutionById(id).orElseThrow(() -> new _NotFoundException("Object SoilPollution by id " + id + "was not found"));
    }

    public void deleteSoilPollutionById(Long id) {
        soilPollutionRepo.deleteSoilPollutionById(id);
    }
}
