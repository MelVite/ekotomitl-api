package com.ekotomitl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekotomitl.models.Category;
import com.ekotomitl.services.CategoryService;

@RestController
@RequestMapping("/category/")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	//Get all
	@GetMapping
	public List<Category> getAllCategory() {
		return categoryService.findAllCategory();
	}
	
	//Get regresa un JSON valido
	@GetMapping("{id}") //Solicita una id para filtrar
	public ResponseEntity<Category> getCategoryById (@PathVariable Long id) {
		return categoryService.findCategoryById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Post
	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryService.saveCategory(category);
	}
	
	//Put
	@PutMapping("{id}")
	public Category updateCategory(@RequestBody Category newCategory, @PathVariable Long id) {
		return categoryService.replaceCategory(newCategory, id);
	}
	
	//Delete
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
		return categoryService.findCategoryById(id)
				.map(category -> {
					categoryService.deleteCategoryById(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
