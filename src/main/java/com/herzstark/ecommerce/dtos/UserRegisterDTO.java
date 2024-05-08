package com.herzstark.ecommerce.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisterDTO {

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @Pattern(
            regexp = "^[a-zA-Z0-9@$!%?&]{8,30}$",
            message = "Password must be between 8 and 30 characters long " +
                    "and only contain letters, numbers, and special characters"
    )
    private String password;
}
