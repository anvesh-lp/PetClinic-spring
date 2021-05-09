package com.Anvesh.petclinicspring.repositoriesJPA;

import com.Anvesh.petclinicspring.model.Vet;
import org.springframework.data.repository.CrudRepository;


public interface VetRepository extends CrudRepository<Vet, Long> {
}
