package com.application.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.model.Product;

import jakarta.transaction.Transactional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

//	@Query("SELECT p FROM PRODUCT p WHERE p.name=:<varName>")
	public List<Product> findProductsByName(String name, Pageable p);
	
	public int deleteProductByName(String name);
	
	@Transactional(Transactional.TxType.REQUIRED)
	public int deleteProductsByNameIsNull();
}
