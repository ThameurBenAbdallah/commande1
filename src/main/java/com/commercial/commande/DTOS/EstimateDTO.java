package com.commercial.commande.DTOS;

import java.util.Date;
import java.util.Set;

public class EstimateDTO {
    public Long id;

    public ClientDTO client;

    public Set<EstimateLineDTO> estimateLines;

    public Date estimateDate;
}
