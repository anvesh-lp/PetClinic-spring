package com.Anvesh.petclinicspring.services.jpaServices;

import com.Anvesh.petclinicspring.model.Visit;
import com.Anvesh.petclinicspring.repositories.VisitRepository;
import com.Anvesh.petclinicspring.services.VisitService;

import java.util.HashSet;
import java.util.Set;

public class VisitJpaService implements VisitService {
    private final VisitRepository repository;

    public VisitJpaService(VisitRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visitSet = new HashSet<>();
        repository.findAll().forEach(visitSet::add);
        return visitSet;
    }

    @Override
    public Visit findById(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return repository.save(object);
    }

    @Override
    public void delete(Visit object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
