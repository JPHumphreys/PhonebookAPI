package com.qa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.Models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{
}
