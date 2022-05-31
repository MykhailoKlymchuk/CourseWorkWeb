package com.eco.resouce;

import com.eco.model.WaterPollution;
import com.eco.service.WaterPollutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/water")
public class WaterPollutionResouce {
    private final WaterPollutionService waterPollutionService;

    public WaterPollutionResouce(WaterPollutionService waterPollutionService) {
        this.waterPollutionService = waterPollutionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<WaterPollution>> getWaterPollutions() {
        List<WaterPollution> waterPollutions = waterPollutionService.findAllWaterPollutions();
        return new ResponseEntity<>(waterPollutions, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<WaterPollution> getWaterPollutionById(@PathVariable("id") Long id) {
        WaterPollution waterPollution  = waterPollutionService.findWaterPollutionById(id);
        return new ResponseEntity<>(waterPollution, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<WaterPollution> addWaterPollution(@RequestBody WaterPollution waterPollution) {
        WaterPollution newWaterPollution = waterPollutionService.addWaterPollution(waterPollution);
        return new ResponseEntity<>(newWaterPollution, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<WaterPollution> updateWaterPollution(@RequestBody WaterPollution waterPollution) {
        WaterPollution updateWaterPollution = waterPollutionService.updateWaterPollution(waterPollution);
        return new ResponseEntity<>(updateWaterPollution, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWaterPollution(@PathVariable("id") Long id) {
        waterPollutionService.deleteWaterPollutionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
