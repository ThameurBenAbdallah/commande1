package com.commercial.commande.repositories;


import com.commercial.commande.models.entities.Command;
import org.springframework.data.repository.CrudRepository;

public interface CommandRepository extends CrudRepository<Command, Long> {

}
