package com.Anvesh.petclinicspring.controllers;


import com.Anvesh.petclinicspring.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/owners"})
@Controller
public class OwnersController {
    private final OwnerService service;

    public OwnersController(OwnerService service) {
        this.service = service;
    }

    @RequestMapping({"", "/owners"})
    public String ownerList(Model model) {
        model.addAttribute("owners", service.findAll());
        return "owners/ownersList";
    }

    @RequestMapping({"/find"})
    public String findOwner(Model model) {
        return "owners/find";
    }
}
