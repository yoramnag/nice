package com.example.nice.rest;

import com.example.nice.entity.Coordinates;
import com.example.nice.service.CoordinatesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api" , produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class CoordinatesRestController {

    private CoordinatesService coordinatesService;

    @GetMapping("/getAllCoordinates")
    public ResponseEntity<List<Coordinates>> getAllTransactions(){
        List<Coordinates> coordinatesList = coordinatesService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(coordinatesList);
    }
}
