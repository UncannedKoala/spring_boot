package com.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.application.model.Product;
import com.application.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	public void addProduct(Product product) {
		Product returned = productRepo.save(product);
		System.out.println("returned product same as saved one?? -> "+(returned==product));
	}
	
	/* PAGINATION via Pageable */
	public List<Product> findProducts(String name, int pgNo, int size) {
		Pageable pageable = PageRequest.of(pgNo, size);
		List<Product> list = productRepo.findProductsByName(name,pageable);
		return list;
	}
	
	
	/* SORTING */
	public List<Product> getAllDesc() {
		return productRepo.findAll(Sort.by("price").descending());
	}
	
	public String deleteByName(String name) {
		return ""+productRepo.deleteProductByName(name);
	}
	
	/* Deleting all with null values */
	public String deleteAllInvalid() {
		return ""+productRepo.deleteProductsByNameIsNull();
	}
	
	/* PAGINATION */
	public List<Product> page(int pgNo, int size){
		Page<Product> page = productRepo.findAll(PageRequest.of(pgNo,size));
		return page.getContent();																//converts Page<T> -> List<T>
	}
	
	/* 
	 * PAGINATION with SORTING
	 * Both can be used at once, thus we put SORT as a param in Pageable and pass the Pageable
	 */
	public List<Product> findProductsAndSortByPrice(String name, int pgNo, int size, boolean isPriceAsc) {
		Sort s = Sort.by("price");
		if(isPriceAsc) {
			s = s.ascending();
		}else {
			s = s.descending();
		}
		Pageable pageable = PageRequest.of(pgNo, size, s);
		return productRepo.findProductsByName(name, pageable);
	}
	
}







