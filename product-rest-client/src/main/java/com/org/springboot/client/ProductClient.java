package com.org.springboot.client;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import com.org.springboot.dto.Product;

@HttpExchange(url = "http://localhost:9191/products")
public interface ProductClient
{
	@PostExchange
	List<Product> addNewProduct(@RequestBody List<Product> products);

	@GetExchange
	List<Product> getAllProducts();

	@GetExchange("/{category}")
	List<Product> getProductsByCategory(@PathVariable String category);
}
