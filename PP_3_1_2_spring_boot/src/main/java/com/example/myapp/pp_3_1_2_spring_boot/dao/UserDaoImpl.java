package com.example.myapp.pp_3_1_2_spring_boot.dao;

import com.example.myapp.pp_3_1_2_spring_boot.model.User;
import jakarta.persistence.*;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Component
public class UserDaoImpl implements UserDao{


    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUserList() {
        return entityManager.createQuery( "from User" ).getResultList();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void removeUser(int id) {
        User user = getUserById(id);
        entityManager.remove(user);
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Transactional
    @Override
    public void update(int id, User userWithNewUpdates) {
        User userToUpdate = getUserById(id);
        userToUpdate = entityManager.merge(userWithNewUpdates);


    }
}
