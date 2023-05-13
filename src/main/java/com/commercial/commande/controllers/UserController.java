package com.commercial.commande.controllers;

import com.commercial.commande.services.UserService;
import com.commercial.commande.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/User")
public class UserController{

    @Autowired
    UserService cs;

   

    @GetMapping("")
    private List<User> getAllClients(){
        return cs.getAllUsers();
    }

    @GetMapping("/{id}")
    private User getClient(@PathVariable("id") Long id){
        return cs.getUserById(id);
    }

    @DeleteMapping("/{id}")
    private void deleteUser(@PathVariable("id") Long id)
    {
        cs.delete(id);
    }

    @PostMapping("")
    private User saveUser(@RequestBody User a)
    {
        cs.saveOrUpdate(a);
        return a;
    }

    @PutMapping("/")
    private User update(@RequestBody  User a)
    {
        cs.saveOrUpdate(a);
        return a;
    }



}


