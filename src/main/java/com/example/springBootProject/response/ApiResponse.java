package com.example.springBootProject.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {
    private String message;
    private Boolean success;
    private HttpStatus statusCode;
    private Object data;

}
