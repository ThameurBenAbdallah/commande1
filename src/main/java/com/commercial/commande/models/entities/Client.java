package com.commercial.commande.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"name","surname","address","phone"})
@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_name")
    private String name;

    @Column(name = "client_surname")
    private String surname;

    @Column(name = "client_address")
    private String address;

    @Column(name = "client_phone")
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client" )
    private Set<Command> commands;



}
