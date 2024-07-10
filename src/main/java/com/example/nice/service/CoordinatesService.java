package com.example.nice.service;

import com.example.nice.entity.Coordinates;
import com.example.nice.exception.CoordinateNotFoundException;
import com.example.nice.repository.CoordinatesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.nice.mapper.CoordinatesMapper.mapToBlackList;

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
        Optional<Coordinates> firstCoordinatesOpt = coordinatesRepository.findByX(bar1);
        if(!firstCoordinatesOpt.isPresent()){
            throw new CoordinateNotFoundException("Coordinates", "X", bar1);
        }
        Coordinates firstCoordinates = mapToBlackList(firstCoordinatesOpt,new Coordinates());

        Optional<Coordinates> secondCoordinatesOpt = coordinatesRepository.findByX(bar2);
        if(!secondCoordinatesOpt.isPresent()){
            throw new CoordinateNotFoundException("Coordinates", "X", bar1);
        }
        Coordinates secondCoordinates = mapToBlackList(secondCoordinatesOpt,new Coordinates());
        int length = Integer.parseInt(bar2) - Integer.parseInt(bar1);
        int width = 0;
        if(Integer.parseInt(firstCoordinates.getY()) < Integer.parseInt(secondCoordinates.getY())){
            width = Integer.parseInt(firstCoordinates.getY());
        }
        else {
            width = Integer.parseInt(secondCoordinates.getY());
        }
        return length*width;
    }
}
