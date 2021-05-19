package com.Anvesh.petclinicspring.controllers;


import com.Anvesh.petclinicspring.model.Owner;
import com.Anvesh.petclinicspring.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping({"/owners"})
@Controller
public class OwnersController {
    private final OwnerService ownerService;

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
            return "owners/ownersList";
        }
    }


    @GetMapping({"/{id}"})
    public ModelAndView findOwnerDetails(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("owners/ownerdetails");
        mav.addObject(ownerService.findById(id));
        return mav;
    }
}
