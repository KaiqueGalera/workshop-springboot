package com.galera.webservice.dto;

import com.galera.webservice.entities.User;

import java.util.List;

public record UserDTO(Long id,
                      String name,
                      String email,
                      String phone,
                      List<OrderDTO> orders)
{
    public UserDTO(User entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getOrders()
                        .stream()
                        .map(OrderDTO::new)
                        .toList()
        );
    }
}
