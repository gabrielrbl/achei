<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Login">
	<p class="error">${errorString}</p>

	<form method="POST" action="doLogin">
  		<div class="form-group">
    		<label for="email">E-mail</label>
   			<input type="email" class="form-control" id="email" name="email" value="${usuario.email}" />
		</div>
		<div class="form-group">
	  		<label for="senha">Senha</label>
	   		<input type="password" class="form-control" id="senha" name="senha" value="${usuario.senha}">
		</div>
		<div class="form-check">
			<input type="checkbox" class="form-check-input" id="lembrarMe" name="lembrarMe">
			<label class="form-check-label" for="lembrarMe">Lembrar-me</label>
	 	</div>
		<button type="submit" class="btn btn-primary">Entrar</button>
		<a href="${pageContext.request.contextPath}/">Cancelar</a>
	</form>
</t:wrapper>