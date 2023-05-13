package com.commercial.commande.repositories;


import com.commercial.commande.models.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
