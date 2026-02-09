package com.pack4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/f-2")
public class ServletTwoInOne02 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
	 String pname = req.getParameter("pname");
	 String pid = req.getParameter("pid");
	 int pq = Integer.parseInt(req.getParameter("pq"));
	 
	 PrintWriter p = res.getWriter();
	 res.setContentType("text/html");
	 
	 
	 
	 double pp = Double.parseDouble(req.getParameter("pp"));
		if(pq<=5) {
			    pp += (pp*0.10);	 
			    
			    p.println("<center><h1>");
			    p.println("Product Name:"+pname+"<br><br>");
			    p.println("Product Id:"+pid+"<br><br>");
			    p.println("Product Quantity: "+pq+"<br><br>");
			    p.println("Product Price :"+(pp*pq)+"<br><br>");
			    p.println("</center> </h1>");
			    
		}
		
		
	}
  
}
