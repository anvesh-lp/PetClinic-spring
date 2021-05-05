package com.Anvesh.petclinicspring.repositories;

import com.Anvesh.petclinicspring.model.Pet;
import com.Anvesh.petclinicspring.services.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
