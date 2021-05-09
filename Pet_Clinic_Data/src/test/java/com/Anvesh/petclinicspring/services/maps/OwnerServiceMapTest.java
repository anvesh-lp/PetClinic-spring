package com.Anvesh.petclinicspring.services.maps;

import com.Anvesh.petclinicspring.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {
    final String lastName = "Anvesh";
    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap();
        ownerServiceMap.save(Owner.builder().id(1L).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(1L));
        assertEquals(0, ownerServiceMap.findAll().size());

    }

    @Test
    void deleteById() {
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);
        assertEquals(1L, owner.getId());
    }

    @Test
    void findBySecondname() {
        Owner owner = ownerServiceMap.findBySecondname(lastName);
        assertNotNull(owner);
        assertEquals(lastName, owner.getSecondname());
    }

    @Test
    void invalidLastName() {
        Owner owner = ownerServiceMap.findBySecondname("noo");
        assertNull(owner);
    }
}