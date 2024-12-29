<%--
  Created by IntelliJ IDEA.
  User: Anurag Gupta
  Date: 01-08-2024
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--            <h1>Profile Page</h1>--%>
<%--            <h2>Id from path param:${profileID}</h2>--%>
<%--            <div>Instructor Name: ${instructorName}</div>--%>
<%--            <div>Instructor Age: ${instructorAge}</div>--%>
<%--            <div>Instructor ID: ${instructorID}</div>--%>
<%--</body>--%>
<%--</html>--%>


<%--NEW CODE--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instructor Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .profile-container {
            border: 1px solid #ccc;
            padding: 20px;
            width: 300px;
            background-color: pink;
        }
        .error-message {
            color: red;
            font-weight: bold;
        }
        .profile-field {
            margin-bottom: 10px;
        }
        .profile-field label {
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>Instructor Profile</h1>

<!-- Profile Information -->
<c:if test="${empty error}">
    <div class="profile-container">
        <div class="profile-field">
            <label>Instructor Name:</label>
            <span>${instructorName}</span>
        </div>
        <div class="profile-field">
            <label>Instructor Age:</label>
            <span>${instructorAge}</span>
        </div>
        <div class="profile-field">
            <label>Instructor ID:</label>
            <span>${instructorID}</span>
        </div>
    </div>
</c:if>
</body>
</html>
