<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<FORM NAME="actionForm" action="DisplayTable" method='get'>
<table border="2">
<tr>
    <th>ProjectName</th>
    <th>ProjectID</th>
<!--     <th>ProjectLink</th>
 -->
 </tr>
<%
 // ResultSet rs =null; // Messy code will be in some Controller
%>
<%-- <%
 while(ResultSet rs.next()){    %>  
<tr>
    <td> <%=rs.getString("name") %> </td>
    <td> <%=rs.getString("project_uuid") %> </td>
    
    
</tr>
<% } %>  --%>
</table>
</FORM>


</body>
</html>