package com.Anvesh.petclinicspring.services.jpaServices;

import com.Anvesh.petclinicspring.model.Owner;
import com.Anvesh.petclinicspring.repositoriesJPA.OwnerRepository;
import com.Anvesh.petclinicspring.repositoriesJPA.PetRepository;
import com.Anvesh.petclinicspring.repositoriesJPA.PetTypeRepository;
import com.Anvesh.petclinicspring.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetTypeRepository petTypeRepository;
    private final PetRepository petRepository;

    public OwnerJpaService(OwnerRepository ownerRepository, PetTypeRepository petTypeRepository, PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.petTypeRepository = petTypeRepository;
        this.petRepository = petRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findBySecondname(String lastName) {
        return ownerRepository.findBySecondname(lastName);
    }
}
