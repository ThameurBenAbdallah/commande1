package com.commercial.commande.services;

import com.commercial.commande.DTOS.EstimateDTO;
import com.commercial.commande.DTOS.EstimateLineDTO;
import com.commercial.commande.models.entities.Client;
import com.commercial.commande.models.entities.Estimate;

import com.commercial.commande.models.entities.EstimateLine;
import com.commercial.commande.models.entities.Product;
import com.commercial.commande.repositories.EstimateLineRepository;
import com.commercial.commande.repositories.EstimateRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


@Service
public class EstimateService  {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    EstimateRepository er;
    @Autowired
    EstimateLineRepository elr;
    public List<Estimate> getAllEstimates()
    {
        List<Estimate> allEstimates = new ArrayList<Estimate>();
        er.findAll().forEach(allEstimates::add);
        return allEstimates;
    }


    public Estimate getEstimateById(Long id)
    {
        return er.findById(id).get();
    }


    public Estimate saveOrUpdate(EstimateDTO estimateDTO)
    {



        // Create an Estimate entity from the EstimateDTO
        Estimate estimate = new Estimate();
        Client client = objectMapper.convertValue(estimateDTO.client, Client.class);
        estimate.setClient(client);
        // Set other properties of the estimate
        estimate.setEstimateDate(estimateDTO.estimateDate);

        // Save the estimate and obtain the saved entity with the generated ID
        Estimate savedEstimate = er.save(estimate);

        // Create and save EstimateLine entities from the EstimateLineDTOs
        Set<EstimateLineDTO> estimateLinesDTO = estimateDTO.estimateLines;



        estimateLinesDTO.forEach(el -> {
                    EstimateLine estimateLine = objectMapper.convertValue(el, EstimateLine.class);



                    // Set the estimate for the estimate line
                    estimateLine.setEstimate(savedEstimate);

                    // Save the estimate line
                    elr.save(estimateLine);

                }
            );




        return savedEstimate;





    }


    public void delete(Long id)
    {
        er.deleteById(id);
    }


}
