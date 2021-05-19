package com.Anvesh.petclinicspring.controllers;


import com.Anvesh.petclinicspring.model.Owner;
import com.Anvesh.petclinicspring.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping({"/owners"})
@Controller
public class OwnersController {
    private final OwnerService ownerService;

    private final String VIEW_CREATE_OR_UPDATE = "owners/createOrUpdate";
    private final String VIEW_OWNERS_LIST = "owners/ownersList";

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/find"})
    public String findOwner(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findowners";
    }

    @GetMapping("")
    public String processFindOwners(Owner owner, BindingResult result, Model model) {
        String name = owner.getSecondname();
        List<Owner> owners = ownerService.findbyLastnameLike(name);
        if (owners.size() == 0) {
            result.rejectValue("secondname", "notFound", "Not Found");
            return "owners/findowners";
        } else if (owners.size() == 1) {
            return "redirect:/owners/" + owners.get(0).getId();
        } else {
            model.addAttribute("selections", owners);
            return VIEW_OWNERS_LIST;
        }
    }


    @GetMapping({"/{id}"})
    public ModelAndView findOwnerDetails(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("owners/ownerdetails");
        mav.addObject(ownerService.findById(id));
        return mav;
    }

    @GetMapping({"/new"})
    public String initOwner(Model model) {
        Owner owner = new Owner();
        model.addAttribute("owner", owner);
        return VIEW_CREATE_OR_UPDATE;
    }

    @PostMapping({"/new"})
    public String processCreatOrUpdate(@Validated Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEW_CREATE_OR_UPDATE;
        } else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping({"{id}/edit"})
    public String initialupdateOwner(@PathVariable Long id, Model model) {
        Owner owner = ownerService.findById(id);
        model.addAttribute("owner", owner);
        return VIEW_CREATE_OR_UPDATE;
    }

    @PostMapping({"{id}/edit"})
    public String performUpdateOwner(Owner owner, @PathVariable Long id) {
        Owner saved = ownerService.save(owner);
        return "redirect:/owners/" + saved.getId();
    }

}
