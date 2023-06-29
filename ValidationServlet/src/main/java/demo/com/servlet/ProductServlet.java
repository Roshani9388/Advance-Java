package demo.com.servlet;

import demo.com.beans.Product;
import demo.com.service.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ProductService ps=new ProductServiceImpl();
		List<Product> plist=ps.showAllProduct();
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiii");
		out.println("Product Details");
		out.println("<table border='2'><tr><th>Pid</th>  <th product Name </th><th> Quantity</th> <th>Price</th></tr>");
		for(Product p:plist) {
			out.println(" <tr><td> "+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getQty() +"</td><td>"+p.getPrice()+"</td></tr>");
		}
		
		out.println("</table>");
		
	}

}
