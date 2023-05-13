package com.commercial.commande.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"name"})
@Table
@Entity
@Data

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private float tax;

    @Column
    private BigDecimal price;

    @Column(name= "units_in_stock")
    private int unitsInStock;


    @ManyToOne
    @JsonIgnore

    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
