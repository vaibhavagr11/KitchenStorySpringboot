package com.User.User.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.User.User.Dao.PrdouctDao;
import com.User.User.Entity.Product;
//import com.User.User.Function.SignUpDto;
import com.User.User.Service.ProductService;





@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	PrdouctDao productDao;
	
	@PostMapping("/products")
    public ApiResponse addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
	
	@PostMapping("/addToCart")
	public ApiResponse addToCart(@RequestBody Product product) {
		return productService.addToCart(product);
	}
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return productDao.findAll();
	}
	
	
	

}
