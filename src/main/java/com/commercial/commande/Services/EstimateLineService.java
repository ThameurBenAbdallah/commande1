package com.commercial.commande.services;

import com.commercial.commande.models.entities.EstimateLine;
import com.commercial.commande.repositories.EstimateLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class EstimateLineService {
    @Autowired
    EstimateLineRepository er;
    public List<EstimateLine> getAllEstimateLines()
    {
        List<EstimateLine> allEstimateLines = new ArrayList<EstimateLine>();
        er.findAll().forEach(allEstimateLines::add);
        return allEstimateLines;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public EstimateLine getEstimateLineById(Long id)
    {
        return er.findById(id).get();
    }


    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(EstimateLine estimateLine)
    {
        er.save(estimateLine);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(Long id)
    {
        er.deleteById(id);
    }



}
