package com.org.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.spring.entities.Categories;



public interface CategoriesRepository extends JpaRepository<Categories,Integer> {

}
