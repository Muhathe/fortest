package com.example.springBootProject.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String model;
    private String color;
    private int year;
    private double price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
