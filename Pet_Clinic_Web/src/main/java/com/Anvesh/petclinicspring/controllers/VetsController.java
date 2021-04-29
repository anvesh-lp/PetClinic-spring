package com.Anvesh.petclinicspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetsController {

    @RequestMapping({"vets", "vets/vetsList"})
    public String vetList() {
        return "vets/vetsList";
    }
}
