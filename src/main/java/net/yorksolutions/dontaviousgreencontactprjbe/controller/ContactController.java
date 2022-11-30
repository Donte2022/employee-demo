package net.yorksolutions.dontaviousgreencontactprjbe.controller;


import net.yorksolutions.dontaviousgreencontactprjbe.Entity.Contacts;
import net.yorksolutions.dontaviousgreencontactprjbe.dto.NewContactRequestDTO;
import net.yorksolutions.dontaviousgreencontactprjbe.service.ContactService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

         ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    //(1)initialy you have no idea what type of the body you will get from the request
        //you create the DTO to define the body of the request you will get
        @PostMapping
        public Contacts createContact(@RequestBody NewContactRequestDTO requestDTO) {
            return this.contactService.create(requestDTO);


        }

}
