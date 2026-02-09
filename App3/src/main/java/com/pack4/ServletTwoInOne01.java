package com.pack4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/f-1")
public class ServletTwoInOne01 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		 String  myName="Junaid";
		 String myPws ="Java is awesome";
		 
		 
		 PrintWriter w = res.getWriter();
		 res.setContentType("text/html");
		 
		 if((req.getParameter("name").equals(myName)&&req.getParameter("pwd").equals(myPws)))
		 {
			 w.println("<center> <h1>");
			 w.println("Welcome "+req.getParameter("name")+"<br><br>");
			 w.println(" You Did The Task!!<br><br>");
			 
			 w.println("<center> <h1>");
		 }
		 else {
			 w.println("<center> <h1>");
			 w.println("Welcome "+req.getParameter("name")+"<br><br>");
			 w.println("Invalid Credintial<br><br>");
			 
			 w.println("<center> <h1>");
		 }
			  
			 
		 
		
	}

}
