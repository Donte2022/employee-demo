package net.yorksolutions.dontaviousgreencontactprjbe.service;


import net.yorksolutions.dontaviousgreencontactprjbe.Entity.Account;
import net.yorksolutions.dontaviousgreencontactprjbe.dto.NewAccountRequestDTO;
import net.yorksolutions.dontaviousgreencontactprjbe.repository.AccountRepository;
import org.springframework.stereotype.Service;

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
        return this.accountRepository.save(
                new Account(requestDTO.username, requestDTO.password));

    }

    //method use to log into an account
    public void login() {

    }
}
