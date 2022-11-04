package net.yorksolutions.dontaviousgreencontactprjbe.controller;


import net.yorksolutions.dontaviousgreencontactprjbe.Entity.Account;
import net.yorksolutions.dontaviousgreencontactprjbe.dto.NewAccountRequestDTO;
import net.yorksolutions.dontaviousgreencontactprjbe.service.AccountService;
import org.springframework.web.bind.annotation.*;

//Controllers receives HTTP request from the client and send response back
//if needed
//create a controller that has REST features
//it also adds other annotations that you have access to

//RequestMapping = use api to specify that your connecting to your local address BE or FE
//and not the web
//account = access the account resources
@RestController
@CrossOrigin
@RequestMapping("/api/account")
public class AccountController {

    //inject service into controller
    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //public = access Account = returns an account object
    //@Requestbody allows the method to accept data coming from the post request
    //with the type Account (format)
    //DTO creates an object that defines what the Requestbody will look like
    //Add CrossOrigin annotation to keep Cors from blocking client response form BE
    @PostMapping
    public Account create(@RequestBody NewAccountRequestDTO requestDTO) {

        return this.accountService.create(requestDTO);
    }

    //allow the FE to have access to the accounts to allow the client to login
    @GetMapping
        public Account login(@RequestParam String username, @RequestParam String password) {
            return this.accountService.login(username, password);
        }
}
