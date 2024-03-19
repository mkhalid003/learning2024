package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.ApiException;
import com.example.demo.model.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
		/*
		 * if (product == null) { throw new ProductNotFoundException(productId); }
		 */
        return ResponseEntity.ok(product);
    }
    
    
    @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> test() throws ApiException{
		String error = "Application Instance ID: %s not found" ;
		throw new ApiException(HttpStatus.BAD_REQUEST, "APP_INSTANCE_NOT_FOUND_EC",	error);
	}
    
    
	/*
	 * @GetMapping(path = "/testP", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<ApiResponse> testP(){
	 * 
	 * ApiResponse error = new ApiResponse(); error.setHttpCode(500);
	 * //error.setHttpTitle(ex.getHttpStatus()); error.setResponseCode("500");
	 * error.setMessage("App Testing");
	 * 
	 * ResponseEntity<ApiResponse> responseEntity = new
	 * ResponseEntity<ApiResponse>(error, HttpStatus .ACCEPTED); return
	 * responseEntity; }
	 * 
	 * @GetMapping(path = "/testN", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<ApiResponse> testN() throws ApiException{
	 * 
	 * ApiResponse error = new ApiResponse(); error.setHttpCode(500);
	 * //error.setHttpTitle(ex.getHttpStatus()); error.setResponseCode("500");
	 * error.setMessage("App Testing");
	 * 
	 * if (error.getHttpCode() == 500) { String error1 = String.
	 * format("Application Instance ID: %s association with product %s not found",
	 * "test", ""); throw new ApiException(HttpStatus.BAD_REQUEST,
	 * Constants.APP_INSTANCE_NOT_FOUND_EC, error1); }
	 * 
	 * ResponseEntity<ApiResponse> responseEntity = new
	 * ResponseEntity<ApiResponse>(error, HttpStatus .ACCEPTED); return
	 * responseEntity; }
	 */
}