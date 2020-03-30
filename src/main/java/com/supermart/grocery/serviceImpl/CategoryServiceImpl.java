package com.supermart.grocery.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.supermart.grocery.dtos.Category;
import com.supermart.grocery.repositories.CategoryRepo;
import com.supermart.grocery.services.CategoryServices;

@Service
public class CategoryServiceImpl implements CategoryServices {

	@Autowired
	CategoryRepo categoryRepo;

	Gson gson = new Gson();
	
	@Override
	public String getCategories() {
		List<Category> prod = categoryRepo.findAll();
		return gson.toJson(prod);
	}
	
	@Override
	public void addCategroy(Category category) {
		categoryRepo.save(category);
	}
	
	@Override
	public void modifyCategroy(Category cat) {
		Optional<Category> opCategory = categoryRepo.findById(cat.getId());
		if (opCategory.isPresent()){
		    Category category = opCategory.get();
		    category.setName(cat.getName());
		    categoryRepo.save(category);
		}
	}
	
	@Override
	public void removeCategroy(long id) {
		Optional<Category> opCategory = categoryRepo.findById(id);
		if (opCategory.isPresent()){
		    Category category = opCategory.get();
		    categoryRepo.delete(category);
		}
	}
}
