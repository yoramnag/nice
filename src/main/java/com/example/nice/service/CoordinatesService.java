package com.example.nice.service;

import com.example.nice.entity.Coordinates;
import com.example.nice.repository.CoordinatesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CoordinatesService {

    private CoordinatesRepository coordinatesRepository;

    public List<Coordinates> findAll(){
        return coordinatesRepository.findAll();
    }

    public void saveCoordinate(Coordinates coordinate){
        coordinatesRepository.save(coordinate);
    }

    public int calculateSquare(String bar1,String bar2){
        Optional<Coordinates> firstCoordinates = coordinatesRepository.findByX(bar1);
        Optional<Coordinates> secondCoordinates = coordinatesRepository.findByX(bar2);
        return 0;
    }
}
