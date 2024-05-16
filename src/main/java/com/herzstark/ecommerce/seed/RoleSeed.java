package com.herzstark.ecommerce.seed;


import com.herzstark.ecommerce.entities.user.Role;
import com.herzstark.ecommerce.repositories.userRepo.components.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Component
public class RoleSeed {
    @Autowired
    private RoleRepository roleRepository;

    @EventListener
    @Transactional
    public void LoadRoles(ContextRefreshedEvent event) {

        List<String> roles = List.of(
                "ROLE_ADMIN",
                "ROLE_USER"
        );

        for (String role : roles) {
            if (roleRepository.findByRole(role) == null) {
                roleRepository.save(Objects.requireNonNull(createRole(role)));
            }
        }


    }

    private Role createRole(String role) {
        switch (role) {
            case "ROLE_ADMIN" -> {
                return createAdminRole();
            }
            case "ROLE_USER" -> {
                return createUserRole();
            }
            default -> {
                return null;
            }
        }
    }

    private Role createAdminRole() {
        return Role.builder()
                .role("ROLE_ADMIN")
                .banUser(true)
                .restrictSellUser(true)
                .modifyProductAll(true)
                .modifyProductSelf(true)
                .userModifyAll(true)
                .userModifySelf(true)
                .build();
    }

    private Role createUserRole() {
        return Role.builder()
                .role("ROLE_USER")
                .banUser(false)
                .restrictSellUser(false)
                .modifyProductAll(false)
                .modifyProductSelf(true)
                .userModifyAll(false)
                .userModifySelf(true)
                .build();
    }
}