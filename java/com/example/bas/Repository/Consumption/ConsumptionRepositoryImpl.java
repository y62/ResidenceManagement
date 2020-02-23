package com.example.bas.Repository.Consumption;

import com.example.bas.Service.Model.Consumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Vi annoterer klassen som Repository.
 * jdbcTemplate bruges til at få adgang til relational database.
 *  ? bruges som argumenter til at undgå SQL injection attacks.
 */
@Repository("ConsumptionRepositoryImpl")
public class ConsumptionRepositoryImpl implements ConsumptionRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Consumption> getAllConsumptions() {
        return jdbcTemplate.query(
                "select * from basdb.consumption",
                (resultSet, rowNum) ->
                        new Consumption(
                                resultSet.getInt("consumption_id"),
                                resultSet.getInt("power"),
                                resultSet.getInt("water"),
                                resultSet.getInt("heat"),
                                resultSet.getInt("price_per_user"),
                                resultSet.getString("date_registered")
                        )
        );
    }

    @Override
    public int create(Consumption consumption) {
        return jdbcTemplate.update(
                "insert into consumption (consumption_id, power, water, heat, price_per_user, date_registered) values(?,?,?,?,?,?)",
                consumption.getConsumptionId(), consumption.getPower(), consumption.getWater(), consumption.getHeat(), consumption.getPricePerUser(), consumption.getDateRegistered());
    }

    @Override
    public int update(Consumption consumption) {
        return jdbcTemplate.update(
                "update consumption set power = ?, water = ?, heat = ?, price_per_user = ?, date_registered = ? where consumption_id = ?",
                consumption.getPower(), consumption.getWater(), consumption.getHeat(), consumption.getPricePerUser(), consumption.getDateRegistered(), consumption.getConsumptionId());
    }

    @Override
    public int delete(int consumptionId) {
        return jdbcTemplate.update(
                "delete FROM consumption where consumption_id = ?",
                consumptionId);
    }

    @Override
    public Optional<Consumption> findConsumptionById(int consumptionId) {
        return jdbcTemplate.queryForObject(
                "select * from consumption where consumption_id = ?",
                new Object[]{consumptionId},
                (resultSet, rowNum) ->
                        Optional.of(new Consumption(
                                resultSet.getInt("consumption_id"),
                                resultSet.getInt("power"),
                                resultSet.getInt("water"),
                                resultSet.getInt("heat"),
                                resultSet.getInt("price_per_user"),
                                resultSet.getString("date_registered")
                        ))
        );
    }
}
