package net.yorksolutions.dontaviousgreencontactprjbe.service;


import net.yorksolutions.dontaviousgreencontactprjbe.Entity.Account;
import net.yorksolutions.dontaviousgreencontactprjbe.Entity.Contacts;
import net.yorksolutions.dontaviousgreencontactprjbe.dto.NewContactRequestDTO;
import net.yorksolutions.dontaviousgreencontactprjbe.repository.AccountRepository;
import net.yorksolutions.dontaviousgreencontactprjbe.repository.ContactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ContactService {

    private ContactRepository contactRepository;
    private AccountRepository accountRepository;

    public ContactService(ContactRepository contactRepository, AccountRepository accountRepository) {
        this.contactRepository = contactRepository;
        this.accountRepository = accountRepository;
    }


    public Contacts create(NewContactRequestDTO requestDTO) {

        //figure out how you will create a contact
        //this method will create the new contact
        //Order of data:
        //Account owner, String firstname, String lastname, Date birthdate, String relation, String notes
        //and return the new contact data back to the client

        //you will run into an issue with the id.
        //by standard it is type long but it will ask for a type Account
        //take the idea and findbyusername in the repo and search to see if it exist
        //remember that findby always returns an Option. Define the type also
        Optional<Account> accountOpt = this.accountRepository.findById(requestDTO.owner);

        //validate that you found the correct account

        if (accountOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        //changed the required requestDTO.owner = accountOpt.get()
        //this change places the found user id into the new generated contact
        //pass the new contact obj as an argument and save it in the repo
        //Contacts contacts = new Contacts(accountOpt.get(), requestDTO.firstname, requestDTO.lastname, requestDTO.birthdate, requestDTO.relation, requestDTO.notes);
       return this.contactRepository.save(new Contacts(accountOpt.get(), requestDTO.firstname, requestDTO.lastname, requestDTO.birthdate, requestDTO.relation, requestDTO.notes));

    }
}
