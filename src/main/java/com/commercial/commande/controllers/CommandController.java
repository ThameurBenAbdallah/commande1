package com.commercial.commande.controllers;


import com.commercial.commande.services.CommandService;
import com.commercial.commande.models.entities.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CommandController {

    @Autowired
    CommandService cs;

    @GetMapping("/order")
    private List<Command> getAllCommands(){
        return cs.getAllCommands();
    }

    @GetMapping("/order/{id}")
    private Command getCommand(@PathVariable("id") Long id){
        return cs.getCommandById(id);
    }

    private void deleteCommand(@PathVariable("id") Long id)
    {
        cs.delete(id);
    }

    @PostMapping("/order")
    private Command saveCommand(@RequestBody Command a)
    {
        cs.saveOrUpdate(a);
        return a;
    }

    @PutMapping("/order")
    private Command update(@RequestBody  Command a)
    {
        cs.saveOrUpdate(a);
        return a;
    }



}
