package com.commercial.commande.DTOS;

import com.commercial.commande.models.entities.Estimate;
import com.commercial.commande.models.entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;

public class EstimateLineDTO {
    public Long id;
    public BigDecimal discount;

    public BigDecimal estimateLineQuantity;


    public ProductDTO product;





}
