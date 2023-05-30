package com.commercial.commande.DTOS;

import com.commercial.commande.models.entities.Command;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class ClientDTO {
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String phone;
}