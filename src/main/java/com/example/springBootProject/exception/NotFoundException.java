package com.example.springBootProject.exception;

import com.example.springBootProject.response.ApiResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException {
private ApiResponse apiResponse;
private String message;

public NotFoundException(ApiResponse apiResponse) {
this.apiResponse = apiResponse;
}

public NotFoundException(String message) {
    super(message);
}

}
