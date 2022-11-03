package net.yorksolutions.dontaviousgreencontactprjbe.repository;


import net.yorksolutions.dontaviousgreencontactprjbe.Entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//CRUD repo gives us the ability to create, delete and update data
//inside the database
//<Login, Long> Connects the repo to the Login table
//long = indicates what type of primary key the table has

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
