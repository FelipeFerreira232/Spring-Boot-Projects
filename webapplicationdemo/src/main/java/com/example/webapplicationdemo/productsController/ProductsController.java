package com.example.webapplicationdemo.productsController;

import org.springframework.stereotype.Controller;	
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.webapplicationdemo.model.Product;
import com.example.webapplicationdemo.services.ProductService;

@Controller
public class ProductsController {
	
	private final ProductService service;
	
	public ProductsController(ProductService service) {
		this.service = service;
	}
	
	@GetMapping("/products")
	public String viewProducts(Model model){
		var products = service.findAll();
		model.addAttribute("products", products);
		return "products.html";
	}
	
	@PostMapping("/products")
	public String addProduct(Product product, Model model) {
		service.addProduct(product);
		var products = service.findAll();
		model.addAttribute("products", products);
		return "products.html";
	}
}
