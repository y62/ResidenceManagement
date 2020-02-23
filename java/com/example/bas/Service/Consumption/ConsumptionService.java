package com.example.bas.Service.Consumption;

import com.example.bas.Service.Model.Consumption;
import java.util.List;
import java.util.Optional;

/**
 * Lister og metoder som skal implementeres i ConsumptionServiceImpl
 */
public interface ConsumptionService {

    List<Consumption> getAllConsumptions();
    void create(Consumption consumption);
    void update(Consumption consumption);
    void delete(int consumptionId);
    Optional<Consumption> findConsumptionById(int consumptionId);
}
