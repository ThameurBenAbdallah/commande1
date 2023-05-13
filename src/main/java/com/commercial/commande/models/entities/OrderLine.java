package com.commercial.commande.models.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table

public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number")
    private Long orderNumber;

    @OneToOne(optional=false)
    @JoinColumn(name = "product_id", referencedColumnName="id")
    private Product product;

    @ManyToOne(optional=false)
    @JoinColumn(name="command_id", referencedColumnName="id")
    private Command command;


}
