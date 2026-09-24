package com.example.springBootProject.service;

import com.example.springBootProject.dtos.CarDTO;
import com.example.springBootProject.entity.Car;
import com.example.springBootProject.entity.User;
import com.example.springBootProject.exception.NotFoundException;
import com.example.springBootProject.repository.CarRepository;
import com.example.springBootProject.repository.UserRepository;
import com.example.springBootProject.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final UserRepository userRepository;


    public ApiResponse saveCar(CarDTO carDTO) {

        User user = userRepository.findById(carDTO.getUserId()).orElseThrow(() -> new RuntimeException("User Not Found"));

        Car car = Car.builder()
                .model(carDTO.getModel())
                .color(carDTO.getColor())
                .year(carDTO.getYear())
                .price(carDTO.getPrice())
                .user(user)
                .build();
        carRepository.save(car);
        return new ApiResponse("saved",true, HttpStatus.OK,null);
    }


    public ApiResponse getAllCars() {
        List<Car> cars = carRepository.findAll();
        return new ApiResponse("getAllCars",true, HttpStatus.OK,cars);
    }


    public ApiResponse getCarById(int id){
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException(
                new ApiResponse("Car not found", false, HttpStatus.NOT_FOUND, null)));
        return new ApiResponse("success !!!",true, HttpStatus.OK,car);
    }

    public ApiResponse updateCar(int id,CarDTO carDTO) {
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException(
                new ApiResponse("Car not found", false, HttpStatus.NOT_FOUND, null)));
        User user = userRepository.findById(carDTO.getUserId()).orElseThrow(() -> new NotFoundException(
                new ApiResponse("User Not Found", false, HttpStatus.NOT_FOUND, null)));
        car.setModel(carDTO.getModel());
        car.setColor(carDTO.getColor());
        car.setYear(carDTO.getYear());
        car.setPrice(carDTO.getPrice());
        car.setUser(user);
        return new ApiResponse("updated !!!",true, HttpStatus.OK,null);
    }


    public ApiResponse deleteCar(int id) {
        carRepository.deleteById(id);
        return new ApiResponse("deleted !!!",true, HttpStatus.OK,null);
    }





}
