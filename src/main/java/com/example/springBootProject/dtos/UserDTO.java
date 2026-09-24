package com.example.springBootProject.dtos;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class UserDTO {

    @NotBlank(message = "siz nimadir yozishiz kerak !!!")
    @Size(max = 20,message = "maximaldan oshib ketti")
    private String firstName;
    @NotBlank(message = "familyada nimadir yozilgan bulsin !!!")
    @Size(max = 30,message = "maximaldan oshib ketti")
    private String lastName;
    @Min(value = 15,message = "yosh kamida 16 bulsin")
    @PositiveOrZero
    private int age;
    @Email(message = "email @gmail.com formatida bulsin !!!")
    private String email;
    @Size(min = 6,message = "parol kamida 6 ta bulishi kerak")
    private String password;

}
