package com.eco.service;

import com.eco.exception._NotFoundException;
import com.eco.model.RadiationState;
import com.eco.repository.RadiationStateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class RadiationStateService {
    private final RadiationStateRepo radiationStateRepo;

    @Autowired
    public RadiationStateService(RadiationStateRepo radiationStateRepo) {
        this.radiationStateRepo = radiationStateRepo;
    }

    public RadiationState addRadiationState(RadiationState radiationState) {
        if (radiationState.getDate() == null)
            radiationState.setDate(
                    new SimpleDateFormat("yyyy-mm-dd")
                            .format(Calendar.getInstance()
                                    .getTime())
            );
        return radiationStateRepo.save(radiationState);
    }

    public List<RadiationState> findAllRadiationStates() {
        return radiationStateRepo.findAll();
    }

    public RadiationState updateRadiationState(RadiationState radiationState) {
        return radiationStateRepo.save(radiationState);
    }

    public RadiationState findRadiationStateById(Long id) {
        return radiationStateRepo.findRadiationStateById(id).orElseThrow(() -> new _NotFoundException("Object RadiationState by id " + id + "was not found"));
    }

    public void deleteRadiationStateById(Long id) {
        radiationStateRepo.deleteRadiationStateById(id);
    }
}
