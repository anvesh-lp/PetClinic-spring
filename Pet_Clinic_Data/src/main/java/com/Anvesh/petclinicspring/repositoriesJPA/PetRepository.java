package com.Anvesh.petclinicspring.repositoriesJPA;

import com.Anvesh.petclinicspring.model.Pet;
import org.springframework.data.repository.CrudRepository;


public interface PetRepository extends CrudRepository<Pet, Long> {
}
