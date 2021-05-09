package com.Anvesh.petclinicspring.repositoriesJPA;

import com.Anvesh.petclinicspring.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findBySecondname(String name);
}
