package com.monkys.tower.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.monkys.tower.app.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findByDescriptionContainingIgnoreCase(String description);

}
