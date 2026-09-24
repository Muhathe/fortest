package com.example.springBootProject.controller;

import com.example.springBootProject.entity.Product;
import com.example.springBootProject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping("/save")
    public ResponseEntity<String> addProduct( @RequestBody Product product) {
         productService.save(product);
        return ResponseEntity.ok("qushildi");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getByIdProduct(@PathVariable int id) {
        return productService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestBody Product product) {
        productService.update(id, product);
        return ResponseEntity.ok("yangilandi !!!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        productService.delete(id);
        return ResponseEntity.ok("uchirildi !!!");
    }





}
