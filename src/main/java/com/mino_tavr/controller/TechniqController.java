package com.mino_tavr.controller;

import com.mino_tavr.entity.Techniq;
import com.mino_tavr.exception.NoTechniqInDBException;
import com.mino_tavr.service.TechniqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TechniqController {
    @Autowired
    private TechniqService techniqService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @GetMapping("/technique")
    public List<Techniq> showAllTechniqs() {
        return techniqService.getAllTechniqs();
    }

    @GetMapping("/technique/{id}")
    public Techniq getTechniq(@PathVariable int id) {
        Techniq techniq = techniqService.getTechniq(id);
        if(techniq == null) {
            throw new NoTechniqInDBException("There is no Techniq with ID = " + id + " in DataBase");
        }
        return techniq;
    }

    @PostMapping("/technique")
    public Techniq addNewTechniq(@RequestBody Techniq techniq) {
        techniqService.saveTechniq(techniq);
        return techniq;
    }

    @PutMapping("/technique/{id}")
    public Techniq updateTechniq(@RequestBody Techniq techniq) {
        techniqService.saveTechniq(techniq);
        return techniq;
    }

    @DeleteMapping("/technique/{id}")
    public String deleteTechniq(@PathVariable int id) {
        Techniq techniq = techniqService.getTechniq(id);
        if(techniq == null) {
            throw new NoTechniqInDBException("There is no Techniq with ID = " + id + " in DataBase");
        }
        techniqService.deleteTechniq(id);
        return "Techniq with ID = " + id + " was deleted";
    }
}
