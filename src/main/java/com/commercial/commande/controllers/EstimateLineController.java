package com.commercial.commande.controllers;

import com.commercial.commande.services.EstimateLineService;
import com.commercial.commande.models.entities.EstimateLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/estimatelines")
public class EstimateLineController{

    @Autowired
    EstimateLineService cs;
    @GetMapping("")
    private List<EstimateLine> getAllEstimateLines(){
        return cs.getAllEstimateLines();
    }


    @GetMapping("/{id}")
    private EstimateLine getEstimateLine(@PathVariable("id") Long id){
        return cs.getEstimateLineById(id);
    }

    @DeleteMapping("/{id}")
    private void deleteEstimateLine(@PathVariable("id") Long id)
    {
        cs.delete(id);
    }

    @PostMapping("")
    private EstimateLine saveEstimateLine(@RequestBody EstimateLine a)
    {
        cs.saveOrUpdate(a);
        return a;
    }

    @PutMapping("/")
    private EstimateLine update(@RequestBody  EstimateLine a)
    {
        cs.saveOrUpdate(a);
        return a;
    }




}

