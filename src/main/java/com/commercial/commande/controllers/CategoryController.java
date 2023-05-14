package com.commercial.commande.controllers;


import com.commercial.commande.DTOS.CategoryDTO;
import com.commercial.commande.services.CategoryService;
import com.commercial.commande.models.entities.Category;

import com.commercial.commande.models.entities.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController  {

    @Autowired
    CategoryService cs;
    @Autowired
    private ObjectMapper objectMapper;



    @GetMapping("/category")
    private List<Category> getAllCategories(){
        return cs.getAllCategories();
    }
    @GetMapping("/category/{id}/products")
    private Set<Product> getAllCategoryProducts(@PathVariable("id") Long id){
       Category category = cs.getCategoryById(id);
       Set<Product> products = category.getProducts();
        return products;
    }

    @GetMapping("/category/{id}")
    private Category getCategory(@PathVariable("id") Long id){
        return cs.getCategoryById(id);
    }

    @DeleteMapping("/category/{id}")
    private void deleteCategory(@PathVariable("id") Long id)
    {
        cs.delete(id);
    }

    @PostMapping(value = "/category")
    private Category saveCategory(@RequestBody CategoryDTO a)
    {
        Category c=new Category();
        c.setId(0L);
        c.setName(a.name);
        cs.saveOrUpdate(c);
        return c;
    }

    @PutMapping("/category")
    private Category update(@RequestBody  CategoryDTO a)
    {
        Category c = objectMapper.convertValue(a, Category.class);
        cs.saveOrUpdate(c);
        return c;
    }



}
