package com.Anvesh.petclinicspring.repositoriesJPA;

import com.Anvesh.petclinicspring.model.Visit;
import org.springframework.data.repository.CrudRepository;


public interface VisitRepository extends CrudRepository<Visit, Long> {
}
