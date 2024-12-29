<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enter Student ID</title>
</head>
<body>
<h2>Enter the Student ID</h2>
<form action="showDetails">
    Student ID:
    <input type="number" name="studentId" value="studentId"/>
    <br>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>

