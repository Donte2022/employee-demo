package net.yorksolutions.dontaviousgreencontactprjbe.service;


import net.yorksolutions.dontaviousgreencontactprjbe.Entity.Account;
import net.yorksolutions.dontaviousgreencontactprjbe.dto.NewAccountRequestDTO;
import net.yorksolutions.dontaviousgreencontactprjbe.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.Optional;

//tells SB that this class is a service
@Service
public class AccountService {

    //create a variable to store information
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //method use to create an account
    //DTO will return an account
    public Account create(NewAccountRequestDTO requestDTO) {

        //Create a new account object using the DTO username and password
        //access the repo to save the account to it using the save method
        //and return the save account via return statement

        //create try catch for error handling on client side
        //when creating a username that exist
        try {
            return this.accountRepository.save(
                    new Account(requestDTO.username, requestDTO.password));
        }
        catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

    }


    //this method will search the database for the accounts using the repo
    //this method does return an Optional in the form of Accounts
    public Account login(String username, String password) {
        Optional<Account> accountOpt = this.accountRepository.findByUsernameAndPassword(username, password);
        if (accountOpt.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND
            );
        }
            return accountOpt.get();
    }
}
