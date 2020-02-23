package com.example.bas.Repository.Consumption;

import com.example.bas.Service.Model.Consumption;
import java.util.List;
import java.util.Optional;

/**
 * Lister og metoder som skal implementeres i ConsumptionRepositoryImpl
 */
public interface ConsumptionRepository {

        List<Consumption> getAllConsumptions();
        int create(Consumption consumption);
        int update(Consumption consumption);
        int delete(int consumptionId);
        Optional<Consumption> findConsumptionById(int consumptionId);

}
