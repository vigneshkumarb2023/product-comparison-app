package com.productcomparison.service;

import com.productcomparison.entity.Product;
import com.productcomparison.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
    
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    
    public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice) {
        return productRepository.findByPriceRange(minPrice, maxPrice);
    }
    
    public List<String> getAllCategories() {
        return productRepository.findAllCategories();
    }
    
    public List<Product> getProductsByCategoryAndPriceRange(String category, Double minPrice, Double maxPrice) {
        return productRepository.findByCategoryAndPriceRange(category, minPrice, maxPrice);
    }
    
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }
}
