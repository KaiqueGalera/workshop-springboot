package com.galera.webservice.dto;

import com.galera.webservice.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(Long id,
                      @NotBlank(message = "name is required")
                      String name,
                      @Email(message = "invalid email")
                      String email,
                      String phone,
                      String password)
{
    public UserDTO(User entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getPassword()

        );
    }
}
