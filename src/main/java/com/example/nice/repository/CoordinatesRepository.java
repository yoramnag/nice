package com.example.nice.repository;

import com.example.nice.entity.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinatesRepository extends JpaRepository<Coordinates, Integer> {
}
