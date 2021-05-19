package com.Anvesh.petclinicspring.controllers;


import com.Anvesh.petclinicspring.model.Owner;
import com.Anvesh.petclinicspring.model.PetType;
import com.Anvesh.petclinicspring.services.OwnerService;
import com.Anvesh.petclinicspring.services.PetService;
import com.Anvesh.petclinicspring.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Controller
public class PetController {
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final OwnerService ownerService;

    public PetController(PetTypeService petTypeService, PetService petService, OwnerService ownerService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.ownerService = ownerService;
    }


    @ModelAttribute("types")
    public Collection<PetType> getTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner getOwner(@PathVariable("ownerid") Long ownerid) {
        return ownerService.findById(ownerid);
    }

    @InitBinder("owner")
    public void InitOwnerBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
    }


}
