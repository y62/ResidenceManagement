package com.example.bas.Service.Residence;

import com.example.bas.Service.Model.Residence;
import java.util.List;
import java.util.Optional;

public interface ResidenceService {

    List<Residence> getAllResidences();
    void createResidence(Residence residence);
    void updateResidence(Residence residence);
    void deleteResidence(int residenceId);
    Optional<Residence> findResidenceById(int residenceId);
}
