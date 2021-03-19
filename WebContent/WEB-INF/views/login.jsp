<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:wrapper title="Login">
	<div class="container">
		<div class="main-body">
			<nav aria-label="breadcrumb" class="main-breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href="${pageContext.request.contextPath}/">Início</a></li>
					<li class="breadcrumb-item"><a href="javascript:void(0)">Usuário</a></li>
					<li class="breadcrumb-item active" aria-current="page">Login</li>
				</ol>
			</nav>

			<p>${errorString}</p>

			<div class="row gutters-sm">
				<aside class="col-sm-4 mx-auto">
					<div class="card">
						<article class="card-body">
							<a href="${pageContext.request.contextPath}/register"
								class="float-right btn btn-outline-primary">Cadastrar</a>
							<h4 class="card-title mb-4 mt-1">Entrar</h4>
							<form method="POST" action="doLogin">
								<div class="form-group">
									<label for="email">E-mail</label> <input name="email"
										class="form-control" placeholder="E-mail" type="email">
								</div>
								<div class="form-group">
									<a class="float-right" href="#">Esqueceu?</a> <label>Senha</label>
									<input name="senha" class="form-control" placeholder="******"
										type="password">
								</div>
								<div class="form-group">
									<div class="checkbox">
										<label> <input type="checkbox" name="lembrarMe">
											Lembrar-me
										</label>
									</div>
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary btn-block">Entrar</button>
								</div>
							</form>
						</article>
					</div>
				</aside>
			</div>
		</div>
	</div>
</t:wrapper>