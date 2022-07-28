package com.spring.petclinicweb.controllers;

import com.spring.petclinicdata.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners/index","/owners","/owners/index.html"})
    public String getOwners(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "Owner/index";
    }

    @RequestMapping("/owners/find")
    public String findOwners(){
        return "notimplemented";
    }
}
