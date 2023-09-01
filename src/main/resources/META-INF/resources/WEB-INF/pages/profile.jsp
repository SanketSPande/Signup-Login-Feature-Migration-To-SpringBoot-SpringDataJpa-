<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align ='center' margin =10px style='margin-top:200px;'>
		<table align ='center' border =1px  style='font-size:40px;'> 
		
			<tr>
			<td>Username</td>
			<td>Password</td>
			<td>Name</td>
			<td>Contact</td>
			</tr>
			
			<tr>
			<td>${user.getUserName()}</td>
			<td>${user.getPassword()}</td>
			<td>${user.getName()}</td>
			<td>${user.getContact()}</td>
			</tr>
		</table>
	</div>
	
	</div>
	<br>
		<a href="http://localhost:8080/get_home_page?username=${user.getUserName()}"> <button style=' width: 200px;height: 70px;color: rgb(239, 94, 94);font-size: larger;position: absolute;left: 650px;'>Home</button></a>		
</body>
</html>