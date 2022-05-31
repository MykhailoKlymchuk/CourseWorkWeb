package com.eco.resouce;

import com.eco.model.SoilPollution;
import com.eco.service.SoilPollutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soil")
public class SoilPollutionResource {
    private final SoilPollutionService soilPollutionService;

    public SoilPollutionResource(SoilPollutionService soilPollutionService) {
        this.soilPollutionService = soilPollutionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SoilPollution>> getSoilPollutions() {
        List<SoilPollution> soilPollutions = soilPollutionService.findAllSoilPollutions();
        return new ResponseEntity<>(soilPollutions, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SoilPollution> getSoilPollutionById(@PathVariable("id") Long id) {
        SoilPollution soilPollution  = soilPollutionService.findSoilPollutionById(id);
        return new ResponseEntity<>(soilPollution, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SoilPollution> addRadiationState(@RequestBody SoilPollution soilPollution) {
        SoilPollution newSoilPollution = soilPollutionService.addSoilPollution(soilPollution);
        return new ResponseEntity<>(newSoilPollution, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<SoilPollution> updateRadiationState(@RequestBody SoilPollution soilPollution) {
        SoilPollution updateSoilPollution = soilPollutionService.updateSoilPollution(soilPollution);
        return new ResponseEntity<>(updateSoilPollution, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRadiationState(@PathVariable("id") Long id) {
        soilPollutionService.deleteSoilPollutionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
