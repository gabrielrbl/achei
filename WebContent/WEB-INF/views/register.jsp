<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper title="Registrar">
<style>
.register { background: linear-gradient(90deg, rgba(0,123,255,1) 0%, rgba(250,250,250,1) 50%, rgba(222,249,251,1) 100%); }
.register-left { text-align: center; color: #fff; margin-top: 4%; }
.register-left input { border: none; border-radius: 1.5rem; padding: 2%; width: 60%; background: #f8f9fa; font-weight: bold; color: #383d41; margin-top: 30%; margin-bottom: 3%; cursor: pointer; }
.register-left img { margin-top: 15%; margin-bottom: 5%; width: 25%; -webkit-animation: mover 2s infinite  alternate; animation: mover 1s infinite  alternate; }
.register-left p { font-weight: lighter; padding: 12%; margin-top: -9%; }


.register-right { background: #f8f9fa; border-top-left-radius: 10% 50%; border-bottom-left-radius: 10% 50%; }
@-webkit-keyframes mover { 0% { transform: translateY(0); } 100% { transform: translateY(-20px); } }
@keyframes mover { 0% { transform: translateY(0); } 100% { transform: translateY(-20px); } }
.register-form { padding: 10%; margin-top: 10%; }
.btnRegister { float: right; margin-top: 10%; border: none; border-radius: 1.5rem; padding: 2%; background: #0062cc; color: #fff; font-weight: 600; width: 50%; cursor: pointer; }
.nav-tabs { margin-top: 3%; border: none; background: #0062cc; border-radius: 1.5rem; width: 28%; float: right; }
.nav-tabs .nav-link { padding: 2%; height: 34px; font-weight: 600; color: #fff; border-top-right-radius: 1.5rem; border-bottom-right-radius: 1.5rem; }
.nav-tabs .nav-link:hover { border: none; }
.nav-tabs .nav-link.active { width: 100px; color: #0062cc; border: 2px solid #0062cc; border-top-left-radius: 1.5rem; border-bottom-left-radius: 1.5rem; }
.register-heading { text-align: center; margin-top: 8%; margin-bottom: -15%; color: #495057; }
</style>

<div class="container">
	<div class="main-body">
		<nav aria-label="breadcrumb" class="main-breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Início</a></li>
				<li class="breadcrumb-item"><a href="javascript:void(0)">Usuário</a></li>
				<li class="breadcrumb-item active" aria-current="page">Registrar</li>
            </ol>
		</nav>
		
		
		<div class="row gutters-sm register">
           	<div class="col-md-3 register-left">
	            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
	            <h3>Bem-vindo</h3>
	            <p>Você está a 30 segundos de fazer parte da melhor plataforma de imóveis da internet!</p>
	            <a href="${pageContext.request.contextPath}/login"><input type="button" value="Entrar"/></a><br/>
	        </div>
			        
	        <div class="col-md-9 register-right">
	      		<c:if test="${errorString != null}">${errorString}</c:if>
	            <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
	                <li class="nav-item">
	                    <a class="nav-link active" id="pf-tab" data-toggle="tab" href="#pf" role="tab" aria-controls="pf" aria-selected="true">Física</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" id="pj-tab" data-toggle="tab" href="#pj" role="tab" aria-controls="pj" aria-selected="false">Jurídica</a>
	                </li>
	            </ul>
            
	            <form method="POST" action="doRegister">
	            <input type="hidden" name="tipoCadastro" id="tipoCadastro" value="PF" />
	            <div class="tab-content" id="myTabContent">
	            	<!-- PF --> 
	                <div class="tab-pane fade show active" id="pf" role="tabpanel" aria-labelledby="pf-tab">
	                    <h3 class="register-heading">Entrar como Pessoa Física</h3>
	                    <div class="row register-form">
	                        <div class="col-md-6">
	                            <div class="form-group">
	                                <input type="text" name="nomePF" class="form-control" placeholder="Nome *" value="" required />
	                            </div>
	                            <div class="form-group">
	                                <input type="password" name="senhaPF" class="form-control" placeholder="Senha *" value="" required />
	                            </div>
	                            <div class="form-group">
	                                <input type="text" name="cpfPF" class="form-control" placeholder="CPF *" value="" required />
	                            </div>
	                        </div>
	                        <div class="col-md-6">
	                            <div class="form-group">
	                                <input type="email" name="emailPF" class="form-control" placeholder="Seu e-mail *" value="" required />
	                            </div>
	                            <div class="form-group">
	                                <input type="password" name="confirmarsenhaPF" class="form-control"  placeholder="Confirmar senha *" value="" required />
	                            </div>
	                            <div class="form-group">
	                                <div class="maxl">
	                                    <label class="radio inline"> 
	                                        <input type="radio" name="generoPF" value="M" checked>
	                                        <span> Masculino </span> 
	                                    </label>
	                                    <label class="radio inline"> 
	                                        <input type="radio" name="generoPF" value="F">
	                                        <span>Feminino </span> 
	                                    </label>
	                                </div>
	                            </div>
	                            <button type="submit" class="btnRegister" />Cadastrar</button>
	                        </div>
	                    </div>
	                </div>
	                <!-- PF --> 
                
                
					<!-- PJ -->                
	                <div class="tab-pane fade show" id="pj" role="tabpanel" aria-labelledby="pj-tab">
	                    <h3 class="register-heading">Entrar como Pessoa Jurídica</h3>
	                    <div class="row register-form">
	                        <div class="col-md-6">
	                            <div class="form-group">
	                                <input type="text" name="nomePJ" class="form-control" placeholder="Nome *" value="" />
	                            </div>
	                            <div class="form-group">
	                                <input type="password" name="senhaPJ" class="form-control" placeholder="Senha *" value="" />
	                            </div>
	                            <div class="form-group">
	                                <input type="text" name="cnpjPJ" class="form-control" placeholder="CNPJ *" value="" />
	                            </div>
	                        </div>
	                        <div class="col-md-6">
	                            <div class="form-group">
	                                <input type="email" name="emailPJ" class="form-control" placeholder="Seu e-mail *" value="" />
	                            </div>
	                            <div class="form-group">
	                                <input type="password" name="confirmarsenhaPJ" class="form-control"  placeholder="Confirmar senha *" value="" />
	                            </div>
	                            <div class="form-group">
	                                <div class="maxl">
	                                    <label class="radio inline"> 
	                                        <input type="radio" name="generoPJ" value="M" checked>
	                                        <span> Masculino </span> 
	                                    </label>
	                                    <label class="radio inline"> 
	                                        <input type="radio" name="generoPJ" value="F">
	                                        <span>Feminino </span> 
	                                    </label>
	                                </div>
	                            </div>
	                            <button type="submit" class="btnRegister" />Cadastrar</button>
	                        </div>
	                    </div>
	                </div>
	                <!-- PJ --> 
			</form>
		</div>
	</div>
</div>



<script>
$(document).ready(function(){
	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		var target = $(e.target).attr("href");
		if(target == "#pf"){
			$("#tipoCadastro").val("PF");
			
			$("#pf :input").attr("required", "");
			$("#pj :input").val("").removeAttr("required");
		} else if(target == "#pj"){
			$("#tipoCadastro").val("PJ");

			$("#pj :input").attr("required", "");
			$("#pf :input").val("").removeAttr("required");
		}
	});
});
</script>
</t:wrapper>