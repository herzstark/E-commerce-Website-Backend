package com.herzstark.ecommerce.repositories.productRepo;

import com.herzstark.ecommerce.entities.product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

}
