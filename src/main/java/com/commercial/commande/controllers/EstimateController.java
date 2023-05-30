package com.commercial.commande.controllers;

import com.commercial.commande.DTOS.EstimateDTO;
import com.commercial.commande.models.entities.Product;
import com.commercial.commande.services.EstimateService;
import com.commercial.commande.models.entities.Estimate;
import com.commercial.commande.models.entities.EstimateLine;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/estimates")
public class EstimateController {

    @Autowired
    EstimateService cs;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("")
    private List<Estimate> getAllEstimates() {


        return cs.getAllEstimates();
    }

    @GetMapping("/{id}")
    private Estimate getEstimate(@PathVariable("id") Long id) {
        return cs.getEstimateById(id);
    }

    @DeleteMapping("/{id}")
    private void deleteEstimate(@PathVariable("id") Long id) {
        cs.delete(id);
    }


    @PostMapping("")
    private ResponseEntity<EstimateDTO> saveEstimate(@RequestBody EstimateDTO estimateDTO) {

        // Save the estimate and obtain the saved entity with the generated ID
        Estimate savedEstimate = cs.saveOrUpdate(estimateDTO);

        // Update the estimateDTO with the saved estimate's ID
        estimateDTO.id = savedEstimate.getId();

        // Return the saved estimateDTO with the updated ID
        return ResponseEntity.ok(estimateDTO);


    }

    @PutMapping("/")
    private EstimateDTO update(@RequestBody EstimateDTO a) {
        cs.saveOrUpdate(a);
        return a;
    }

    @GetMapping("/{id}/lines")
    private Set<EstimateLine> getAllEstimateLines(@PathVariable("id") Long id) {
        Estimate estimate = cs.getEstimateById(id);
        return estimate.getEstimateLines();
    }



}

