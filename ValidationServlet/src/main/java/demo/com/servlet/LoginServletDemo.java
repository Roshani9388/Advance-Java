package demo.com.servlet;
import demo.com.service.LoginService;
import demo.com.service.LoginServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.com.beans.MyUser;

public class LoginServletDemo extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String uname=req.getParameter("uname");
		String password=req.getParameter("password");
		LoginService ls=new LoginServiceImpl();
		String btn=req.getParameter("btn");
		MyUser u=ls.validateUser(uname,password);
		if(btn.equals("Login"))
		{
			
		
			
			
			if(u!=null) { //&& u.getRole().equals("admin")){
				//out.println("<h2>Successfully Logged in<h2>");
				RequestDispatcher rd1=req.getRequestDispatcher("product");
				rd1.forward(req,res);
				
				
			}
			else {
				
					RequestDispatcher rd=req.getRequestDispatcher("Login.html");
					out.println("<h2>OOPS Invalid Credientials!!!!</h2>");
					rd.include(req,res);	
			}
				
		}
		
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.forward(req,res);
		}
	}

}
