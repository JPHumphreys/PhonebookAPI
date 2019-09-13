package com.qa.controllers;

import com.qa.Models.Contact;
import com.qa.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ContactController {

    @Autowired
    ContactService contservice;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView message(){
        ModelAndView mv = new ModelAndView("Index");
        mv.addObject("contacts", contservice.getAllContacts());
        mv.addObject("contact", new Contact());
        return mv;
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public RedirectView submitContact(@ModelAttribute Contact cont){
       contservice.saveContact(cont);
       return new RedirectView("/");
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public RedirectView deleteContact(@PathVariable ("id") int id){
        contservice.deleteContact(id);
        return new RedirectView("/");
    }

    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public Contact editContact(@PathVariable int id){
        return contservice.getContactById(id);
    }

    @RequestMapping(value="/findOne/{name}", method = RequestMethod.GET)
    public Contact searchContact(@PathVariable String firstName){
        return contservice.getContactByName(firstName);
    }
}
