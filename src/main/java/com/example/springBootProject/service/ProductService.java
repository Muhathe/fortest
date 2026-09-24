package com.example.springBootProject.service;

import com.example.springBootProject.entity.Product;
import com.example.springBootProject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void save(Product product) {
        Product product1 = new Product();
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setSon(product.getSon());
        productRepository.save(product1);
        System.out.println("Product saved");
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Optional<Product> getById(int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return Optional.of(product);
    }

    public void update(int id,Product newProduct) {
        Product findProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        findProduct.setName(newProduct.getName());
        findProduct.setPrice(newProduct.getPrice());
        findProduct.setDescription(newProduct.getDescription());
        findProduct.setSon(newProduct.getSon());
        productRepository.save(findProduct);
        System.out.println("Product updated !!!");
    }

    public void delete(int id) {
        productRepository.deleteById(id);
        System.out.println("Product deleted !!!");
    }

}
