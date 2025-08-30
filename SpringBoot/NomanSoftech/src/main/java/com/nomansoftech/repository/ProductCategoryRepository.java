package com.nomansoftech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nomansoftech.entities.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{

	

}
