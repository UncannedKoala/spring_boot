package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.Product;
import com.application.service.ProductService;

import jakarta.servlet.http.HttpServletResponse;

/*
 * Combination of [@Controller, @RequestBody]
 */
@RestController

/*
 * All the "/product" requests will be routed to this controller
 */
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	/*
	 * Due to @RequestMapping on the class will be invoked on "../product/find/{name}"
	 */
//	@GetMapping("/find/{name},{pgNo},{size}")										//can also be used just that it will be using (,) commas instead of the (/) forward slashes "/product/find/Chocolates,0,10"
	@GetMapping("/find/{name}/{pgNo}/{size}")
	public List<Product> findPerson(HttpServletResponse req,@PathVariable String name, @PathVariable int pgNo, @PathVariable int size) {
		if(name==null || name.trim().isEmpty()) {
			req.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		return productService.findProducts(name,pgNo,size);
	}
	
	@PostMapping("/add")
	public void addproduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	/* price */
	@GetMapping("/all/desc")
	public List<Product> allDesc() {
		return productService.getAllDesc();
	}
	
	@PutMapping("/delete/{name}")
	public String deleteByName(@PathVariable String name) {
		return "deleted "+productService.deleteByName(name)+" products";
	}
	
	@PutMapping("/delete/all/invalid")
	public String deleteAllInvalid() {
		return "deleted "+productService.deleteAllInvalid()+" products";
	}
	
	/* 
	 * Pagination API - The page starts from 0 
	 */
	@GetMapping("/page/{number}/{size}")
	public List<Product> getPage(@PathVariable int number, @PathVariable int size){
		return productService.page(number, size);
	}
	
	/* 
	 * SORTING with PAGINATION
	 */
	@GetMapping("/find/{name}/{pgNo}/{size}/{asc}")
	public List<Product> findProductOrderBySize(@PathVariable String name, @PathVariable int pgNo, @PathVariable int size, @PathVariable boolean asc){
		return productService.findProductsAndSortByPrice(name, pgNo, size, asc);
	}
	
}
