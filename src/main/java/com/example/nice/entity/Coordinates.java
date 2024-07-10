package com.example.nice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Coordinates {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="x")
    @NotEmpty(message = "X Coordinate can NOT be null or empty")
    @Min(value = 0 , message = "X need to be greater then 0")
    private String x;

    @Column(name="y")
    @NotEmpty(message = "Y Coordinate can NOT be null or empty")
    private String y;

}
