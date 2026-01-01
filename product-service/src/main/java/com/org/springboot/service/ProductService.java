package com.org.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.springboot.entity.Product;
import com.org.springboot.repository.ProductRepository;

@Service
public class ProductService
{

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}

	public List<Product> saveProducts(List<Product> products)
	{
		return productRepository.saveAll(products);
	}

	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}

	public List<Product> getProduct(String category)
	{
		return productRepository.findByCategory(category);
	}

}