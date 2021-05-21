package com.Anvesh.petclinicspring.controllers;

import com.Anvesh.petclinicspring.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetsController {
    private final VetService serviceMap;

    public VetsController(VetService serviceMap) {
        this.serviceMap = serviceMap;
    }

    //when request comes for index.html page, this method picks it up and gives the responce

    @RequestMapping({"vets.html", "vets/vetsList"})
    public String vetList(Model model) {
        model.addAttribute("vets", serviceMap.findAll());
        return "vets/index";
    }
}
