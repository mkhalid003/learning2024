package com.thespringboot.restdemo.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import com.thespringboot.restdemo.AbstractTest;
import com.thespringboot.restdemo.model.Product;
import com.thespringboot.restdemo.service.ProductService;

public class ProductControllerTest extends AbstractTest {


	@MockBean
	private ProductService service;

	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Test
	public void pingTest() throws Exception {

		mvc.perform(get("/product-api/v1/ping")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("Product api is up")));

	}


	@Test
	public void getAllProductTest1() throws Exception {

		Product product = new Product();
		product.setId(1);
		product.setName("watch1");
		product.setPrice(BigDecimal.valueOf(1000L));
		product.setDescription("Wrist watch1");
		List<Product> list = new ArrayList<>();
		list.add(product);

		when(service.getAllProduct()).thenReturn(list);

		MvcResult mvcResult = mvc.perform(get("/product-api/v1/products")).andDo(print())
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Product[] productlist = super.mapFromJson(content, Product[].class);
		assertTrue(productlist.length > 0);
	}

	@Test
	public void getAllProductNotFoundTest() throws Exception {

		MvcResult mvcResult = mvc.perform(get("/product-api/v1/products")).andDo(print())
				.andExpect(status().is4xxClientError()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(404, status);

	}

}
