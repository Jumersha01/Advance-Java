package com.pack4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/user2")
public class ServletFour extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	   
		String fname=req.getParameter("fname");
		
		String lname=req.getParameter("lname");
		String mail=req.getParameter("mail");
		String phone = req.getParameter("phone");
		String addres = req.getParameter("address");
		
		PrintWriter w = res.getWriter();
		res.setContentType("text/html");
		
		w.println("<center> <h1>");
		w.println(fname+"<br><br>");
		w.println(lname+"<br><br>");
		w.println(mail+"<br><br>");
		w.println(phone+"<br><br>");
		w.println(addres+"<br><br>");
		
		w.println("</center> <h1/>");
		
		
	}
    
}
