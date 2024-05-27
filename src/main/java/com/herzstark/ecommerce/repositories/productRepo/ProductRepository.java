package com.herzstark.ecommerce.repositories.productRepo;

import com.herzstark.ecommerce.entities.product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    Optional<Object> findByIdAndUserId(Long productId, Long id);
}
