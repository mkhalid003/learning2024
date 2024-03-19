package com.thespringboot.restdemo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.thespringboot.restdemo.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}