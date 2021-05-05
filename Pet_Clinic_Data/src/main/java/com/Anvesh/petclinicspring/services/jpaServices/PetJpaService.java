package com.Anvesh.petclinicspring.services.jpaServices;

import com.Anvesh.petclinicspring.model.Pet;
import com.Anvesh.petclinicspring.repositories.PetRepository;
import com.Anvesh.petclinicspring.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetJpaService implements PetService {
    private final PetRepository repository;

    public PetJpaService(PetRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        repository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return repository.save(object);
    }

    @Override
    public void delete(Pet object) {
        repository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);

    }
}
