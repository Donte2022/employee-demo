package net.yorksolutions.dontaviousgreencontactprjbe.repository;


import net.yorksolutions.dontaviousgreencontactprjbe.Entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//CRUD repo gives us the ability to create, delete and update data
//inside the database
//<Login, Long> Connects the repo to the Login table
//long = indicates what type of primary key the table has

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    //create a method to find the username in the database
    //this method will return an optional because of: findBy keyword
    //findByUsername is a new method created using the repo
    //to find users by their username for the login
    Optional<Account>findByUsername(String username);

    Optional<Account>findByUsernameAndPassword(String username, String password);
}
