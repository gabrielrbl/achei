<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:wrapper title="Perfil">
<!-- LISTS -->
<style>
#Lists h2, h5 { margin-top: 0; margin-bottom: .5rem; }
#Lists h2, h5, .h2, .h5 { font-family: inherit; font-weight: 600; line-height: 1.5; margin-bottom: .5rem; color: #32325d; }
#Lists h2, .h2 { font-size: 1.25rem; }
#Lists h5, .h5 { font-size: .8125rem; }
#Lists .row { display: flex; margin-right: -15px; margin-left: -15px; flex-wrap: wrap; }
#Lists .col, .col-auto { position: relative; width: 100%; min-height: 1px; padding-right: 15px; padding-left: 15px; }
#Lists .col { max-width: 100%; flex-basis: 0; flex-grow: 1; }
#Lists .col-auto { width: auto; max-width: none; flex: 0 0 auto; }
#Lists .bg-danger { background-color: #f5365c !important; }
#Lists .rounded-circle { border-radius: 50% !important; }
#Lists .shadow { box-shadow: 0 0 2rem 0 rgba(136, 152, 170, .15) !important; }
#Lists .text-uppercase { text-transform: uppercase !important; }
#Lists .text-white { color: #fff !important; }
#Lists .text-muted { color: #8898aa !important; }
#Lists [class*='shadow'] { transition: all .15s ease; }
#Lists .icon { width: 3rem; height: 3rem; }
#Lists .icon i { font-size: 2.25rem; }
#Lists .icon-shape { display: inline-flex; padding: 12px; text-align: center; border-radius: 50%; align-items: center; justify-content: center; }
#Lists .icon-shape i { font-size: 1.25rem; }
</style>


<!-- MODAL  -->
<style>
#insertContatoModal textarea[name="contato"] { resize: none; }
#insertContatoModal #tipo { height: 45px }
#insertContatoModal #contato { height: 120px }
#insertContatoModal input.input-box { background-color: #616161; border: #616161; color: #BDBDBD }
#insertContatoModal input.input-box:focus { background-color: #000000; color: #BDBDBD }
#insertContatoModal .rm-border:focus { border-color: inherit; -webkit-box-shadow: none; box-shadow: none }
#insertContatoModal .form-control::-webkit-input-placeholder { color: #9E9E9E }
#insertContatoModal ::-moz-placeholder { color: #9E9E9E !important }
</style>

