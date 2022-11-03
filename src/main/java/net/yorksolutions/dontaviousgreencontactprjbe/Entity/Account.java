package net.yorksolutions.dontaviousgreencontactprjbe.Entity;


import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //username must be included and it must be unique (only one exist)
    @Column(nullable = false, unique = true)
    private String username;
    private String password;

    //create a generic constructor to clear error
    //no ARGS? Constructor
    //TODO find out why this is needed and what is it called
    public Account() {
    }

    public Account(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    //getters and setters are used to access the private information
    public Long getId() {
        return id;
    }

    //removed the setId to eliminate anyway to change the ID

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
