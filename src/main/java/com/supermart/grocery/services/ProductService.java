package com.supermart.grocery.services;

import com.supermart.grocery.dtos.Product;

public interface ProductService {

	public String getProducts();
	public String getProductsByCategoryId(long id);
	public String getProductById(long id);
	public void addProduct(Product prod);
	public void modifyProduct(Product prod);
	public void removeProduct(long id);
}
