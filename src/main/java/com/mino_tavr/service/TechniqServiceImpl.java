package com.mino_tavr.service;

import com.mino_tavr.dao.TechniqRepository;
import com.mino_tavr.entity.Techniq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TechniqServiceImpl implements TechniqService {
    @Autowired
    private TechniqRepository techniqRepository;

    @Override
    public List<Techniq> getAllTechniqs() {
        return techniqRepository.findAll();
    }

    @Override
    public void saveTechniq(Techniq techniq) {
        techniqRepository.save(techniq);
    }

    @Override
    public Techniq getTechniq(int id) {
        Optional<Techniq> techniq = techniqRepository.findById(id);
        return techniq.orElse(null);
    }

    @Override
    public void deleteTechniq(int id) {
        techniqRepository.deleteById(id);
    }
}
