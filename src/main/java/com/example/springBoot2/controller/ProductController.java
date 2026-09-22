package com.example.springBoot2.controller;

import com.example.springBoot2.dtos.ProductDTO;
import com.example.springBoot2.entity.Product;
import com.example.springBoot2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public String create(@RequestBody ProductDTO productDTO) {
       return productService.saveProduct(productDTO);
    }

    @GetMapping("/get-all")
    public List<Product> getProducts() {
       return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable int id) {
       return productService.getById(id);
    }

    @PutMapping("{id}")
    public String updateProduct(@PathVariable int id,@RequestBody ProductDTO productDTO) {
       return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

}
