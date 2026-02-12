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
                           String p_name= request.getParameter("pname"); 
                           out.println("Product name "+p_name+"<br><br>");
                           
                           String p_id= request.getParameter("pid"); 
                           out.println("Product Id "+p_id+"<br><br>");
                           
                           String p_quantity= request.getParameter("pq"); 
                           out.println("Product quantity "+p_quantity+"<br><br>");
                           
                           String p_price= request.getParameter("pp"); 
                           out.println("Product price "+p_price+"<br><br>");
                           
                           
                           
                           %>
                           
                </h1>
</center>
</body>
</html>