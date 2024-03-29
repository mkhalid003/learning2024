package com.thespringboot.restdemo.service.impl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thespringboot.restdemo.exception.ResourceNotFoundException;
import com.thespringboot.restdemo.model.Product;
import com.thespringboot.restdemo.repository.ProductRepository;
import com.thespringboot.restdemo.service.ProductService;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional < Product > productDb = this.productRepository.findById(product.getId());

        if (productDb.isPresent()) {
            Product productUpdate = productDb.get();
            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            productRepository.save(productUpdate);
            return productUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + product.getId());
        }
    }

    @Override
    public List < Product > getAllProduct() {
    	
    	Product product = new Product();
    	product.setId(1);
    	product.setName("watch");
    	product.setPrice(BigDecimal.valueOf(1000L));
    	product.setDescription("Wrist watch");
    	List <Product> list = new ArrayList<>();
    	list.add(product);
    	return list;
    	
        //return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {

        Optional < Product > productDb = this.productRepository.findById(productId);

        if (productDb.isPresent()) {
            return productDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }
    }

    @Override
    public void deleteProduct(long productId) {
        Optional < Product > productDb = this.productRepository.findById(productId);

        if (productDb.isPresent()) {
            this.productRepository.delete(productDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }

    }
}