package com.galera.webservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
}
