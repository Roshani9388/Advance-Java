package demo.com.servlet;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurrencyConvertor extends HttpServlet{
		private int rate;
	public void init(ServletConfig confg) throws ServletException
	{
			super.init(confg);
		 rate=Integer.parseInt(confg.getInitParameter("rate"));
		
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String dollar=req.getParameter("dollar");
		String inr=req.getParameter("inr");
		out.println("<form action='convert' method='get'>");
		out.println("<center><table border='2'><tr><td>Dollar</td><td>INR</td></tr>");
		if(dollar.equals(""))
		{
			int doll=Integer.parseInt(inr)/rate;
			out.println("<tr><td><input type='text' name='dollar' value='"+doll+"'/></td><td><input type='text' name='inr' value='"+inr+"'/></td></tr><hr></table><br><br><input type='submit' name='Convert'/></center></form>");
		}
		
		else
		{
			int inr1=Integer.parseInt(dollar)*rate;
			out.println("<tr><td><input type='text' name='dollar' value='"+dollar+"'/></td><td><input type='text' name='inr' value='"+inr1+"'/></td></tr><hr></table><br><br><input type='submit' name='Convert'/></center></form>");
		}
	}
}
