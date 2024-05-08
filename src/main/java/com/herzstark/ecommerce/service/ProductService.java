package com.herzstark.ecommerce.service;


import com.herzstark.ecommerce.entities.Product;

import java.util.Optional;

public interface ProductService {

    Product create(Product product);

    Product update(Product product);

    void delete(Long id);

    Optional<Product> findByID(Long id);
}
