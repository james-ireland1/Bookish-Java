package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Technology;
import org.softwire.training.bookish.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nancy-test")
public class NancyTestController {

    private final TechnologyService technologyService;

    @Autowired
    public NancyTestController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @RequestMapping("")
    List<Technology> nancyTest() {
        return technologyService.getAllTechnologies();
    }
}