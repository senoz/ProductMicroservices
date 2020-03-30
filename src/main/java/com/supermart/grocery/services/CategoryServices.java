package com.supermart.grocery.services;

import com.supermart.grocery.dtos.Category;

public interface CategoryServices {

	public String getCategories();
	
	public void addCategroy(Category category);
	
	public void modifyCategroy(Category category);
	
	public void removeCategroy(long id);
	
}
