package com.commercial.commande.repositories;

import com.commercial.commande.models.entities.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
}
