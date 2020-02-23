package com.example.bas.Repository.User;

import com.example.bas.Service.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository("UserRepositoryImpl")
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(
                "select * from basdb.users",
                (resultSet, rowNum) ->
                        new User(
                                resultSet.getInt("user_id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("email"),
                                resultSet.getInt("telephone_number"),
                                resultSet.getInt("age"),
                                resultSet.getString("cpr"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getInt("enabled")
                        )
        );
    }

    @Override
    public int create(User user) {
        return jdbcTemplate.update(
                "insert into users (user_id, first_name, last_name, email, telephone_number, age, cpr, username, password) values(?,?,?,?,?,?,?,?,?)",
                user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getTelephoneNumber(), user.getAge(), user.getCpr(), user.getUsername(), user.getPassword());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update(
                "update users set first_name = ?, last_name = ?, email = ?, telephone_number = ?, age = ?, cpr = ?, username = ?, password = ? where user_id = ?",
                user.getFirstName(), user.getLastName(), user.getEmail(), user.getTelephoneNumber(), user.getAge(), user.getCpr(), user.getUsername(), user.getPassword(), user.getUserId());
    }

    @Override
    public int delete(int userId) {
        return jdbcTemplate.update(
                "delete FROM users where user_id = ?",
                userId);
    }

    @Override
    public Optional<User> findUserById(int userId) {
        return jdbcTemplate.queryForObject(
                "select * from users where user_id = ?",
                new Object[]{userId},
                (resultSet, rowNum) ->
                        Optional.of(new User(
                                resultSet.getInt("user_id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("email"),
                                resultSet.getInt("telephone_number"),
                                resultSet.getInt("age"),
                                resultSet.getString("cpr"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getInt("enabled")
                        ))
        );
    }
}