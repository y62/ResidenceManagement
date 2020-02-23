package com.example.bas.Repository.User;

import com.example.bas.Service.Model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> getAllUsers();
    int create(User user);
    int update(User user);
    int delete(int userId);
    Optional<User> findUserById(int userId);
}
