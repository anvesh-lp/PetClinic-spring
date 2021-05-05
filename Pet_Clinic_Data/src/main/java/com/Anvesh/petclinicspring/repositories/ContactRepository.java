package com.Anvesh.petclinicspring.repositories;

import com.Anvesh.petclinicspring.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
