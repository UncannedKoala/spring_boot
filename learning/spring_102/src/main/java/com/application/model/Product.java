package com.application.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Product")
public class Product{
	
	/*
	 * MySQL tracks the used ID when using the autogeneration strategies by storing
	 * the last used ID in a special table called the **AUTO_INCREMENT** table. This
	 * table is a hidden table, which means that it is not visible to users. The
	 * AUTO_INCREMENT table stores the last used ID for each table that uses
	 * autogeneration.
	 * 
	 * When a new row is inserted into a table that uses autogeneration, MySQL first
	 * checks the AUTO_INCREMENT table to see what the last used ID is. If the
	 * AUTO_INCREMENT table is empty, then MySQL will start with 1 as the next ID.
	 * If the AUTO_INCREMENT table is not empty, then MySQL will use the next ID in
	 * the table.
	 * 
	 * The AUTO_INCREMENT table is updated whenever a new row is inserted into a
	 * table that uses autogeneration. This ensures that the next ID is always
	 * available.
	 * 
	 * Here are some of the autogeneration strategies that MySQL supports:
	 * 
	 * **AUTO_INCREMENT:** This is the default autogeneration strategy. It uses the
	 * AUTO_INCREMENT table to track the used ID. 

	 * **SEQUENCE:** This strategy uses a
	 * sequence to track the used ID. A sequence is a special type of table that is
	 * used to generate sequential numbers. 
	 * 
	 * **IDENTITY:** This strategy uses the
	 * database server to track the used ID. The database server will assign the
	 * next ID to the new row.
	 * 
	 * The best autogeneration strategy to use depends on the specific requirements
	 * of your application. If you need to ensure that the next ID is always
	 * available, then you should use the AUTO_INCREMENT strategy. If you need to
	 * have more control over the ID generation, then you should use the SEQUENCE or
	 * IDENTITY strategy.
	 */
	/*
	 * Having setters and getters for ID will return id when an object is returned
	 * to user
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private double price;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	/*
	 * This is a copy constructor but it will not copy the id as it may cause the
	 * problem for hibernate during dirty-checking etc
	 */
	public Product(Product product) {
		this.name = product.getName();
		this.price = product.getPrice();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
	
}
