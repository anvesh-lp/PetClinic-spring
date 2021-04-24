package com.Anvesh.petclinicspring.services;

import com.Anvesh.petclinicspring.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findOwner(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
