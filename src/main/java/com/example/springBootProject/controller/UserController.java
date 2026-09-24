package com.example.springBootProject.controller;

import com.example.springBootProject.dtos.UserDTO;
import com.example.springBootProject.response.ApiResponse;
import com.example.springBootProject.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> save(@Valid @RequestBody UserDTO userDTO) {
        ApiResponse user = userService.createUser(userDTO);
        return ResponseEntity.ok(user);
    }


}
