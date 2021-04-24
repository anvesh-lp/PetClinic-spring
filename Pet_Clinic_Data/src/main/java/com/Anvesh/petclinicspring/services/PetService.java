package com.Anvesh.petclinicspring.services;

import com.Anvesh.petclinicspring.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findOwner(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
