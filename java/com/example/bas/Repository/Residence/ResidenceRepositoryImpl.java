package com.example.bas.Repository.Residence;

import com.example.bas.Service.Model.Residence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository("ResidenceRepositoryImpl")
public class ResidenceRepositoryImpl implements ResidenceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createResidence(Residence residence) {
        return jdbcTemplate.update(
                "insert into residence (residence_id, username, rental_number, size, rooms, address) values(?,?,?,?,?,?)",
                residence.getResidenceId(), residence.getUsername(), residence.getRentalNumber(), residence.getSize(), residence.getRoom(), residence.getAddress());
    }

    @Override
    public List<Residence> getAllResidences() {
        return jdbcTemplate.query(
                "select * from basdb.residence",
                (resultSet, rowNum) ->
                        new Residence(
                                resultSet.getInt("residence_id"),
                                resultSet.getString("username"),
                                resultSet.getInt("rental_number"),
                                resultSet.getInt("size"),
                                resultSet.getInt("rooms"),
                                resultSet.getString("address")
                        )
        );
    }

    @Override
    public int updateResidence(Residence residence) {
        return jdbcTemplate.update(
                "update residence set username = ?, rental_number = ?, size = ?, rooms = ?, address = ? where residence_id = ?",
                residence.getUsername(), residence.getRentalNumber(), residence.getSize(), residence.getRoom(), residence.getAddress(), residence.getResidenceId());
    }

    @Override
    public int deleteResidence(int residenceId) {
        return jdbcTemplate.update(
                "delete FROM residence where residence_id = ?",
                residenceId);
    }

    @Override
    public Optional<Residence> findResidenceById(int residenceId) {
        return jdbcTemplate.queryForObject(
                "select * from residence where residence_id = ?",
                new Object[]{residenceId},
                (resultSet, rowNum) ->
                        Optional.of(new Residence(
                                resultSet.getInt("residence_id"),
                                resultSet.getString("username"),
                                resultSet.getInt("rental_number"),
                                resultSet.getInt("size"),
                                resultSet.getInt("rooms"),
                                resultSet.getString("address")
                        ))
        );
    }
}
