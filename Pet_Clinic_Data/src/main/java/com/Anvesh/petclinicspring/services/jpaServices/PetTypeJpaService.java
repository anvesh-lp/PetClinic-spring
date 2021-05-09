package com.Anvesh.petclinicspring.services.jpaServices;

import com.Anvesh.petclinicspring.model.PetType;
import com.Anvesh.petclinicspring.repositoriesJPA.PetTypeRepository;
import com.Anvesh.petclinicspring.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeJpaService implements PetTypeService {
    private final PetTypeRepository repository;

    public PetTypeJpaService(PetTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        repository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return repository.save(object);
    }

    @Override
    public void delete(PetType object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
