package com.example.nice.repository;

import com.example.nice.entity.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoordinatesRepository extends JpaRepository<Coordinates, Integer> {

    Optional<Coordinates> findByX(String x);
    Optional<Coordinates> findByY(String y);
}
