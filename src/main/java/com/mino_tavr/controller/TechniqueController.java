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
    private TechniqueService techniqueService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @GetMapping("/technique")
    public List<Technique> showAllTechniqs() {
        return techniqueService.getAllTechniqs();
    }

    @GetMapping("/technique/{id}")
    public Technique getTechnique(@PathVariable int id) {
        Technique technique = techniqueService.getTechniq(id);
        if(technique == null) {
            throw new NoTechniqueInDBException("There is no Technique with ID = " + id + " in DataBase");
        }
        return technique;
    }

    @PostMapping("/technique")
    public Technique addNewTechnique(@RequestBody Technique technique) {
        techniqueService.saveTechniq(technique);
        return technique;
    }

    @PutMapping("/technique/{id}")
    public Technique updateTechnique(@RequestBody Technique technique) {
        techniqueService.saveTechniq(technique);
        return technique;
    }

    @DeleteMapping("/technique/{id}")
    public String deleteTechnique(@PathVariable int id) {
        Technique technique = techniqueService.getTechniq(id);
        if(technique == null) {
            throw new NoTechniqueInDBException("There is no Technique with ID = " + id + " in DataBase");
        }
        techniqueService.deleteTechniq(id);
        return "Technique with ID = " + id + " was deleted";
    }
}
