package com.supermart.grocery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermart.grocery.dtos.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>, ProductRepoCustom {

}
