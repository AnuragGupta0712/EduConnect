<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
 <title>Sign Up Page</title>
</head>
<body>
<h1>Sign Up Page</h1>
<form:form action="registerUser" modelAttribute="User">
 Name:
 <form:input path="name"/>
 <br>
 Gender:
 <br>
 Male <form:radiobutton path="Gender" value="Male"/>
 Female <form:radiobutton path="Gender" value="Female"/>
 <br>
 Location:
 <form:select path="location">
  <form:option value="INDIA"/>
  <form:option value="NRI"/>
 </form:select>
 <br>
 College:
 <form:select path="College">
  <form:option value="ABC"/>
  <form:option value="DEF"/>
 </form:select>
 <br>
 <input type="submit"/>
</form:form>
</body>
</html>
