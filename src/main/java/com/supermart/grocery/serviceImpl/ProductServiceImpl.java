package com.supermart.grocery.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.supermart.grocery.dtos.Product;
import com.supermart.grocery.repositories.ProductRepo;
import com.supermart.grocery.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo prodRepo;

	Gson gson = new Gson();

	@Override
	public String getProducts() {
		List<Product> prod = prodRepo.findAll();
		return gson.toJson(prod);
	}

	@Override
	public String getProductsByCategoryId(long id) {
		List<Product> prod = prodRepo.findByCatId(id);
		return gson.toJson(prod);
	}

	@Override
	public String getProductById(long id) {
		Optional<Product> prod = prodRepo.findById(id);
		return gson.toJson(prod);
	}

	@Override
	public void addProduct(Product prod) {
		prodRepo.save(prod);
	}

	@Override
	public void modifyProduct(Product prod) {

		Optional<Product> opProd = prodRepo.findById(prod.getId());
		if (opProd.isPresent()) {
			Product product = opProd.get();
			product.setProductName(prod.getProductName());
			product.setCatId(prod.getCatId());
			product.setProductDescription(prod.getProductDescription());
			product.setProductPrice(prod.getProductPrice());
			product.setProductQty(prod.getProductQty());
			prodRepo.save(product);
		}
	}

	@Override
	public void removeProduct(long id) {
		Optional<Product> opProd = prodRepo.findById(id);
		if (opProd.isPresent()) {
			Product product = opProd.get();
			prodRepo.delete(product);
		}
	}
}
