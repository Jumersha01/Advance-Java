package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fs")
public class FirstServlet  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name =req.getParameter("uname");
		String mail=req.getParameter("umail");
		
	PrintWriter pw =	res.getWriter();
//	IO.println("UserName: "+name);
//	IO.println("User MaildId: "+mail);
	
	res.setContentType("text/html");
	pw.print("<center><h1>");
	pw.println("Users Data <br>");
	pw.println("User Name : "+name+"<br> <br>");
	pw.println("User Mail_Id: "+mail+"<br><br>");
	pw.println("<h1> </center>");
	}
          
}
