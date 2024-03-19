package com.thespringboot.restdemo.model;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @CreationTimestamp
    private Date createdAt;

    @CreationTimestamp
    private Date updatedAt;

}