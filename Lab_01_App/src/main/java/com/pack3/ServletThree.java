package com.pack3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/user")
public class ServletThree extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	 
		String id = req.getParameter("id");
		String fname= req.getParameter("fname");
		String lname=req.getParameter("lname");
		String mail=req.getParameter("mail");
		String phone = req.getParameter("phone");
		
		PrintWriter pw= res.getWriter();
		res.setContentType("text/html");
		
		pw.println("<center> <b>");
		pw.println("User Id: "+id+" <br><br>");
		pw.println("User Fname: "+fname+" <br><br>");
		pw.println("User Lname: "+lname+" <br><br>");
		pw.println("User MailId: "+mail+" <br><br>");
		pw.println("User MailId: "+phone+" <br><br>");
		
		pw.println("</center> </b>");
		
		
		
	}

}
