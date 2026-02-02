package com.galera.webservice.dto;

import com.galera.webservice.entities.Order;
import com.galera.webservice.entities.OrderItem;

import java.time.Instant;
import java.util.List;

public record OrderDTO(Long id, Instant moment, String OrderStatus , List<ProductDTO> items) {
    public OrderDTO(Order entity) {
        this(entity.getId(),
                entity.getMoment(),
                entity.getOrderStatus().name(),
                entity.getItems().stream()
                        .map(OrderItem::getProduct)
                        .map(ProductDTO::new).toList()
        );
    }
}
