package com.Anvesh.petclinicspring.controllers;


import com.Anvesh.petclinicspring.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping({"/owners"})
@Controller
public class OwnersController {
    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/owners"})
    public String ownerList(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/ownersList";
    }

    @RequestMapping({"/find"})
    public String findOwner(Model model) {

        return "owners/find";
    }


    @GetMapping({"/{id}"})
    public ModelAndView findOwnerDetails(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("owners/ownerdetails");
        mav.addObject(ownerService.findById(id));
        return mav;
    }
}
