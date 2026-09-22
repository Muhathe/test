package com.example.springBoot2.service;

import com.example.springBoot2.dtos.ProductDTO;
import com.example.springBoot2.entity.Product;
import com.example.springBoot2.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public String saveProduct(ProductDTO productDTO) {
        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .build();
        productRepository.save(product);
        return "Product saved";
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getById(int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return product;
    }

    public String updateProduct(int id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        productRepository.save(product);
        return "Product updated";
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product deleted";
    }


}
