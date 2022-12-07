package com.example.myapp.pp_3_1_2_spring_boot.service;

import com.example.myapp.pp_3_1_2_spring_boot.dao.UserDao;
import com.example.myapp.pp_3_1_2_spring_boot.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);

    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void update(int id, User user) {
        userDao.update(id, user);
    }
}
