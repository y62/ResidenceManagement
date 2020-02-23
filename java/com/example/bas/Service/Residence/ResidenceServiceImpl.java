package com.example.bas.Service.Residence;

import com.example.bas.Service.Model.Residence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ResidenceServiceImpl implements ResidenceService {

    @Autowired

    @Qualifier("ResidenceRepositoryImpl")
    com.example.bas.Repository.Residence.ResidenceRepository ResidenceRepository;

    @Override
    public List<Residence> getAllResidences() {
        return ResidenceRepository.getAllResidences();
    }

    @Override
    public void createResidence(Residence residence) {
        ResidenceRepository.createResidence(residence);
    }

    @Override
    public void updateResidence(Residence residence) {
        ResidenceRepository.updateResidence(residence);
    }

    @Override
    public void deleteResidence(int residenceId) {
        ResidenceRepository.deleteResidence(residenceId);
    }

    @Override
    public Optional<Residence> findResidenceById(int residenceId) {
        return ResidenceRepository.findResidenceById(residenceId);
    }
}
