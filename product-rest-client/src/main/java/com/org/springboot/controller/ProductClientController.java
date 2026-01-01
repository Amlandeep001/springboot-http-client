package com.org.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.springboot.client.ProductClient;
import com.org.springboot.dto.Product;

@RestController
@RequestMapping("/products/client")
public class ProductClientController
{
	private final ProductClient productClient;

	public ProductClientController(ProductClient productClient)
	{
		this.productClient = productClient;
	}

	@GetMapping
	public List<Product> getProducts()
	{
		return productClient.getAllProducts();
	}

	@GetMapping("/{category}")
	public List<Product> getProductsByCategory(@PathVariable String category)
	{
		return productClient.getProductsByCategory(category);
	}

	@PostMapping
	public List<Product> addProducts(@RequestBody List<Product> products)
	{
		return productClient.addNewProduct(products);
	}
}
