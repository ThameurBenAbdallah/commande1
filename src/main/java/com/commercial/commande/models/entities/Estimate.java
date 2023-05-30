package com.commercial.commande.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Estimate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "estimate")
    private Set<EstimateLine> estimateLines;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "estimate_date")
    @CreationTimestamp
    private Date estimateDate;





}
