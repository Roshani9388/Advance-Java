package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Product;
import com.demo.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> displayAll() {
		return productService.displayAll();
	}

	
	@GetMapping("/products/{pid}")
	public ResponseEntity<Product> displayById(@PathVariable int pid) {
		
		Product p= productService.displayById(pid);
		if(p!=null)
			return ResponseEntity.ok(p);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	

	@DeleteMapping("/products/{pid}")
	public ResponseEntity<String> deleteById(@PathVariable int pid) {
		int n=productService.deleteById(pid);
		if(n>0)
			return ResponseEntity.ok("Deleted Succesfully");
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	

	@PutMapping("/products/{pid}")
	public ResponseEntity<String> updateProduct(@RequestBody Product p) {
		int n=productService.UpdateProduct(p);
		if(n>0)
			return ResponseEntity.ok("Updated Succesfully");
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	

	@PostMapping("/products/{pid}")
	public ResponseEntity<String> addNewProduct(@RequestBody Product p) {
		
		 int n=productService.AddNew(p);
		 if(n>0)
				return ResponseEntity.ok("Added Succesfully");
			else
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	
	}
}
