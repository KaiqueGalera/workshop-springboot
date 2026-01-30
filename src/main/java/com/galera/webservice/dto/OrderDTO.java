package com.galera.webservice.dto;

import com.galera.webservice.entities.Order;

import java.time.Instant;

public record OrderDTO(Long id, Instant moment) {
    public OrderDTO(Order entity) {
        this(entity.getId(),
                entity.getMoment());
    }
}
