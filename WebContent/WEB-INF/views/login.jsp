<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Login">
	<p class="error">${errorString}</p>

	<form method="POST" action="doLogin">
  		<div class="form-group row">
    		<label for="email" class="col-xs-2 col-form-label">E-mail</label>
    		<div class="col-xs-5">
      			<input type="text" class="form-control" id="email" name="email" value="${usuario.email}" />
  			</div>
		</div>

	<div class="form-group row">
  		<label for="senha" class="col-xs-2 col-form-label">Senha</label>
  		<div class="col-xs-5">
    		<input type="password" class="form-control" id="senha" name="senha" value="${usuario.senha}">
  		</div>
	</div>

	<div class="form-group">
		<label class="custom-control custom-checkbox">
		<input type="checkbox" class="custom-control-input" name="lembrarMe">
		<span class="custom-control-indicator"></span>
		<span class="custom-control-description">Lembrar-me</span>
		</label>
 	</div>

	<input type="submit" class="btn btn-submit" value="Entrar" />
	<a href="${pageContext.request.contextPath}/">Cancelar</a>
	</form>
</t:wrapper>