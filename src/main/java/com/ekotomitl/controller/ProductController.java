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

import com.ekotomitl.models.Product;
import com.ekotomitl.services.ProductService;

@RestController
@RequestMapping("/product/")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	//Get all
	@GetMapping
	public List<Product> getAllProduct() {
		return productService.findAllProduct();
	}
	
	//Get regresa un JSON valido
	@GetMapping("{id}") //Solicita una id para filtrar
	public ResponseEntity<Product> getProductById (@PathVariable Long id) {
		return productService.findProductById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Post
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	//Put
	@PutMapping("{id}")
	public Product updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
		return productService.replaceProduct(newProduct, id);
	}
	
	//Delete
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
		return productService.findProductById(id)
				.map(product -> {
					productService.deleteProductById(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}


}
