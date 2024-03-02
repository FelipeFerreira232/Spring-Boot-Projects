package com.example.webapplicationdemo.services;

import java.util.ArrayList;	
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.webapplicationdemo.model.Product;

@Service
public class ProductService {

	private static List<Product> products = new ArrayList<>();
	
	public List<Product> findAll(){
		return products;
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
}
