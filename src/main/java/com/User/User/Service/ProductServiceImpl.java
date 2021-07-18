package com.User.User.Service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.User.User.Controller.ApiResponse;
import com.User.User.Dao.PrdouctDao;
import com.User.User.Entity.Product;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	PrdouctDao productDao;

	@Override
	public ApiResponse addProduct(Product product) {
		validateProduct(product);
		Product prod =new Product();
		BeanUtils.copyProperties(product, prod);
		productDao.save(prod);
		return new ApiResponse(200, "success", prod);
	}

	private void validateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ApiResponse addToCart(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
