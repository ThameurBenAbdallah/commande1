package com.commercial.commande.controllers;




import com.commercial.commande.DTOS.ProductDTO;
import com.commercial.commande.models.entities.Category;
import com.commercial.commande.services.ProductService;
import com.commercial.commande.models.entities.Product;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductController{

    @Autowired
    ProductService productService;
    @Autowired
    private ObjectMapper objectMapper;
    @GetMapping("")
    private List<Product> getAllClients(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    private Product getClient(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    private void deleteProduct(@PathVariable("id") Long id)
    {
        productService.delete(id);
    }

    @PostMapping("")
    private ResponseEntity<?> saveProduct(@RequestBody ProductDTO productDTO) {
    try {
        Product product = objectMapper.convertValue(productDTO, Product.class);
        productService.saveOrUpdate(product);
        ProductDTO savedProductDTO = objectMapper.convertValue(product, ProductDTO.class);
        return ResponseEntity.ok(savedProductDTO);
    } catch (IllegalArgumentException e) {
        // Handle conversion errors
        return ResponseEntity.status(HttpStatus.OK).body("exception");
    }
    }


    @PutMapping("/")
    private Product update(@RequestBody ProductDTO a)
    {

        Category c = objectMapper.convertValue(a.category, Category.class);
        Product  p =new Product();
        p.setId(0L);
        p.setName(a.name);
        p.setCategory(c);
        p.setTax(a.tax);
        p.setPrice(a.price);
        p.setUnitsInStock(a.unitsInStock);
        p.setDescription(a.description);
        productService.saveOrUpdate(p);
        return p;

    }
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query){
        return ResponseEntity.ok(productService.searchProducts(query));
    }

}


