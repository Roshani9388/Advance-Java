package demo.com.servlet;

import java.io.IOException;
import demo.com.service.LoginService;
import demo.com.service.LoginServiceImpl;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import demo.com.beans.MyUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.com.beans.RegisterUser;


public class RegistrationServlet extends HttpServlet {

		public void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
			int uid=0;
			LocalDate ldt = null;
			response.setContentType("text/html");
			PrintWriter out= response.getWriter();
			
			try {
					uid=Integer.parseInt(request.getParameter("uid"));
			}
			catch(Exception e)
			{
				System.out.println("error");
			}
			String nm =request.getParameter("name");
			String address =request.getParameter("address");
			String unm =request.getParameter("unm");
			String password =request.getParameter("pwd");
			String[] skills =request.getParameterValues("skills");
			String dt =request.getParameter("dt");
			String gender =request.getParameter("gender");
			String city =request.getParameter("city");
			try {
				ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}catch(Exception e) {}
			
			LoginService ls=new LoginServiceImpl();
			RegisterUser ru=new RegisterUser(uid,nm,address,unm,skills,ldt,gender,city);
			
			
			MyUser user=new MyUser(unm,password,"user");
			ls.addRegisterUser(ru,user);
			
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.forward(request,response);
			
			
			
			
	}

}
