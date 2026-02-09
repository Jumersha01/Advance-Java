package com.pack2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;



//EmpName : <input type="text" name="ename"><br><br>
//EmpId : <input type="text" name="eid"><br><br>
// EmpSal : <input type="text" name="esal"><br><br>
//  EmpExp : <input type="text" name="ep"><br><br>
@WebServlet("/fs2")
public class SecondServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String ename = req.getParameter("ename");
		String  eId = req.getParameter("eid");
		String eSal = req.getParameter("esal");
		String eExp = req.getParameter("ep");
		
		PrintWriter pw =	res.getWriter();
		res.setContentType("text/html");
		
		 int exp = Integer.parseInt(eExp);
		 int sal = Integer.parseInt(eSal);
		 if(exp>=5) {
			 sal+= (sal*0.10);
			 pw.println("<center><h1>");
			 pw.println("*** Employee Details ***");
			 
			 pw.println("Employee name:"+ename+"<br> <br>");
			 pw.println("Employee id:"+eId+"<br><br>");
			 pw.println("Employee Salary:"+sal+"<br><br>");
			 pw.println("Employee Exp:"+eExp+"<br><br>");
			 
			 pw.println("</center></h1>");
			 
			
			
		 }
		 else {
			 pw.print("<center><h1>");
			 pw.print("<center><h1>");
			 pw.print("*** Employee Details ***<br><br>");
			 pw.println("Employee name:"+ename+"<br> <br>");
			 pw.println("Employee id:"+eId+"<br><br>");
			 pw.println("Employee Salary:"+sal+"<br><br>");
			 pw.println("Employee Exp:"+eExp+"<br><br>");
			 pw.print("</center></h1>");
			 
			 
		 }
		
	}

}
