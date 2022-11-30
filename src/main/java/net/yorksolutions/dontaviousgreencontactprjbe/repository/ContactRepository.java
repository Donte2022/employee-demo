package net.yorksolutions.dontaviousgreencontactprjbe.repository;

import net.yorksolutions.dontaviousgreencontactprjbe.Entity.Contacts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//CrudRepository<Contacts, Long> Contacts = Entity name Long = Entity's Id type
@Repository
public interface ContactRepository extends CrudRepository<Contacts, Long>{
}
