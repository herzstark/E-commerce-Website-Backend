package com.herzstark.ecommerce.repositories.userRepo.components;

import com.herzstark.ecommerce.entities.user.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
    Role findByRole(String role);
}
