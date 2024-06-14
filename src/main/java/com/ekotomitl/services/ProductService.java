package com.ekotomitl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekotomitl.models.Product;
import com.ekotomitl.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	//Get todos los productos
	public List<Product> findAllProduct() {
		return productRepository.findAll();
	}
	
	//Get un solo producto
	public Optional<Product> findProductById(Long id) {
		return productRepository.findById(id);
	}
	
	//Post
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	//Put
	public Product replaceProduct(Product newProduct, Long id) {
		return productRepository.findById(id)
				.map(product -> {
					product.setProduct_name(newProduct.getProduct_name());
					product.setDescripcion(newProduct.getDescripcion());
					product.setPrice(newProduct.getPrice());
					product.setDiscount(newProduct.getDiscount());
					product.setCategory(newProduct.getCategory());
					return productRepository.save(product);
				}) 
				.orElseGet(() -> {
					return productRepository.save(newProduct);
				});
	}
	
	//Delete un producto
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
		

}
