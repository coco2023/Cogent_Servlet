<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  <%= request.getContextPath()%>/InsertEmp -->
<form action= "DeleteBank" method = "post">
	<p>	delete empId </p>
	<input type = "text" name = "empId"/>
	<br/>
	<input type = "submit"/>	
</form>
<form action= "InsertBank" method = "post">
	<p>	insert empId </p>
	<input type = "text" name = "empId"/>
	<br/>
	
	<p>	insert empName </p>
	<input type = "text" name = "empName"/>
	<br/>
	
	<p>	insert salary </p>
	<input type = "text" name = "salary"/>
	<br/><br/>
	
	<input type = "submit"/>		
</form>


</body>
</html>