package com.example.springBootProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//localhost:8080/test/data
//localhost:8080/test/welcome?name=Behruz

@RestController
@RequestMapping("/test")
public class SpringController {

    @GetMapping("/data")
    public String text(){
        return "Bu birinchi rest project";
    }

    @GetMapping("/welcome")
    public String welcomeName(@RequestParam String name){
        return "Welcome -" + name;
    }

    @GetMapping("/qushish")
    public int qushishName(@RequestParam int a,@RequestParam int b){
        return a+b;
    }


}
