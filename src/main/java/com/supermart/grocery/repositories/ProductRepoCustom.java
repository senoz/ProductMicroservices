package com.supermart.grocery.repositories;
import java.util.List;

import com.supermart.grocery.dtos.Product;

public interface ProductRepoCustom {

	public List<Product> findByCatId(long id); 

}
