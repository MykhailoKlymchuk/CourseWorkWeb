package com.eco.service;

import com.eco.exception._NotFoundException;
import com.eco.model.WaterPollution;
import com.eco.repository.WaterPollutionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class WaterPollutionService {
    private final WaterPollutionRepo waterPollutionRepo;

    @Autowired
    public WaterPollutionService(WaterPollutionRepo waterPollutionRepo) {
        this.waterPollutionRepo = waterPollutionRepo;
    }

    public WaterPollution addWaterPollution(WaterPollution waterPollution) {
        if (waterPollution.getDate() == null)
            waterPollution.setDate(
                    new SimpleDateFormat("yyyy-mm-dd")
                            .format(Calendar.getInstance()
                                    .getTime())
            );
        return waterPollutionRepo.save(waterPollution);
    }

    public List<WaterPollution> findAllWaterPollutions() {
        return waterPollutionRepo.findAll();
    }

    public WaterPollution updateWaterPollution(WaterPollution waterPollution) {
        return waterPollutionRepo.save(waterPollution);
    }

    public WaterPollution findWaterPollutionById(Long id) {
        return waterPollutionRepo.findWaterPollutionById(id)
                .orElseThrow(() -> new _NotFoundException("Object WaterPollution by id " + id + "was not found"));
    }

    public void deleteWaterPollutionById(Long id) {
        waterPollutionRepo.deleteWaterPollutionById(id);
    }
}