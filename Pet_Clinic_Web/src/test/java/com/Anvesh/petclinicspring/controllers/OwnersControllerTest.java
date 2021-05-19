package com.Anvesh.petclinicspring.controllers;

import com.Anvesh.petclinicspring.model.Owner;
import com.Anvesh.petclinicspring.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnersControllerTest {

    @Mock
    OwnerService ownerService;
    //To inject Mocks
    @InjectMocks
    OwnersController controller;
    Set<Owner> ownerSet = new HashSet<>();
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    void ownerList() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerSet);
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void findOwner() throws Exception {
        mockMvc.perform(get("/owners/find")).andExpect(view().name("owners/find"));
    }

    @Test
    void findsOwnerDetails() throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        when(ownerService.findById(anyLong())).thenReturn(owner);
        mockMvc.perform(get("/owners/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerdetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1L))));

    }
}