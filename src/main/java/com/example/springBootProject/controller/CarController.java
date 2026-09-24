package com.example.springBootProject.controller;

import com.example.springBootProject.dtos.CarDTO;
import com.example.springBootProject.response.ApiResponse;
import com.example.springBootProject.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> createCar(@RequestBody CarDTO car) {
        ApiResponse apiResponse = carService.saveCar(car);
        return  ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/get-all")
    public ResponseEntity<ApiResponse> getAllCars() {
        ApiResponse allCars = carService.getAllCars();
        return  ResponseEntity.ok(allCars);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ApiResponse> getCarById(@PathVariable("id") int id) {
        ApiResponse carById = carService.getCarById(id);
        return  ResponseEntity.ok(carById);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateCarById(@PathVariable("id") int id, @RequestBody CarDTO car) {
        ApiResponse apiResponse = carService.updateCar(id, car);
        return  ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCarById(@PathVariable("id") int id) {
        ApiResponse apiResponse = carService.deleteCar(id);
        return  ResponseEntity.ok(apiResponse);
    }


}
