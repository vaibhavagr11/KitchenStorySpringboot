package com.User.User.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.User.User.Entity.Product;


public interface PrdouctDao extends JpaRepository<Product, Integer> {
	
	Product findByProductName(String productName);

    Product findByProductBrand(String productBrand);

}
