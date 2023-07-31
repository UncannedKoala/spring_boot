package com.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.Product;
import com.application.service.ProductService;

@RestController
@RequestMapping(path = "/product")					//all the mapping will be prefixed with the passed parameter
public class ProductController {
	@Autowired
	private ProductService service;

	
	/*
	 * Annotation(@RequestBody) on a Object parameter indicates that a method
	 * parameter should be bound to the body of the web request.The body of the
	 * request is passed through an HttpMessageConverter to resolve
	 * the method argument depending on the content type of the request. Optionally,
	 * automatic validation can be applied by annotating the argument with
	 * @Valid.
	 */
	 
	@PostMapping("/add")
	public void addProduct(@RequestBody Product product) {
		service.addProduct(product);
	}
	
	@PutMapping("/update")
	public void updateProduct(Product product) {
//		LOGIC
	}
	
	@DeleteMapping("/delete")
	public void deleteProduct(Product product) {
//		LOGIC
	}
	
	@GetMapping("/get")
	public Product getPerson(Product product) {
//		LOGIC
		return product;
	}
	
	@GetMapping("/getAll")
	public List<Product> getAllProducts(){
		List<Product> list = null;
//		LOGIC
		return list;
	}
}
