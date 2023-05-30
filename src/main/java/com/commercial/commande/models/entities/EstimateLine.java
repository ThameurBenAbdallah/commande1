package com.commercial.commande.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table

public class EstimateLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal discount;

    private BigDecimal estimateLineQuantity;


    @ManyToOne(optional=false)
    @JoinColumn(name = "product_id", referencedColumnName="id")
    private Product product;

    @ManyToOne(optional=false)
    @JoinColumn(name="estimate_id", referencedColumnName="id")
    private Estimate estimate;


}
