package com.galera.webservice.dto;

import com.galera.webservice.entities.Order;
import com.galera.webservice.entities.OrderItem;

import java.time.Instant;
import java.util.List;

public record OrderDTO(Long id, Instant moment, String OrderStatus, UserDTO client, List<OrderItemPDTO> items) {
    public OrderDTO(Order entity) {
        this(entity.getId(),
                entity.getMoment(),
                entity.getOrderStatus().name(),
                new UserDTO(entity.getClient()),
                entity.getItems().stream()
                        .map(OrderItemPDTO::new).toList());
    }
}
