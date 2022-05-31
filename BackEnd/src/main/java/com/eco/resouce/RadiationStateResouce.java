package com.eco.resouce;

import com.eco.model.RadiationState;
import com.eco.service.RadiationStateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/radiation")
public class RadiationStateResouce {
    private final RadiationStateService radiationStateService;

    public RadiationStateResouce(RadiationStateService radiationStateService) {
        this.radiationStateService = radiationStateService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RadiationState>> getRadiationState() {
        List<RadiationState> radiationStates = radiationStateService.findAllRadiationStates();
        return new ResponseEntity<>(radiationStates, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<RadiationState> getRadiationStateById(@PathVariable("id") Long id) {
        RadiationState radiationState  = radiationStateService.findRadiationStateById(id);
        return new ResponseEntity<>(radiationState, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RadiationState> addRadiationState(@RequestBody RadiationState radiationState) {
        RadiationState newRadiationState = radiationStateService.addRadiationState(radiationState);
        return new ResponseEntity<>(newRadiationState, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<RadiationState> updateRadiationState(@RequestBody RadiationState radiationState) {
        RadiationState updateRadiationState = radiationStateService.updateRadiationState(radiationState);
        return new ResponseEntity<>(updateRadiationState, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRadiationState(@PathVariable("id") Long id) {
        radiationStateService.deleteRadiationStateById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
