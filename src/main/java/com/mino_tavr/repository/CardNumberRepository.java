package com.mino_tavr.repository;

import com.mino_tavr.entity.CardNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardNumberRepository extends JpaRepository<CardNumber, Integer> {
}
