package net.yorksolutions.dontaviousgreencontactprjbe.Entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //ManyToOne relationship
    //this annotation allows the user to only see their contacts and not others
    //many contacts to one user
    @ManyToOne
    Account owner;

    private String firstname;

    private String lastname;

    private Date birthdate;

    private String relation;

    private String notes;

    public Contacts(Account owner, String firstname, String lastname, Date birthdate, String relation, String notes) {
        this.owner = owner;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.relation = relation;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    //TODO find out why you need this in the controller-no args?
    public Contacts() {
    }

    //delete the setter to prevent access to change the ID
//    public void setId(Long id) {
//        this.id = id;
//    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
