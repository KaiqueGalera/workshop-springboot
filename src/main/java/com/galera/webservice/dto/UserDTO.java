package com.galera.webservice.dto;

import com.galera.webservice.domain.User;

public record UserDTO(Long id,
                      String name,
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
