package com.commercial.commande.controllers;


import com.commercial.commande.services.OrderLineService;
import com.commercial.commande.models.entities.OrderLine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderLineController {

    @Autowired
    OrderLineService cs;

    @GetMapping("/orderline")
    private List<OrderLine> getAllOrderLines(){
        return cs.getAllOrderLines();
    }

    @GetMapping("/orderline/{id}")
    private OrderLine getOrderLine(@PathVariable("id") Long id){
        return cs.getOrderLineById(id);
    }

    @DeleteMapping("/orderline/{id}")
    private void deleteOrderLine(@PathVariable("id") Long id)
    {
        cs.delete(id);
    }

    @PostMapping("/orderline")
    private OrderLine saveOrderLine(@RequestBody OrderLine a)
    {
        cs.saveOrUpdate(a);
        return a;
    }

    @PutMapping("/orderline")
    private OrderLine update(@RequestBody  OrderLine a)
    {
        cs.saveOrUpdate(a);
        return a;
    }



}
