package com.pack1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	HttpSession session = req.getSession(false);
	if(session==null) {
		throw new RuntimeException("Session expired");
		
	}
	else {
		String pprice = req.getParameter("pprice");
		String pqty = req.getParameter("pqty");
		String pcode = req.getParameter("pcode");
		ProductBean pb=null;
		ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("productList");
		Iterator<ProductBean> i = al.iterator();
		while(i.hasNext()) {
			pb= i.next();
			if(pcode.equals(pb.getP_code())) {
				break;
			}
			
		}
		pb.setP_price(pprice);
		pb.setP_qty(pqty);
		pb.setP_code(pcode);
		int rowCount = new UpdateProductDAO().updateProduct(pb);
		if(rowCount>0) {
			req.setAttribute("msg", "Product Inventory updation Success");
			req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "Product Inventory updation failed");
			req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
		}
		
	}
}
}
