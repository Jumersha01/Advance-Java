<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
     <%@ page import="com.pack1.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <%
       AdminBean abean = (AdminBean) session.getAttribute("abean");
       ProductBean pb = (ProductBean)request.getAttribute("p_bean");
       out.println(abean.getA_fname()+"bellow is the data  available to edit<br><br>");
       
       
       %>
       <form action="update" method="post">
        Product Price <input type="text" name="pprice" value="<%=pb.getP_price() %>"><br><br>
         Product Quantity <input type="text" name="pqty" value="<%=pb.getP_qty()%>"><br><br>
         <input type="hidden" name=pcode value="<%=pb.getP_code() %>"><br><br>
         <input type="submit" value="Update">
        </form>
</body>
</html>