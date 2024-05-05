package com.herzstark.ecommerce.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    private String name;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    private String description;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false, updatable = false)
    private User user;

}
