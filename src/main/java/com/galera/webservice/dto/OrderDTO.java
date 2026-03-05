package com.galera.webservice.dto;

import com.galera.webservice.domain.Order;

import java.time.Instant;
import java.util.List;

public record OrderDTO(Long id, Instant moment, String OrderStatus, UserDTO client, List<OrderItemPDTO> items, Double total) {
    public OrderDTO(Order entity) {
        this(entity.getId(),
                entity.getMoment(),
                entity.getOrderStatus().name(),
                new UserDTO(entity.getClient()),
                entity.getItems().stream()
                        .map(OrderItemPDTO::new).toList(),
                entity.getTotal());
    }
}
