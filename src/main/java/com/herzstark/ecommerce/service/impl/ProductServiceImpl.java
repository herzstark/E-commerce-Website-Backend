package com.herzstark.ecommerce.service.impl;

import com.herzstark.ecommerce.entities.product.Product;
import com.herzstark.ecommerce.repositories.productRepo.ProductRepository;
import com.herzstark.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findByID(Long id) {
        return productRepository.findById(id);
    }
}
