package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;

@Controller
@RequestMapping("/mylogin")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/login")
	public String showLoginPage() {
		return "loginpage";
	}
	
	@PostMapping("/validate")
	public ModelAndView Validate(HttpSession session,@RequestParam String uname,@RequestParam String password) {
		
		MyUser u1=loginService.validate(uname,password);
		if(u1!=null)
		{
			session.setAttribute("user",u1);
			return new ModelAndView("redirect:/product/viewproduct");
			//return new ModelAndView("hello","msg","Successfully Logged in");
		}
		
		return new ModelAndView("loginpage","msg1","Plz reenter credientialsss");
		
	}

}
