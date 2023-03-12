package com.mino_tavr.repository;

import com.mino_tavr.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    List<PreviewModels> findByDeviceType(int deviceType);
}
