package com.example.nice.service;

import com.example.nice.entity.Coordinates;
import com.example.nice.repository.CoordinatesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoordinatesService {

    private CoordinatesRepository coordinatesRepository;

    public List<Coordinates> findAll(){
        return coordinatesRepository.findAll();
    }
}
