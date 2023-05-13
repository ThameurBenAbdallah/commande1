package com.commercial.commande.models.entities;

import com.commercial.commande.models.enums.Roles;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"name","surname","phone","mail"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String phone;

    @Column
    private String mail;

    @Column
    private Roles role = Roles.USER;

    @OneToOne
    @JoinColumn(name="account_id", referencedColumnName = "id")
    private Account account;

}
