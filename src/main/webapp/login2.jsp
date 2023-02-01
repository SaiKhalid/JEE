<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page    import ="java.util.Date"%> 

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!--<h2> <%= new Date() %> </h2>
<% for (int i=0; i<6; i++){ %>
	<p> n° <%= i %> </p>
	<% }	%>
-->

<form action="exerciceslogin" method ="post">
<div class="flex-container">
<div>
<h1>Login Page</h1>
<label for="txtLogin">Login</label><br>
<input name="txtLogin" type="text"><br><br>
<label for="txtPassword">Password</label><br>
<input name="txtPassword" type="password"><br><br>
<p> Password must include at least a Capital letter. </p><br><br>
<input name="btnConnect" type="submit"><br><br />
</div>
</div>
</form>

</body>
</html>