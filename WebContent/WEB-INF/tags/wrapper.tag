<%@tag description="Page Wrapper Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="title" required="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Achei! - ${title}</title>
    
    <!-- CSS -->
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.3.1/css/all.css'>
	<link href="https://cdn.jsdelivr.net/gh/bbbootstrap/libraries@main/smart_wizard.min.css" rel="stylesheet" type="text/css" />
	<link href="https://cdn.jsdelivr.net/gh/bbbootstrap/libraries@main/smart_wizard_theme_arrows.min.css" rel="stylesheet" type="text/css" />
	
	<!-- JS -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

	<style>
		body {
			background-color: #eee;
  			padding-top: 56px;
		}
	</style>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
    	<a class="navbar-brand" href="${pageContext.request.contextPath}/">Achei!</a>
		<span class="greeting text-sm-right">Olá, <b><c:out value="${empty usuarioLogado ? 'visitante' : usuarioLogado.email}" /></b>!</span>
		
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        	<span class="navbar-toggler-icon"></span>
      	</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
        	<ul class="navbar-nav ml-auto">
          		<li class="nav-item active">
            		<a class="nav-link" href="${pageContext.request.contextPath}/">Início
              			<span class="sr-only">(current)</span>
            		</a>
          		</li>
          		<c:choose>
				  	<c:when test="${empty usuarioLogado}">
						<li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}/login">Entrar</a>
					   	</li>
				  	</c:when>
				  	<c:otherwise>
						<li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}/userImoveis">Imóveis</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}/profile">Minha conta</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}/logout">Sair</a>
						</li>
				  	</c:otherwise>
				</c:choose>
        	</ul>
    	</div>
	</div>
</nav>

<div class="container">
	<jsp:doBody/>
</div>

<!-- 
<footer class="py-5 bg-dark fixed-bottom">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Achei! 2021</p>
	</div>
</footer> -->
</body>
</html>