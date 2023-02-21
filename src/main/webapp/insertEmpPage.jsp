<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Emp</title>
</head>
<body>
<!--  <%= request.getContextPath()%>/InsertEmp -->
<form action= "InsertEmp" method = "post">
	<p>	empId </p>
	<input type = "text" name = "empId"/>
	<br/>
	
	<p>	empName </p>
	<input type = "text" name = "empName"/>
	<br/>
	
	<p>	salary </p>
	<input type = "text" name = "salary"/>
	<br/><br/>
	
	<input type = "submit"/>		

</form>
</body>
</html>
