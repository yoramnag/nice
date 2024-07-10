package com.example.nice.mapper;

import com.example.nice.entity.Coordinates;

import java.util.Optional;

public class CoordinatesMapper {

    public static Coordinates mapToBlackList(Optional<Coordinates> coordinateOpt , Coordinates coordinate){
        coordinate.setX(coordinateOpt.stream().toList().get(0).getX());
        coordinate.setY(coordinateOpt.stream().toList().get(0).getY());
        return coordinate;
    }
}
