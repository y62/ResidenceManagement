package com.example.bas.Service.User;

import com.example.bas.Service.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();
    void create(User user);
    void update(User user);
    void delete(int userId);
    Optional<User> findUserById(int userId);
}
