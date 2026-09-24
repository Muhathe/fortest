package com.example.springBootProject.service;

import com.example.springBootProject.dtos.UserDTO;
import com.example.springBootProject.entity.User;
import com.example.springBootProject.repository.UserRepository;
import com.example.springBootProject.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ApiResponse createUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAge(userDTO.getAge());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        userRepository.save(user);

        return new ApiResponse("user saqlandi",true, HttpStatus.OK,null);
    }


}
