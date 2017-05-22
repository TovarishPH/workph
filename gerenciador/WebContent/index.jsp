<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Servlet.index</title>
</head>
<body>
<h1>Bem vindo ao nosso gerenciador de empresas!</h1><br/>

	<c:if test="${loggedUser != null}">
		Você está logado como <b>${loggedUser.email}</b></br>
	</c:if>

	<form action="executa?tarefa=NovaEmpresa" method="post">
		<p>Nome:</p><input type="text" name="nome"/></br>
		<input type="submit" value="Enviar"/>
	</form>
	
	<form action="login" method="post">
		Email: <input type="text" name="email"/></br>
		Senha: <input type="password" name="senha"></br>
		<input type="submit" value="Login">
	</form>
	
	<form action="executa?tarefa=Logout" method="post">
		<input type="submit" value="Logout" />
	</form>
</body>
</html>