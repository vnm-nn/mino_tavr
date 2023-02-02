package com.mino_tavr.controller;

import com.mino_tavr.entity.Technique;
import com.mino_tavr.exception.NoTechniqueInDBException;
import com.mino_tavr.service.TechniqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TechniqueController {
    @Autowired
    private TechniqueService techniqService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @GetMapping("/technique")
    public List<Technique> showAllTechniqs() {
        return techniqService.getAllTechniqs();
    }

    @GetMapping("/technique/{id}")
    public Technique getTechniq(@PathVariable int id) {
        Technique technique = techniqService.getTechniq(id);
        if(technique == null) {
            throw new NoTechniqueInDBException("There is no Techniq with ID = " + id + " in DataBase");
        }
        return technique;
    }

    @PostMapping("/technique")
    public Technique addNewTechniq(@RequestBody Technique technique) {
        techniqService.saveTechniq(technique);
        return technique;
    }

    @PutMapping("/technique/{id}")
    public Technique updateTechniq(@RequestBody Technique technique) {
        techniqService.saveTechniq(technique);
        return technique;
    }

    @DeleteMapping("/technique/{id}")
    public String deleteTechniq(@PathVariable int id) {
        Technique technique = techniqService.getTechniq(id);
        if(technique == null) {
            throw new NoTechniqueInDBException("There is no Techniq with ID = " + id + " in DataBase");
        }
        techniqService.deleteTechniq(id);
        return "Techniq with ID = " + id + " was deleted";
    }
}
