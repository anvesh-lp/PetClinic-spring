package com.Anvesh.petclinicspring.repositories;

import com.Anvesh.petclinicspring.model.PetType;
import org.springframework.data.repository.CrudRepository;


public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
