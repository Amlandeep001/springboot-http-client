package com.org.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.springboot.entity.Product;
import com.org.springboot.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController
{
	private final ProductService productService;

	public ProductController(ProductService productService)
	{
		this.productService = productService;
	}

	@PostMapping
	public List<Product> addProducts(@RequestBody List<Product> products)
	{
		return productService.saveProducts(products);
	}

	@GetMapping
	public List<Product> getProducts()
	{
		return productService.getAllProducts();
	}

	@GetMapping("/{category}")
	public List<Product> getProduct(@PathVariable String category)
	{
		return productService.getProduct(category);
	}

}