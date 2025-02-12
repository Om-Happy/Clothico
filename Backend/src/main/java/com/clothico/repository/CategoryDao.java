package com.clothico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clothico.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

}
