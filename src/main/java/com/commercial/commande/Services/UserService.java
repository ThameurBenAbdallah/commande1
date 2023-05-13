package com.commercial.commande.services;

import com.commercial.commande.models.entities.User;
import com.commercial.commande.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserService {

    @Autowired
    UserRepository er;
    public List<User> getAllUsers()
    {
        List<User> allUsers = new ArrayList<User>();
        er.findAll().forEach(allUsers::add);
        return allUsers;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public User getUserById(Long id)
    {
        return er.findById(id).get();
    }


    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(User user)
    {
        er.save(user);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(Long id)
    {
        er.deleteById(id);
    }

}
