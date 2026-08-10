    <%@ page import="com.pack1.*" %>
    <%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
             <h1>
                   
                  <%
                      AdminBean abean =(AdminBean) session.getAttribute("abean");
                  ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("productList");
                  if(al.size()==0){
                	  out.println("Products are not available in the Inventory");
                  }
                  else{
                	  out.println(" Hellow mr"+abean.getA_fname()+"These are your product  Details<br><br>");
                	  
                	    Iterator<ProductBean> i = al.iterator();
                	    while(i.hasNext()){
                	    	ProductBean pb = i.next();
                	    	out.println(pb.getP_code()+" "+pb.getP_name()+" "+ pb.getP_company()+" "+pb.getP_qty()+" "+"<a href='edit?pcode="+pb.getP_code()+"'>Edit </a>"+ "<a href='delete?pcode="+pb.getP_code()+"'>Delete </a><br><br>");
                	    }
                  }
                  %>
                  
                  
             </h1>
             
</center>
</body>
</html>