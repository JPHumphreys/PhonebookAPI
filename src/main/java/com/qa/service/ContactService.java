package com.qa.service;

import com.qa.Models.Contact;
import com.qa.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService{

    @Autowired
    ContactRepository contrepo;

    public List<Contact> getAllContacts(){
        List<Contact> cont = new ArrayList<>();
        contrepo.findAll().forEach(contact -> cont.add(contact));
        return cont;
    }

    public Contact getContactById(int id){
        return contrepo.findById(id).get();
    }

    public Contact getContactByName(String firstName){
        return contrepo.findByFirstName(firstName);
    }

    public void saveContact(Contact cont){
        contrepo.save(cont);
    }

    public void deleteContact(int id){
        contrepo.deleteById(id);
    }

}