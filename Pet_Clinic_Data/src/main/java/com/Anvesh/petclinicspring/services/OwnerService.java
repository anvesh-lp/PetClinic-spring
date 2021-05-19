package com.Anvesh.petclinicspring.services;

import com.Anvesh.petclinicspring.model.Owner;

import java.util.List;

public interface OwnerService extends CrudRepository<Owner, Long> {
    Owner findBySecondname(String lastName);

    List<Owner> findbyLastnameLike(String secondname);
}
