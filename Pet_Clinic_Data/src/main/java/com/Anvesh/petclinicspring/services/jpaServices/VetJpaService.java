package com.Anvesh.petclinicspring.services.jpaServices;

import com.Anvesh.petclinicspring.model.Vet;
import com.Anvesh.petclinicspring.repositories.VetRepository;
import com.Anvesh.petclinicspring.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService {
    private final VetRepository repository;

    public VetJpaService(VetRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        repository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return repository.save(object);
    }

    @Override
    public void delete(Vet object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
