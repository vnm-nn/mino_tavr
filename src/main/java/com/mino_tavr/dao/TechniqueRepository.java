package com.mino_tavr.dao;


import com.mino_tavr.entity.Technique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechniqueRepository extends JpaRepository <Technique, Integer> {

}
