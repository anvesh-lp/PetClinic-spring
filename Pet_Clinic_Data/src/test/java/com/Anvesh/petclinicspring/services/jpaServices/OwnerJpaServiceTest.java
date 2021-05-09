package com.Anvesh.petclinicspring.services.jpaServices;

import com.Anvesh.petclinicspring.model.Owner;
import com.Anvesh.petclinicspring.repositoriesJPA.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {
    final String lname = "Anvesh";
    final Long ID = 1L;
    Set<Owner> owners = new HashSet<>();
    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerJpaService ownerJpaService;
    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(ID).lastName(lname).build();
    }

    @Test
    void findAll() {
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        //When findall Method is called instead of going to persistence database it return this owners set
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> owners1 = ownerJpaService.findAll();
        assertEquals(2, owners1.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner o = ownerJpaService.findById(ID);
        assertNotNull(o);
//        assertEquals(ID,o.getId());
    }

    @Test
    void save() {
        Owner temp = Owner.builder().id(ID + 1).lastName(lname).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner savedOwner = ownerJpaService.save(temp);
        assertNotNull(savedOwner);

    }

    @Test
    void delete() {
        ownerJpaService.delete(returnOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerJpaService.deleteById(anyLong());
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findBySecondname() {

        when(ownerRepository.findBySecondname(any())).thenReturn(returnOwner);
        Owner owner = ownerJpaService.findBySecondname(lname);
        assertEquals(lname, owner.getSecondname());

    }
}