<div class="container">
	<div class="main-body">
		<nav aria-label="breadcrumb" class="main-breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Início</a></li>
				<li class="breadcrumb-item"><a href="javascript:void(0)">Usuário</a></li>
				<li class="breadcrumb-item active" aria-current="page">Perfil</li>
            </ol>
		</nav>
    
		<div class="row gutters-sm">
			<div class="col-md-4 mb-3">
            	<div class="card">
                	<div class="card-body">
                  		<div class="d-flex flex-column align-items-center text-center">
                    		<img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin" class="rounded-circle" width="150">
                    		<div class="mt-3">
	                      		<h4 style="text-transform: capitalize;">${fn:toLowerCase(usuarioLogado.nome)}</h4>
	                      		<p class="text-muted font-size-sm">${usuarioLogado.email}</p>
	                      		<button class="btn btn-primary">Editar</button>
	                      		<!-- 
	                      		<p class="text-secondary mb-1">Full Stack Developer</p>
	                      		<p class="text-muted font-size-sm">Bay Area, San Francisco, CA</p>
	                      		<button class="btn btn-primary">Follow</button>
	                      		<button class="btn btn-outline-primary">Mensagem</button> -->
	                    	</div>
                  		</div>
                	</div>
              	</div>
              <!-- 
              <div class="card mt-3">
                <ul class="list-group list-group-flush">
                  <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                    <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-globe mr-2 icon-inline"><circle cx="12" cy="12" r="10"></circle><line x1="2" y1="12" x2="22" y2="12"></line><path d="M12 2a15.3 15.3 0 0 1 4 10 15.3 15.3 0 0 1-4 10 15.3 15.3 0 0 1-4-10 15.3 15.3 0 0 1 4-10z"></path></svg>Website</h6>
                    <span class="text-secondary">https://bootdey.com</span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                    <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-github mr-2 icon-inline"><path d="M9 19c-5 1.5-5-2.5-7-3m14 6v-3.87a3.37 3.37 0 0 0-.94-2.61c3.14-.35 6.44-1.54 6.44-7A5.44 5.44 0 0 0 20 4.77 5.07 5.07 0 0 0 19.91 1S18.73.65 16 2.48a13.38 13.38 0 0 0-7 0C6.27.65 5.09 1 5.09 1A5.07 5.07 0 0 0 5 4.77a5.44 5.44 0 0 0-1.5 3.78c0 5.42 3.3 6.61 6.44 7A3.37 3.37 0 0 0 9 18.13V22"></path></svg>Github</h6>
                    <span class="text-secondary">bootdey</span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                    <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-twitter mr-2 icon-inline text-info"><path d="M23 3a10.9 10.9 0 0 1-3.14 1.53 4.48 4.48 0 0 0-7.86 3v1A10.66 10.66 0 0 1 3 4s-4 9 5 13a11.64 11.64 0 0 1-7 2c9 5 20 0 20-11.5a4.5 4.5 0 0 0-.08-.83A7.72 7.72 0 0 0 23 3z"></path></svg>Twitter</h6>
                    <span class="text-secondary">@bootdey</span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                    <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-instagram mr-2 icon-inline text-danger"><rect x="2" y="2" width="20" height="20" rx="5" ry="5"></rect><path d="M16 11.37A4 4 0 1 1 12.63 8 4 4 0 0 1 16 11.37z"></path><line x1="17.5" y1="6.5" x2="17.51" y2="6.5"></line></svg>Instagram</h6>
                    <span class="text-secondary">bootdey</span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                    <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-facebook mr-2 icon-inline text-primary"><path d="M18 2h-3a5 5 0 0 0-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 0 1 1-1h3z"></path></svg>Facebook</h6>
                    <span class="text-secondary">bootdey</span>
                  </li>
                </ul>
              </div>
                -->
			</div>
			<div class="col-md-8">
            	<div class="card mb-3">
					<div class="card-header d-flex flex-row justify-content-between pmd-card-border">
						<div>
							<h5 class="card-title">Contatos</h5>
						</div>
						<div>
							<button class="btn btn-sm pmd-btn-fab pmd-btn-flat pmd-ripple-effect btn-primary" type="button" data-toggle="modal" data-target="#insertContatoModal">
								<i class="fas fa-plus"></i>
							</button>
						</div>
					</div>
                	<div class="card-body">
                  		<c:forEach var="contato" items="${usuarioContatoList}" varStatus="loop">
							<c:if test="${loop.index != 0}"><hr></c:if>
							<div class="row">
		                    	<div class="col-sm-3">
		                    		<h6 class="mb-0">${contato.tipo}</h6>
		                    	</div>
		                    	<div class="col-sm-8 text-secondary">${contato.contato}</div>
		                    	<div class="col-sm-1">
			                    	<button class="btn btn-sm pmd-btn-fab pmd-btn-flat pmd-ripple-effect btn-danger deletar" type="button" data-id="${contato.idusuariocontato}">
										<i class="fas fa-minus"></i>
									</button>
								</div>
		                  	</div>
                  		</c:forEach>
                	</div>
				</div>
				
				<div class="card" id="Lists">
					<div class="card-body">
						<div class="row">
							<div class="col">
								<h5 class="card-title text-uppercase text-muted mb-0">Imóveis cadastrados</h5>
                      			<span class="h2 font-weight-bold mb-0">${fn:length(imoveisUsuario)}</span>
                    		</div>
                    		<div class="col-auto">
                      			<div class="icon icon-shape bg-danger text-white rounded-circle shadow">
                        			<i class="fas fa-chart-bar"></i>
                      			</div>
                    		</div>
                  		</div>
                  		<!-- <p class="mt-3 mb-0 text-muted text-sm">
                    			<span class="text-success mr-2"><i class="fa fa-arrow-up"></i> 3.48%</span>
                    			<span class="text-nowrap">Since last month</span>
                  			 </p> -->
					</div>
				</div>
			</div>
				
				
				<!-- <div class="row gutters-sm">
					<div class="col-sm-6 mb-3">
						<div class="card h-100">
							<div class="card-body">
                      			<h6 class="d-flex align-items-center mb-3"><i class="material-icons text-info mr-2">assignment</i>Project Status</h6>
                      			
								<small>Web Design</small>
		                      	<div class="progress mb-3" style="height: 5px">
									<div class="progress-bar bg-primary" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
		                      	</div>
		                      	
		                      	<small>Website Markup</small>
		                      	<div class="progress mb-3" style="height: 5px">
		                        	<div class="progress-bar bg-primary" role="progressbar" style="width: 72%" aria-valuenow="72" aria-valuemin="0" aria-valuemax="100"></div>
		                      	</div>
				                      	
		                      	<small>One Page</small>
		                      	<div class="progress mb-3" style="height: 5px">
		                        	<div class="progress-bar bg-primary" role="progressbar" style="width: 89%" aria-valuenow="89" aria-valuemin="0" aria-valuemax="100"></div>
		                      	</div>
                      
		                      	<small>Mobile Template</small>
		                      	<div class="progress mb-3" style="height: 5px">
		                        	<div class="progress-bar bg-primary" role="progressbar" style="width: 55%" aria-valuenow="55" aria-valuemin="0" aria-valuemax="100"></div>
		                      	</div>
                      
		                      	<small>Backend API</small>
		                      	<div class="progress mb-3" style="height: 5px">
		                        	<div class="progress-bar bg-primary" role="progressbar" style="width: 66%" aria-valuenow="66" aria-valuemin="0" aria-valuemax="100"></div>
		                      	</div>
                    		</div>
                  		</div>
                	</div>
                	<div class="col-sm-6 mb-3">
                  		<div class="card h-100">
                    		<div class="card-body">
                      			<h6 class="d-flex align-items-center mb-3"><i class="material-icons text-info mr-2">assignment</i>Project Status</h6>
                      			
		                      	<small>Web Design</small>
		                      	<div class="progress mb-3" style="height: 5px">
		                        	<div class="progress-bar bg-primary" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
		                      	</div>
		                      
		                      	<small>Website Markup</small>
		                      	<div class="progress mb-3" style="height: 5px">
		                        	<div class="progress-bar bg-primary" role="progressbar" style="width: 72%" aria-valuenow="72" aria-valuemin="0" aria-valuemax="100"></div>
		                      	</div>
		                      
		                      	<small>One Page</small>
		                      	<div class="progress mb-3" style="height: 5px">
		                        	<div class="progress-bar bg-primary" role="progressbar" style="width: 89%" aria-valuenow="89" aria-valuemin="0" aria-valuemax="100"></div>
		                      	</div>
		                      
		                      	<small>Mobile Template</small>
		                      	<div class="progress mb-3" style="height: 5px">
		                        	<div class="progress-bar bg-primary" role="progressbar" style="width: 55%" aria-valuenow="55" aria-valuemin="0" aria-valuemax="100"></div>
		                      	</div>
		                      
		                      	<small>Backend API</small>
		                      	<div class="progress mb-3" style="height: 5px">
		                        	<div class="progress-bar bg-primary" role="progressbar" style="width: 66%" aria-valuenow="66" aria-valuemin="0" aria-valuemax="100"></div>
		                      	</div>
                    		</div>
                  		</div>
                	</div> -->
                	
                	
                	
					<div class="modal fade" id="insertContatoModal" tabindex="-1" role="dialog" aria-labelledby="insertContatoModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content" style="background: #212529; color: #ffffff;">
					     		<div class="modal-header">
					        		<h5 class="modal-title" id="insertContatoModalLabel">Inserir novo contato</h5>
				        			<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
				          				<span aria-hidden="true">&times;</span>
				        			</button>
					      		</div>
					      		<div class="modal-body" style="background: #212529;">
						      		<form method="POST" id="newContact" action="doNewContact">
				                        <div class="form-group row mb-3">
				                            <div class="col-md-12 mb-0">
				                                <p class="mb-1">Tipo de contato</p>
				                                <input id="tipo" type="text" placeholder="Informe o tipo de contato" name="tipo" class="form-control input-box rm-border" required />
				                            </div>
				                        </div>
				                        <div class="form-group row">
				                            <div class="col-md-12 mb-2">
				                                <p class="mb-1">Contato</p>
				                                <input id="contato" type="text" placeholder="Informe o contato" name="contato" class="form-control input-box rm-border" required />
				                            </div>
				                        </div>
				                        <div class="form-group row justify-content-center mb-0">
				                            <div class="col-md-12 px-3">
				                            	<input type="submit" value="Inserir" class="btn btn-block btn-primary rm-border" />
				                            </div>
				                        </div>
			                        </form>
					      		</div>
					      		<div class="modal-footer">
					        		<button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
					      		</div>
					    	</div>
					  	</div>
					</div>
					
					<div class="modal fade" id="removeContatoModal" tabindex="-1" role="dialog" aria-labelledby="removeContatoModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
					        		<h5 class="modal-title" id="removeContatoModalLabel">Remover Contato</h5>
					        		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          			<span aria-hidden="true">&times;</span>
					        		</button>
					      		</div>
					      		<div class="modal-body">
									Tem certeza que deseja remover o Contato #<span class="idContatoremove"></span>?
					      		</div>
					      		<div class="modal-footer">
					      			<form id="formDelete" action="DeleteContato">
					      				<input type="hidden" id="idUsuarioContato" name="idUsuarioContato" />
					      				<button type="button" class="btn btn-danger btn-primary">Excluir</button>
					   				</form>
					        		<button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
					      		</div>
					    	</div>
					  	</div>
					</div>
					
					
              	</div>
            </div>
		</div>
	</div>
</div>

<script>
$(document).ready(function(){
	$("#newContact").on("submit", function(){
		alert("Contato inserido com sucesso!");
	});
	
	$(document).on("click", ".deletar", function() {
		$(".idContatoremove").html($(this).data("id"));
		$("input#idUsuarioContato").val($(this).data("id"));
		$("#removeContatoModal").modal();
	});
	
	$("#formDelete button").on("click", function(){
		$("#removeContatoModal").find("button").prop("disabled", true);
		alert("Contato removido com sucesso!");
		$("#formDelete").submit();
	});
});
</script>
</t:wrapper>