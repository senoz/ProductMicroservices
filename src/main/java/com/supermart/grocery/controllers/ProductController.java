package com.supermart.grocery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supermart.grocery.dtos.Product;
import com.supermart.grocery.serviceImpl.ProductServiceImpl;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductServiceImpl prodService;
	
	@RequestMapping(value = "/get-products", method = RequestMethod.GET)
	public ResponseEntity<?> getProducts() throws Exception {
		String prod = null;
		try {
			prod = prodService.getProducts();
		} catch (Exception ex) {
			throw new Exception();
		}
		return new ResponseEntity<>(prod, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get-products/category/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getproductsByCategory(@PathVariable("id") long id) throws Exception {
		String prod = null;
		try {
			prod = prodService.getProductsByCategoryId(id);
		} catch (Exception ex) {
			throw new Exception();
		}
		return new ResponseEntity<>(prod, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get-product/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getproductsById(@PathVariable("id") long id) throws Exception {
		String prod = null;
		try {
			prod = prodService.getProductById(id);
		} catch (Exception ex) {
			throw new Exception();
		}
		return new ResponseEntity<>(prod, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> addProduct(@RequestBody Product data) throws Exception {
		String categories = "Added new product";
		try {
			prodService.addProduct(data);
		} catch (Exception ex) {
			throw new Exception();
		}
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) throws Exception {
		String categories = "Removed product";
		try {
			prodService.removeProduct(id);
		} catch (Exception ex) {
			throw new Exception();
		}
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<?> updateCategroy(@RequestBody Product data) throws Exception {
		String categories = "Updated product";
		try {
			prodService.modifyProduct(data);
		} catch (Exception ex) {
			throw new Exception();
		}
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
}