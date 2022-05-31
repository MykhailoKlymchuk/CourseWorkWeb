package com.eco.resouce;

import com.eco.model.AirPollution;
import com.eco.service.AirPollutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/air")
public class AirPollutionResource {
    private final AirPollutionService airPollutionService;

    public AirPollutionResource(AirPollutionService airPollutionService) {
        this.airPollutionService = airPollutionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AirPollution>> getAirPollutions() {
        List<AirPollution> airPollutions = airPollutionService.findAllAirPollutions();
        return new ResponseEntity<>(airPollutions, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AirPollution> getAirPollutionById(@PathVariable("id") Long id) {
        AirPollution airPollution  = airPollutionService.findAirPollutionById(id);
        return new ResponseEntity<>(airPollution, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AirPollution> addRadiationState(@RequestBody AirPollution airPollution) {
        AirPollution newAirPollution = airPollutionService.addAirPollution(airPollution);
        return new ResponseEntity<>(newAirPollution, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AirPollution> updateAirPollution(@RequestBody AirPollution airPollution) {
        AirPollution updateAirPollution = airPollutionService.updateAirPollution(airPollution);
        return new ResponseEntity<>(updateAirPollution, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRadiationState(@PathVariable("id") Long id) {
        airPollutionService.deleteAirPollutionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
