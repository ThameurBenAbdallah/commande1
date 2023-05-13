package com.commercial.commande.controllers;


import com.commercial.commande.services.CategoryService;
import com.commercial.commande.models.entities.Category;

import com.commercial.commande.models.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    CategoryService cs;



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
    private Category saveCategory(@RequestBody categoryDTO a)
    {
        Category c=new Category();
        c.setId(0L);
        c.setName(a.name);
        cs.saveOrUpdate(c);
        return c;
    }

    @PutMapping("/category")
    private Category update(@RequestBody  Category a)
    {
        cs.saveOrUpdate(a);
        return a;
    }



}
class categoryDTO {

    public String name;
    public Long id;
}