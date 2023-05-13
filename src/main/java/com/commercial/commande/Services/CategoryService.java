
package com.commercial.commande.services;

import com.commercial.commande.models.entities.Category;
import com.commercial.commande.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {


    @Autowired
    CategoryRepository cr;
    public List<Category> getAllCategories()
    {
        List<Category> categories = new ArrayList<Category>();
        cr.findAll().forEach(categories::add);
        return categories;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public Category getCategoryById(Long id)
    {
        return cr.findById(id).get();
    }


    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Category category)
    {
        cr.save(category);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(Long id)
    {
        cr.deleteById(id);
    }
}

