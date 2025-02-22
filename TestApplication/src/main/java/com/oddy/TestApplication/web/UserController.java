package com.oddy.TestApplication.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oddy.TestApplication.domain.Product;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/{userID}")
	public String displayUser(@PathVariable int userID) {
		return "User Found: "+ userID;
	}
	
	@RequestMapping("/{userID}/invoices")
	public String displayUserInvoices(@PathVariable int userID,
			@RequestParam(value="date", required=false) Date dateOrNull) {
		return "Invoice found for user: "+ userID + "on the date: "+dateOrNull;
	}
	
	@RequestMapping("/{userID}/items")
	public List<String> displayStringJson() {
		return Arrays.asList("Shoes", "Laptop", "Monitor");
	}
	
	@RequestMapping("/{userID}/products_as_json")
	public List<Product> displayProductsJson() {
		return Arrays.asList(new Product(1, "shoes", 2500),
				new Product(2, "books", 560),
				new Product(3, "Monitor", 12500));
	}
	
	@RequestMapping("/{userID}/products_as_json/singleproduct")
	public Product displaySingleProductsJson() {
		return new Product(1, "Mac", 50000);
	}
}
