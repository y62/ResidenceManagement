package com.example.bas.Repository.Residence;
import com.example.bas.Service.Model.Residence;
import java.util.List;
import java.util.Optional;

public interface ResidenceRepository {

    List<Residence> getAllResidences();
    int createResidence(Residence residence);
    int updateResidence(Residence residence);
    int deleteResidence(int residenceId);
    Optional<Residence> findResidenceById(int residenceId);
}
