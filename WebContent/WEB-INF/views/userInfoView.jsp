<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Perfil">
  E-mail: <b>${usuario.email}</b>
  <br />
  CPF: ${usuario.cpf}
  <br />
</t:wrapper>