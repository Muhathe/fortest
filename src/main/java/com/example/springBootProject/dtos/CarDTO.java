package com.example.springBootProject.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarDTO {

    private String model;
    private String color;
    private int year;
    private double price;
    private Integer userId;

}
