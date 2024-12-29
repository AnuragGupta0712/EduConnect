<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Anurag Gupta
  Date: 01-08-2024
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Here are your instructors</h1>
<% ArrayList<HashMap<String,Object>> listOfInstructors = (ArrayList<HashMap<String,Object>>)request.getAttribute("instructors");
for(HashMap<String,Object> instructor : listOfInstructors) {
   %>
name:<%= instructor.get("name")%>
<a href="profile/<%= instructor.get("id")%>">Profile</a>
<%
}
%>
</body>
</html>
