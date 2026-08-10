package com.pack1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req,HttpServletResponse res) {
	HttpSession session = req.getSession(false);
	if(session==null) {
		throw new RuntimeException("Session Expired");
		
	}
	else {
		
	}
}
}
