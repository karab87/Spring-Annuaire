<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="include.jsp"%>
<title>Page de Connexion</title>
</head>
<body>

	<div class="container">

		<form class="form-signin" action="j_spring_security_check"
			method="post">
			
			
			<div><img alt="" src="<%=request.getContextPath()%>/resources/image/login.jpg""></div>
			
			<label class="sr-only">Nom d'Administrateur</label> <input
				type="text" name="j_username" class="form-control"
				placeholder="Nom d'utilisateur" required autofocus> <label
				for="" class="sr-only">Mot de passe</label> <input type="password"
				name="j_password" class="form-control" placeholder="Password"
				required> <input class="btn btn-lg btn-primary btn-block"
				type="submit" value="Login">
			</td>


		</form>
	</div>
	
<%@ include file="include2.jsp"%>

</body>
</html>