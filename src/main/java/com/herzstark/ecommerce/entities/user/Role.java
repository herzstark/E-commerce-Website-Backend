package com.herzstark.ecommerce.entities.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"role"})})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    private String role;

    private boolean banUser;

    private boolean restrictSellUser;

    private boolean modifyProductAll;

    private boolean modifyProductSelf;

    private boolean userModifySelf;

    private boolean userModifyAll;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> user;



}
