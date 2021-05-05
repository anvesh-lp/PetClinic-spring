package com.Anvesh.petclinicspring.repositories;

import com.Anvesh.petclinicspring.model.Pet;
import org.springframework.data.repository.CrudRepository;


public interface PetRepository extends CrudRepository<Pet, Long> {
}
