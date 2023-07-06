package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Product;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired 
	private ProductService productService;
	
	@GetMapping("/viewproduct")
	public ModelAndView displayProductList(){
		
		List<Product> plist=productService.getAllProduct();
		return new ModelAndView("displayproduct","plist",plist) ;
		
	}
	
	@GetMapping("/edit/{pid}")
	public ModelAndView editProductById(@PathVariable int pid){ 
		
		Product p =productService.editProductById(pid);
		return new ModelAndView("editproduct","prod",p) ;
		
	}

	@PostMapping("/updateproduct")
	public ModelAndView UpdateProduct(@RequestParam int pid,@RequestParam String pname,@RequestParam int qty,@RequestParam float price) {
	Product p=new Product(pid,pname,qty,price);
	productService.updateProduct(p);
		return new ModelAndView("redirect:/product/viewproduct");
	
	}
	
	@GetMapping("/addproduct")
	public String addProductForm() {
		return "addproduct";
		
	}
	
	@GetMapping("/logout")
	public String logOut(){
		
		return "loginpage";
		
	}
	
	@PostMapping("/addnewproduct")
	public ModelAndView addNewProduct(@RequestParam int pid,@RequestParam String pname,@RequestParam int qty,@RequestParam float price) {
		Product p=new Product(pid,pname,qty,price);
		productService.addNewProduct(p);
			return new ModelAndView("redirect:/product/viewproduct");
		
		}
	
	
	@GetMapping("/delete/{pid}")
	public ModelAndView deleteProduct(@PathVariable int pid) {
		productService.deleteProductById(pid);
		return new ModelAndView("redirect:/product/viewproduct") ;
	
	}
}
