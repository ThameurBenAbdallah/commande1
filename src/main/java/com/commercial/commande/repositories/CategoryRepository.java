package com.commercial.commande.repositories;


import com.commercial.commande.models.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}


