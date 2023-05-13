package com.commercial.commande.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commercial.commande.models.entities.Command;
import com.commercial.commande.repositories.CommandRepository;


import java.util.ArrayList;  
import java.util.List;  
  
@Service

public class CommandService {
	@Autowired  
	CommandRepository aR;  
	//getting all books record by using the method findaAll() of CrudRepository  

	//getting all books record by using the method findaAll() of CrudRepository  
	public List<Command> getAllCommands()   
	{  
		List<Command> Commands = new ArrayList<Command>();  
		aR.findAll().forEach(a -> Commands.add(a));  
		return Commands;  	
	}  

	//getting a specific record by using the method findById() of CrudRepository  
	public Command getCommandById(Long id)   
	{  
		return aR.findById(id).get();  
	}  


	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Command Command)   
	{  
		aR.save(Command);  
	} 

	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(Long id)   
	{  
		aR.deleteById(id);  
	} 
}

