<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.pack1.AdminBean" %>
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
                      AdminBean abean = (AdminBean) session.getAttribute("abean");
                      out.println("Welcome "+abean.getA_fname()+"<br><br>");
                      
                    %>
                      <a href="AddProduct.html">Add Products</a>    
                       <a href="view1">View Products</a>    
                        <a href="logout">Logout Products</a>      
                   </h1>
          </center>
</body>
</html>