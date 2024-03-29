package com.thespringboot.restdemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thespringboot.restdemo.controller.ProductRestController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	ProductRestController productController;
	
	@Test
	void contextLoads() {
		
		assertThat(productController).isNotNull();
	}
}
