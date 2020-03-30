package com.supermart.grocery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supermart.grocery.dtos.Category;
import com.supermart.grocery.serviceImpl.CategoryServiceImpl;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryServiceImpl categoryServiceImpl;
	
	
	@RequestMapping(value = "/get-categories", method = RequestMethod.GET)
	public ResponseEntity<?> getAllCategories() throws Exception {
		String categories = null;
		try {
			categories = categoryServiceImpl.getCategories();
		} catch (Exception ex) {
			throw new Exception();
		}
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> addCategroy(@RequestBody Category data) throws Exception {
		String categories = "Added new category";
		try {
			categoryServiceImpl.addCategroy(data);
		} catch (Exception ex) {
			throw new Exception();
		}
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity<?> deleteCategroy(@PathVariable("id") long id) throws Exception {
		String categories = "Removed category";
		try {
			categoryServiceImpl.removeCategroy(id);
		} catch (Exception ex) {
			throw new Exception();
		}
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<?> updateCategroy(@RequestBody Category data) throws Exception {
		String categories = "Updated category";
		try {
			categoryServiceImpl.modifyCategroy(data);
		} catch (Exception ex) {
			throw new Exception();
		}
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
}
