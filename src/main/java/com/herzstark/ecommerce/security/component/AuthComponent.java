package com.herzstark.ecommerce.security.component;

import com.herzstark.ecommerce.entities.user.Role;
import com.herzstark.ecommerce.repositories.productRepo.ProductRepository;
import com.herzstark.ecommerce.repositories.userRepo.components.RoleRepository;
import com.herzstark.ecommerce.security.user.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;

@Component
public class AuthComponent {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ProductRepository productRepository;

    private UserDetailsImpl getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetailsImpl) authentication.getPrincipal();
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthenticatedUser().getAuthorities();
    }

    public boolean hasPermission(String permissionName) {
        Collection<? extends GrantedAuthority> authorities = getAuthorities();
        return authorities.stream()
                .map(auth -> roleRepository.findByRole(auth.getAuthority()))
                .anyMatch(role -> hasPermission(role, permissionName));
    }

    private boolean hasPermission(Role role, String permissionName) {
        return switch (permissionName) {
            case "EditAllProducts" -> role.isModifyProductAll();
            case "EditSelfProducts" -> role.isModifyProductSelf();
            case "EditAllUsers" -> role.isUserModifyAll();
            case "EditSelfUser" -> role.isUserModifySelf();
            case "RestrictUserSell" -> role.isRestrictSellUser();
            default -> false;
        };
    }

    public boolean hasPermissionForEditProducts(Long productId) {
        UserDetailsImpl user = getAuthenticatedUser();
        if (hasPermission("EditAllProducts")) return true;
        return hasPermission("EditSelfProducts") &&
                productRepository.findByIdAndUserId(productId, user.getId()).isPresent();
    }

    public boolean hasPermissionForEditUsers(Long userId) {
        UserDetailsImpl user = getAuthenticatedUser();
        if(hasPermission("EditAllUsers")) return true;
        return hasPermission("EditSelfUser") &&
                Objects.equals(user.getId(), userId);
    }

    public boolean hasPermissionForCreateProduct() {
        return hasPermission("EditAllProducts") || hasPermission("EditSelfProducts");
    }

    public boolean restrictSellForUser() {
        return hasPermission("RestrictUserSell");
    }
}
