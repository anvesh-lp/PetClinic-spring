package com.Anvesh.petclinicspring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/owners"})
@Controller
public class OwnersController {

    @RequestMapping({"", "/owners"})
    public String ownerList() {
        return "owners/ownersList";
    }
}
