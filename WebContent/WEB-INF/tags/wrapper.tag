<%@tag description="Page Wrapper Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="title" required="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>${pageTitle}</title>
  <link rel="stylesheet" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css" />" integrity="sha384-AysaV+vQoT3kOAXZkl02PThvDr8HYKPZhNT5h/CXfBThSRXQ6jW5DO2ekP5ViFdi" crossorigin="anonymous">
  <link href="<c:url value="/styles.css" />" rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-light bg-faded">
		<h3 class="site-name float-md-left">Achei!</h3>
		<ul class="nav navbar-nav float-md-right">
	  		<li class="nav-item">
	    		<a class="nav-link" href="${pageContext.request.contextPath}/">Início</a>
			</li>
			<!-- 
			<li class="nav-item">
	  			<a class="nav-link" href="${pageContext.request.contextPath}/productList">Product List</a>
			</li> -->
			<li class="nav-item">
	  			<a class="nav-link" href="${pageContext.request.contextPath}/userInfo">Minha conta</a>
			</li>
			<li class="nav-item">
	  			<a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
	    	</li>
	  	</ul>
	</nav>

	<div class="container">
  		<div class="row header">
    		<div class="col-sm-8">
      			<h2 class="page-title">${title}</h2>
			</div>

			<div class="col-sm-4"><!-- User store in session with attribute: usuarioLogado -->
				<p class="greeting text-sm-right">Olá! <b>${usuarioLogado.email}</b></p>
			</div>
		</div>
	<jsp:doBody/>
	</div>
<script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/js/bootstrap.min.js" /> integrity="sha384-BLiI7JTZm+JWlgKa0M0kGRpJbF2J8q+qreVrKBC47e3K6BW78kGLrCkeRX6I9RoK" crossorigin="anonymous"></script>
</body>
</html>