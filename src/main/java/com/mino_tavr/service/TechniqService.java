package com.mino_tavr.service;


import com.mino_tavr.entity.Techniq;

import java.util.List;

public interface TechniqService {
    List<Techniq> getAllTechniqs();

    void saveTechniq(Techniq techniq);

    Techniq getTechniq(int id);

    void deleteTechniq(int id);
}
