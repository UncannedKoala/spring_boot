package com.application.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.application.model.Product;

@Repository
public class ProductRepository {
	@Autowired
	private JdbcTemplate template;
	
	public void addProduct(Product p) {
//		template.execute();
		System.out.println(p);
		System.out.println(
				template.update("INSERT INTO product VALUES (NULL,'" + p.getName() + "'," + p.getPrice() + ")")
				);
	}
}
