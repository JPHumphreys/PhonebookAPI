package com.qa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.Models.Contact;
import org.springframework.data.repository.CrudRepository;


public interface ContactRepository extends CrudRepository<Contact, Integer> {
    Contact findByName(String firstName);
}
