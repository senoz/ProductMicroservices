package com.supermart.grocery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermart.grocery.dtos.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
