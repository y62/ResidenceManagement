package com.example.bas.Service.Consumption;

import com.example.bas.Service.Model.Consumption;
import com.example.bas.Repository.Consumption.ConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Alle metoder kalder eller returner operationer fra repository klassen
 * Vi annoterer klassen som Service
 */
@Service
public class ConsumptionServiceImpl implements ConsumptionService {

    @Autowired
    ConsumptionRepository consumptionRepository;

    @Override
    public List<Consumption> getAllConsumptions() {
        return consumptionRepository.getAllConsumptions();
    }

    @Override
    public void create(Consumption consumption) {
        consumptionRepository.create(consumption);
    }

    @Override
    public void update(Consumption consumption) {
        consumptionRepository.update(consumption);
    }

    @Override
    public void delete(int consumptionId) {
        consumptionRepository.delete(consumptionId);
    }

    @Override
    public Optional<Consumption> findConsumptionById(int consumptionId) {
        return consumptionRepository.findConsumptionById(consumptionId);
    }

}
