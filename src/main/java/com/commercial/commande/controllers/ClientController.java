package com.commercial.commande.controllers;

import com.commercial.commande.services.ClientService;
import com.commercial.commande.models.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService cs;
    @GetMapping("")
    private List<Client> getAllClients(){
        return cs.getAllClients();
    }

    @GetMapping("/{id}")
    private Client getClient(@PathVariable("id") Long id){
        return cs.getClientById(id);
    }

    @DeleteMapping("/{id}")
    private void deleteClient(@PathVariable("id") Long id)
    {
        cs.delete(id);
    }

    @PostMapping("")
    private Client saveClient(@RequestBody Client a)
    {
        cs.saveOrUpdate(a);
        return a;
    }

    @PutMapping("/")
    private Client update(@RequestBody  Client a)
    {
        cs.saveOrUpdate(a);
        return a;
    }



}
