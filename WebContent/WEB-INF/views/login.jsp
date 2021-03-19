<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper title="Login">
	<p>${errorString}</p>

	<aside class="col-sm-4">
		<div class="card">
			<article class="card-body">
			<a href="${pageContext.request.contextPath}/register" class="float-right btn btn-outline-primary">Cadastrar</a>
			<h4 class="card-title mb-4 mt-1">Entrar</h4>
				<form method="POST" action="doLogin">
			    <div class="form-group">
			    	<label for="email">E-mail</label>
			        <input name="email" class="form-control" placeholder="E-mail" type="email">
			    </div>
			    <div class="form-group">
			    	<a class="float-right" href="#">Esqueceu?</a>
			    	<label>Senha</label>
			        <input name="senha" class="form-control" placeholder="******" type="password">
			    </div>
			    <div class="form-group">
			    <div class="checkbox">
			      <label> <input type="checkbox" name="lembrarMe"> Lembrar-me</label>
			    </div>
			    </div>
			    <div class="form-group">
			        <button type="submit" class="btn btn-primary btn-block">Entrar</button>
			    </div>
			</form>
			</article>
		</div>
	</aside>
</t:wrapper>