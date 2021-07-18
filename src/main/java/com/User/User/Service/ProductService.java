package com.User.User.Service;

import com.User.User.Controller.ApiResponse;
import com.User.User.Entity.Product;

import antlr.collections.List;

public interface ProductService {

	ApiResponse addProduct(Product product);

	ApiResponse addToCart(Product product);

	

}
