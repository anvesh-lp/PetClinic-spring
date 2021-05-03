package com.Anvesh.petclinicspring.controllers;

import com.Anvesh.petclinicspring.services.maps.VetServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetsController {
    private final VetServiceMap serviceMap;

    public VetsController(VetServiceMap serviceMap) {
        this.serviceMap = serviceMap;
    }

    //when request comes for vets.html page, this method picks it up and gives the responce

    @RequestMapping({"vets.html", "vets/vetsList"})
    public String vetList(Model model) {
        model.addAttribute("vets", serviceMap.findAll());
        return "vets/vetsList";
    }
}
