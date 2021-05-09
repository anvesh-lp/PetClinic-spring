package com.Anvesh.petclinicspring.repositoriesJPA;

import com.Anvesh.petclinicspring.model.PetType;
import org.springframework.data.repository.CrudRepository;


public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
