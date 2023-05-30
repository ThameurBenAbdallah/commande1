package com.commercial.commande.models.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "order_date")
    @CreationTimestamp
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "estimate_id")
    private Estimate estimate;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "command" )
    private Set<OrderLine> orderLines;


}
