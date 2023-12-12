package com.rez63.pp312.dao;


import com.rez63.pp312.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUserById(Long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
