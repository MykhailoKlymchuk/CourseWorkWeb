package com.eco.service;

import com.eco.exception._NotFoundException;
import com.eco.model.AirPollution;
import com.eco.repository.AirPollutionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class AirPollutionService {
    private final AirPollutionRepo airPollutionRepo;

    @Autowired
    public AirPollutionService(AirPollutionRepo airPollutionRepo) {
        this.airPollutionRepo = airPollutionRepo;
    }

    public AirPollution addAirPollution(AirPollution airPollution) {
        if (airPollution.getDate() == null)
            airPollution.setDate(
                    new SimpleDateFormat("yyyy-mm-dd")
                            .format(Calendar.getInstance()
                                    .getTime())
            );
        return airPollutionRepo.save(airPollution);
    }

    public List<AirPollution> findAllAirPollutions() {
        return airPollutionRepo.findAll();
    }

    public AirPollution updateAirPollution(AirPollution airPollution) {
        return airPollutionRepo.save(airPollution);
    }

    public AirPollution findAirPollutionById(Long id) {
        return airPollutionRepo.findAirPollutionById(id)
                .orElseThrow(() -> new _NotFoundException("Object AirPollution by id " + id + "was not found"));
    }

    public void deleteAirPollutionById(Long id) {
        airPollutionRepo.deleteAirPollutionById(id);
    }
}

