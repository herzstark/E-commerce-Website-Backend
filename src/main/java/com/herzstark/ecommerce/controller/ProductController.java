package com.herzstark.ecommerce.controller;

import com.herzstark.ecommerce.entities.product.Product;
import com.herzstark.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        Optional<Product> optionalProduct = productService.findByID(id);

        if(optionalProduct.isEmpty())
        { throw new RuntimeException();
        }
        return new ResponseEntity<Product>(optionalProduct.get(),HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id ,@RequestBody Product product){
        product.setId(id);

        return new ResponseEntity<>(productService.update(product),HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
