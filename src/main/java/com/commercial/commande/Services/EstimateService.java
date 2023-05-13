package com.commercial.commande.services;

import com.commercial.commande.models.entities.Estimate;

import com.commercial.commande.repositories.EstimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class EstimateService  {
    @Autowired
    EstimateRepository er;
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


    public void saveOrUpdate(Estimate estimate)
    {
        er.save(estimate);
    }


    public void delete(Long id)
    {
        er.deleteById(id);
    }


}
