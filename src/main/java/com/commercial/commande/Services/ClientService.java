
package com.commercial.commande.services;

import com.commercial.commande.DTOS.ClientDTO;
import com.commercial.commande.models.entities.Client;
import com.commercial.commande.repositories.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository cr;
    public List<ClientDTO> getAllClients()
    {
        ObjectMapper m = new ObjectMapper();

        List<ClientDTO> clients = new ArrayList<ClientDTO>();
        cr.findAll().forEach(client -> clients.add(m.convertValue(client, ClientDTO.class)));
        return clients;
    }


    public Client getClientById(Long id)
    {
        return cr.findById(id).get();
    }



    public void saveOrUpdate(Client client)
    { cr.save(client);
    }


    public void delete(Long id)
    {
        cr.deleteById(id);
    }
}

