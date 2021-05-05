package com.Anvesh.petclinicspring.services;

import com.Anvesh.petclinicspring.model.Owner;

public interface OwnerService extends CrudRepository<Owner, Long> {
    Owner findBySecondname(String lastName);
}
