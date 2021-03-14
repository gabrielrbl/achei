<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper title="Início">
<form method="GET" action="SearchImovel">
	<div class="form-row">
		<div class="col">
	    	<select class="form-control" name="tipoNegocio">
	        	<option value="comprar" selected>Comprar</option>
	        	<option value="alugar">Alugar</option>
	      	</select>
		</div>
		<div class="col">
	    	<select class="form-control" name="tipoImovel">
	    		<option value="" selected>Tipo</option>
	        	<option value="ap">Apartamento</option>
	        	<option value="ca">Casa</option>
	      	</select>
		</div>
		<button type="submit" class="btn btn-primary">Buscar</button>
	</div>
</form>
</t:wrapper>