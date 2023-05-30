
package com.commercial.commande.services;

import com.commercial.commande.models.entities.Account;
import com.commercial.commande.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
     AccountRepository cr;
    public List<Account> getAllAccounts()
    {
        List<Account> allAccounts = new ArrayList<Account>();
        cr.findAll().forEach(allAccounts::add);
        return allAccounts;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public Account getAccountById(Long id)
    {
        return cr.findById(id).get();
    }


    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Account account)
    {
        cr.save(account);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(Long id)
    { cr.deleteById(id);
    }
}

