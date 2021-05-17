package com.Anvesh.petclinicspring.services.jpaServices;

import com.Anvesh.petclinicspring.model.Visit;
import com.Anvesh.petclinicspring.repositoriesJPA.VisitRepository;
import com.Anvesh.petclinicspring.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@Profile("springdatajpa")
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
