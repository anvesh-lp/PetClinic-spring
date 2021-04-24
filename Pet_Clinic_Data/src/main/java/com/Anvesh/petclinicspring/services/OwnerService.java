package com.Anvesh.petclinicspring.services;

import com.Anvesh.petclinicspring.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);

    Owner findOwner(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
