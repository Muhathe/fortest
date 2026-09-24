package com.example.springBootProject.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentDTO {
    private int id;
    private String name;
    private int age;
}
