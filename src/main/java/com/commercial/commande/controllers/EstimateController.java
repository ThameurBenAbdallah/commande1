package com.commercial.commande.controllers;

import com.commercial.commande.services.EstimateService;
import com.commercial.commande.models.entities.Estimate;
import com.commercial.commande.models.entities.EstimateLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/estimate")
public class EstimateController{

    @Autowired
    EstimateService cs;
    @GetMapping("")
    private List<Estimate> getAllEstimates(){
        return cs.getAllEstimates();
    }

    @GetMapping("/{id}")
    private Estimate getEstimate(@PathVariable("id") Long id){
        return cs.getEstimateById(id);
    }

    @DeleteMapping("/{id}")
    private void deleteEstimate(@PathVariable("id") Long id)
    {
        cs.delete(id);
    }

    @PostMapping("")
    private Estimate saveEstimate(@RequestBody Estimate a)
    {
        cs.saveOrUpdate(a);
        return a;
    }

    @PutMapping("/")
    private Estimate update(@RequestBody  Estimate a)
    {
        cs.saveOrUpdate(a);
        return a;
    }

    @GetMapping("/{id}/lines")
    private Set<EstimateLine> getAllEstimateLines(@PathVariable("id") Long id){
        Estimate estimate = cs.getEstimateById(id);
        Set<EstimateLine> estimateLines = estimate.getEstimateLines();
        return estimateLines;
    }




}

