<%@tag description="Page Wrapper Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@attribute name="title" required="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Achei! - ${title}</title>
    
    <!-- CSS -->
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.15.2/css/all.css'>
	<link href="https://cdn.jsdelivr.net/gh/bbbootstrap/libraries@main/smart_wizard.min.css" rel="stylesheet" type="text/css" />
	<link href="https://cdn.jsdelivr.net/gh/bbbootstrap/libraries@main/smart_wizard_theme_arrows.min.css" rel="stylesheet" type="text/css" />
	
	<!-- JS -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	
	<style>
	.main-body { padding: 15px; }
	.card-body { flex: 1 1 auto; min-height: 1px; padding: 1rem; }
	.gutters-sm { margin-right: -8px; margin-left: -8px; }
	.gutters-sm>.col, .gutters-sm>[class*=col-] { padding-right: 8px; padding-left: 8px; }
	.mb-3, .my-3 { margin-bottom: 1rem!important; }
	.bg-gray-300 { background-color: #e2e8f0; }
	.h-100 { height: 100%!important; }
	.shadow-none { box-shadow: none!important; }
	body { margin-top:20px; color: #1a202c; text-align: left; font-family: 'Open Sans',-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,'Helvetica Neue',Arial,sans-serif;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.45;
    background-color: #F5F7FA; }
		.form-control:focus { color: #495057; background-color: #fff; border-color: #80bdff; outline: 0; box-shadow: none !important }
		.navbar { padding: 0px; border-bottom: 1px solid #e6e6f2; -webkit-box-shadow: 0px 0px 28px 0px rgba(82, 63, 105, 0.13); box-shadow: 0px 0px 28px 0px rgba(82, 63, 105, 0.13); -webkit-transition: all 0.3s ease; min-height: 60px }
		.navbar-brand { display: inline-block; margin-right: 1rem; line-height: inherit; white-space: nowrap; padding: 11px 20px; font-size: 30px; text-transform: uppercase; font-weight: 700; color: #007bff }
		.navbar-brand:hover { color: #007bff; }
		.navbar-right-top { }
		.navbar-right-top .nav-item { border-right: 1px solid #e6e6f2 }	
		.navbar-right-top .nav-item:last-child { border: none; }
		.navbar-right-top .nav-item .nav-link { padding: 13px 20px; font-size: 16px; line-height: 2; color: #82849f; }
		.notification { }
		.notification-dropdown { min-width: 320px; }
		.notification-dropdown, .connection-dropdown, .nav-user-dropdown { padding: 0px; margin: 0px;}
		.notification-title { font-size: 14px; color: #3d405c; text-align: center; padding: 8px 0px; border-bottom: 1px solid #e3e3e3; line-height: 1.5; background-color: #fffffe; }
		.notification-list { }
		.notification-list .list-group-item { border-radius: 0px; padding: 12px; margin-top: -1px; border-left: transparent; border-right: transparent }
		.notification-list .list-group-item.active { z-index: 2; color: #3d405c; background-color: #f7f7fb; border-color: #e1e1e7 }
		.notification-list .list-group-item-action:focus, .list-group-item-action:hover { color: #404040; text-decoration: none; background-color: #f7f7fb; }
		.notification-list .list-group-item:last-child { }
		.notification-info { }
		.notification-info .notification-date { display: block; font-size: 11px; margin-top: 4px; text-transform: uppercase; color: #71748d; }
		.notification .dropdown-toggle::after, .connection .dropdown-toggle::after, .nav-user .dropdown-toggle::after { display: inline-block; width: 0; height: 0; margin-left: .255em; vertical-align: .255em; content: ""; border: none; }
		.notification-list-user-img { float: left; }
		.notification-list-user-block { padding-left: 50px; font-size: 14px; line-height: 21px; }
		.notification-list-user-name { color: #5969ff; font-size: 14px; margin-right: 8px; }
		.list-footer, .conntection-footer { font-size: 14px; color: #fff; text-align: center; padding: 10px 0px; line-height: 1.5; font-weight: 700; background-color: #5969ff; border-bottom-left-radius: 3px; border-bottom-right-radius: 3px }
		.list-footer a,	.conntection-footer a { color: #fff }
		.list-footer a:hover, .conntection-footer a:hover { color: #fff }
		.indicator { content: ''; position: absolute; top: 16px; right: 23px; display: inline-block; width: 7px; height: 7px; border-radius: 100%; background-color: #ef172c; animation: .9s infinite beatHeart; transform-origin: center }
		@keyframes beatHeart {
		    0% { transform: scale(0.9) }
		    25% { transform: scale(1.1) }
		    40% { transform: scale(0.9) }
		    60% { transform: scale(1.1) }
		    100% { transform: scale(0.9) }
		}
		.connection { }
		.connection-dropdown { }
		.connection-list { width: 300px; padding: 20px; }
		.connection-item { border-radius: 3px; line-height: 32px; text-align: center; padding: 12px 7px 4px; display: block; border: 1px solid transparent; color: #3d405c; font-size: 12px }
		.connection-item img { width: 32px }
		.connection-item:hover { background-color: #fff; border: 1px solid #e6e6f2; }
		.connection-item span { display: block; overflow: hidden; text-overflow: ellipsis; white-space: nowrap }
		.nav-user { }
		.nav-user-dropdown { padding: 0px; min-width: 230px; margin: 0px; }
		.nav-user-name { }
		.nav-user-info { background-color: #5969ff; line-height: 1.4; padding: 12px; color: #fff; font-size: 13px; border-radius: 2px 2px 0 0 }
		.nav-user-info .status { float: left; top: 7px; left: 0px }
		.nav-user-dropdown { }
		.nav-user-dropdown .dropdown-item { display: block; width: 100%; padding: 12px 22px 15px; clear: both; font-weight: 400; color: #686972; text-align: inherit; white-space: nowrap; background-color: transparent; border: 0; font-size: 13px; line-height: 0.4 }
		.nav-user-dropdown .dropdown-item:hover { background-color: #f7f7fb; }
		.user-avatar-xxl { height: 128px; width: 128px; }
		.user-avatar-xl { height: 90px; width: 90px	}
		.user-avatar-lg { height: 48px; width: 48px	}
		.user-avatar-md { height: 32px; width: 32px	}
		.user-avatar-sm { height: 24px; width: 24px	}
		.user-avatar-xs { height: 18px; width: 18px	}
		.avatar { width: 2.25rem; height: 2.25rem; border-radius: 50%; border: 2px solid #F7F9FA; background: #F7F9FA; color: #fff }
		.media-attachment div.avatar { border: none }
		.avatar.bg-primary { display: flex; align-items: center; justify-content: center; }
		.avatar.bg-primary i { font-size: 14px }
		footer { font-weight: bold; line-height: 0.8cm; background: #FFF; color: #007bff; font-size: 13px; padding: 2px; -webkit-box-shadow: 0px 0px 28px 0px rgba(82, 63, 105, 0.13); box-shadow: 0px 0px 28px 0px rgba(82, 63, 105, 0.13); -webkit-transition: all 0.3s ease; }
	</style>
</head>

<body>
<nav class="navbar navbar-expand-lg bg-white fixed-top">
	<a class="navbar-brand" href="${pageContext.request.contextPath}/">ACHEI!</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="collapse navbar-collapse " id="navbarSupportedContent">
		<ul class="navbar-nav ml-auto navbar-right-top">
			<li class="nav-item dropdown nav-user">
				<a class="nav-link" href="${pageContext.request.contextPath}/">
					<i class="fas fa-home"></i>
				</a>
			</li>
		<!-- 
			<li class="nav-item dropdown notification">
				<a class="nav-link nav-icons" href="#" id="navbarDropdownMenuLink1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-fw fa-bell"></i>
					<span class="indicator"></span>
				</a>
				<ul class="dropdown-menu dropdown-menu-right notification-dropdown">
					<li>
						<div class="notification-title">Notification</div>
						<div class="notification-list">
							<div class="list-group">
								<a href="#"	class="list-group-item list-group-item-action active">
									<div class="notification-info">
										<div class="notification-list-user-img">
											<img src="https://img.icons8.com/office/100/000000/administrator-female.png" alt="" class="user-avatar-md rounded-circle">
										</div>
										<div class="notification-list-user-block">
											<span class="notification-list-user-name">Jeremy Hukonah</span>accepted your invitation to join the team.
											<div class="notification-date">2 min ago</div>
										</div>
									</div>
								</a>
								<a href="#" class="list-group-item list-group-item-action">
									<div class="notification-info">
										<div class="notification-list-user-img">
											<img src="https://img.icons8.com/color/48/000000/administrator-female.png" alt="" class="user-avatar-md rounded-circle">
										</div>
										<div class="notification-list-user-block">
											<span class="notification-list-user-name">John Sammy</span>updated the email address
											<div class="notification-date">2 days ago</div>
										</div>
									</div>
								</a>
								<a href="#" class="list-group-item list-group-item-action">
									<div class="notification-info">
										<div class="notification-list-user-img">
											<img src="https://img.icons8.com/color/100/000000/name.png" alt="" class="user-avatar-md rounded-circle">
										</div>
										<div class="notification-list-user-block">
											<span class="notification-list-user-name">Kioh Samso</span>	is watching your main repository
											<div class="notification-date">2 min ago</div>
										</div>
									</div>
								</a>
							</div>
						</div>
					</li>
					<li>
						<div class="list-footer">
							<a href="#">View all notifications</a>
						</div>
					</li>
				</ul>
				</li> -->
			<c:if test="${!empty usuarioLogado}">
				<li class="nav-item dropdown connection">
					<a class="nav-link" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<i class="fas fa-fw fa-th"></i>
					</a>
					<ul class="dropdown-menu dropdown-menu-right connection-dropdown">
						<li class="connection-list">
							<div class="row">
								<div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 ">
									<a href="${pageContext.request.contextPath}/userImoveis" class="connection-item">
										<img src="https://img.icons8.com/color/100/000000/real-estate.png" alt=""> <span>Imóveis</span>
									</a>
								</div>
							</div>
						</li>
						<!-- <li>
							<div class="conntection-footer">
								<a href="#">More</a>
							</div>
						</li> -->
					</ul>
				</li>
			</c:if>
			<li class="nav-item dropdown nav-user">
				<a class="nav-link nav-user-img" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<img src="https://img.icons8.com/dusk/100/000000/user-female-circle.png" alt="" class="user-avatar-md rounded-circle">
				</a>
				<div class="dropdown-menu dropdown-menu-right nav-user-dropdown" aria-labelledby="navbarDropdownMenuLink2">
					<div class="nav-user-info">
						<h5 class="mb-0 text-white nav-user-name" style="text-transform: capitalize;"><c:out value="${empty usuarioLogado ? 'Visitante' : fn:toLowerCase(usuarioLogado.nome)}" /></h5>
						<c:if test="${!empty usuarioLogado}">
							<span class="status"></span>
							<span class="ml-2"><c:out value="${usuarioLogado.ativo == true ? 'Ativo' : 'Inativo'}" /></span>
						</c:if>
					</div>
					
					<c:choose>
						<c:when test="${!empty usuarioLogado}">
							<a class="dropdown-item" href="${pageContext.request.contextPath}/profile"><i class="fas fa-user mr-2"></i>Perfil</a>
							<!-- <a class="dropdown-item" href="#"><i class="fas fa-cog mr-2"></i>Setting</a> -->
							<a class="dropdown-item" href="${pageContext.request.contextPath}/logout"><i class="fas fa-power-off mr-2"></i>Sair</a>
						</c:when>
						<c:otherwise>
							<a class="dropdown-item" href="${pageContext.request.contextPath}/login"><i class="fas fa-user mr-2"></i>Entrar</a>
						</c:otherwise>
					</c:choose>
				</div>
			</li>
		</ul>
	</div>
</nav>

<div class="container" style="padding-top: 45px; padding-bottom: 25px; ">
	<jsp:doBody/>
</div>

<footer class="fixed-bottom">
	<div class="col-md-12 p-1 text-center">
		&copy; Copyright 2021 - Achei!
	</div>
</footer>
</body>
</html>