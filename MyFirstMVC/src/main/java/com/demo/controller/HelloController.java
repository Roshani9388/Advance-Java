package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/")
	public String display()
	{
		return "index";
	}
	@RequestMapping("/hello")
	public ModelAndView sayHello()
	{
		String message="Hello from MVC spring";
		return new ModelAndView("hello","msg",message);
	}
}
