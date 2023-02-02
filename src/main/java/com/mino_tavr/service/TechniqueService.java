package com.mino_tavr.service;


import com.mino_tavr.entity.Technique;

import java.util.List;

public interface TechniqueService {
    List<Technique> getAllTechniqs();

    void saveTechniq(Technique technique);

    Technique getTechniq(int id);

    void deleteTechniq(int id);
}
