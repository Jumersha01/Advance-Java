package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/details")
public class PersonDetailsServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("uname");
		String age = req.getParameter("uage");
		String mobile=req.getParameter("umobile");
		String gender =req.getParameter("gender");
		String state = req.getParameter("state");
		String hob[] = req.getParameterValues("hb");
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pw.println("<center> <h1>");
		pw.println("Name-"+name+"<br><br>");
		pw.println("Age-"+age+"<br><br>");
		pw.println("Mobile-"+mobile+"<br><br>");
		pw.println("Gender-"+gender+"<br><br>");
		pw.println("State-");
		  for(String names:hob) {
			  pw.println("Hobies-"+names+"<br><br>");
		  }
		pw.println("State-"+state+"<br><br>");
		
		
		pw.println("</h1></center> ");
		
		
		
	}

}
