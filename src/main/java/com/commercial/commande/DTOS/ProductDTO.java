package com.commercial.commande.DTOS;

import com.commercial.commande.models.entities.Category;
import lombok.Data;

import java.math.BigDecimal;


@Data

public class ProductDTO {

    public Long id;

    public String name;

    public String description;
    public float tax;

    public BigDecimal price;

    public int unitsInStock;

    public CategoryDTO category;

}
