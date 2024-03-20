package com.thespringboot.restdemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

import com.thespringboot.restdemo.exception.ApiException;
import com.thespringboot.restdemo.model.Product;
import com.thespringboot.restdemo.service.ProductService;

import io.swagger.annotations.Api;

/**
 * This class exposes the RESTful endpoints to provide product operations.
 * 
 * @author muhammadkhalid
 * @version 1.0
 * @since 19 March 2024
 *
 */

@RestController
@RequestMapping("/product-api/v1/")
@Api(value = "/product-api/v1/", description = "Product Catalogue Application APIs", produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8" )
public class ProductRestController {
	
	/* PRIVATE VARIABLES */
	
	private Logger logger = LoggerFactory.getLogger(ProductRestController.class);

	@Autowired
	private ProductService productService;
	
	
	/* PUBLIC METHODS */

	@GetMapping(path = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> ping() {
		return ResponseEntity.ok().body("Product api is up.");
	}

	@GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAllProduct() throws ApiException {
		logger.info("(getAllProduct) Getting all the products details.");
		List<Product> productList = productService.getAllProduct();
		if(CollectionUtils.isEmpty(productList)) {
			throw new ApiException(HttpStatus.NOT_FOUND, "PRODUCT_NOT_FOUND", "Product not found");
		}
		return ResponseEntity.ok().body(productList);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		return ResponseEntity.ok().body(productService.getProductById(id));
	}

	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return ResponseEntity.ok().body(this.productService.createProduct(product));
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product) {
		product.setId(id);
		return ResponseEntity.ok().body(this.productService.updateProduct(product));
	}

	@DeleteMapping("/products/{id}")
	public HttpStatus deleteProduct(@PathVariable long id) {
		this.productService.deleteProduct(id);
		return HttpStatus.OK;
	}
}