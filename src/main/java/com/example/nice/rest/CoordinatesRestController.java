package com.example.nice.rest;

import com.example.nice.constants.CoordinatesConstants;
import com.example.nice.dto.ResponseDto;
import com.example.nice.entity.Coordinates;
import com.example.nice.service.CoordinatesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/calculateSquare")
    public int calculateSquare(
            @RequestParam @Pattern(regexp = "^[0-9]*$", message = "bar1 must be only digits") String bar1,
            @RequestParam @Pattern(regexp = "^[0-9]*$", message = "bar2 must be only digits") String bar2
    ){
        int result = coordinatesService.calculateSquare(bar1,bar2);
        return result;
    }

    @PostMapping("/createCoordinate")
    public ResponseEntity<ResponseDto> createBlackListCard(@Valid @RequestBody Coordinates coordinate){
        coordinatesService.saveCoordinate(coordinate);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CoordinatesConstants.STATUS_201,CoordinatesConstants.MESSAGE_201));
    }

}
