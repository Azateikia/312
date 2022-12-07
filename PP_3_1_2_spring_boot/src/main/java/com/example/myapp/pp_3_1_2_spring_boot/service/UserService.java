package com.example.myapp.pp_3_1_2_spring_boot.service;


import com.example.myapp.pp_3_1_2_spring_boot.model.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();
    void saveUser(User user);
    void removeUser(int id);
    User getUserById(int id);
    void update(int id, User user);
}
