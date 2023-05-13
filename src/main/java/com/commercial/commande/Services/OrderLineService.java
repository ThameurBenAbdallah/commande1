package com.commercial.commande.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commercial.commande.models.entities.OrderLine;
import com.commercial.commande.repositories.OrderLineRepository;

import java.util.ArrayList;  
import java.util.List;  
  
@Service

public class OrderLineService {
	@Autowired  
	OrderLineRepository aR;  
	//getting all books record by using the method findaAll() of CrudRepository  

	//getting all books record by using the method findaAll() of CrudRepository  
	public List<OrderLine> getAllOrderLines()   
	{  
		List<OrderLine> orderLines = new ArrayList<OrderLine>();  
		aR.findAll().forEach(a -> orderLines.add(a));  
		return orderLines;  	
	}  

	//getting a specific record by using the method findById() of CrudRepository  
	public OrderLine getOrderLineById(Long id)
	{  
		return aR.findById(id).get();  
	}  


	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(OrderLine orderLine)   
	{  
		aR.save(orderLine);  
	} 

	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(Long id)   
	{  
		aR.deleteById(id);  
	} 
}
