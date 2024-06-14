package com.ekotomitl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekotomitl.models.Category;
import com.ekotomitl.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	//Get todas las categorias
	public List<Category> findAllCategory() {
		return categoryRepository.findAll();
	}

	//Get una categoria
	public Optional<Category> findCategoryById(Long id) {
		return categoryRepository.findById(id);
	}
	
	//Post
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	//Put
	public Category replaceCategory(Category newCategory, Long id) {
		return categoryRepository.findById(id)
				.map(category -> {
					category.setCategory_name(newCategory.getCategory_name());
					return categoryRepository.save(category);
				})
				.orElseGet(() -> {
					return categoryRepository.save(newCategory);
				});
	}
	
	//Delete una categoria
	public void deleteCategoryById(Long id) {
		categoryRepository.deleteById(id);
	}
}
