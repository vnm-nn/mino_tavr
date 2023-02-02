package com.mino_tavr.service;

import com.mino_tavr.dao.TechniqueRepository;
import com.mino_tavr.entity.Technique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TechniqueServiceImpl implements TechniqueService {
    @Autowired
    private TechniqueRepository techniqueRepository;

    @Override
    public List<Technique> getAllTechniqs() {
        return techniqueRepository.findAll();
    }

    @Override
    public void saveTechniq(Technique technique) {
        techniqueRepository.save(technique);
    }

    @Override
    public Technique getTechniq(int id) {
        Optional<Technique> techniq = techniqueRepository.findById(id);
        return techniq.orElse(null);
    }

    @Override
    public void deleteTechniq(int id) {
        techniqueRepository.deleteById(id);
    }
}
