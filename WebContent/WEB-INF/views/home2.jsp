<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper title="Início">
<form method="GET" action="SearchImovel">

<!DOCTYPE html>
<html lang="en">
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
<style>
body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
body {font-size:16px;}
.w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
.w3-half img:hover{opacity:1}
</style>
<body>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Menu</a>
  <div class="w3-container">
    <h3 class="w3-padding-64" href="/Achei/"><b>Achei<br>Imóveis!</b></h3>
  </div>
  <p>VENDA</p>
  <a href="${pageContext.request.contextPath}/SearchImovel?tipoNegocio=${tipoNegocio}&tipoImovel=ap" class="nav-link <c:if test="${tipoImovel == 'ap'}">active</c:if>">🏢APARTAMENTOS</a>
  <a href="${pageContext.request.contextPath}/SearchImovel?tipoNegocio=${tipoNegocio}&tipoImovel=ca" class="nav-link <c:if test="${tipoImovel == 'ca'}">active</c:if>">🏠CASAS</a>
  <p>Aluguel</p>
  <a href="${pageContext.request.contextPath}/SearchImovel?tipoNegocio=${tipoNegocio}&tipoImovel=ap" class="nav-link <c:if test="${tipoImovel == 'ap'}">active</c:if>">🏢APARTAMENTOS</a>
  <a href="${pageContext.request.contextPath}/SearchImovel?tipoNegocio=${tipoNegocio}&tipoImovel=ca" class="nav-link <c:if test="${tipoImovel == 'ca'}">active</c:if>">🏠CASAS</a>
</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-red w3-xlarge w3-padding">
  <a href="javascript:void(0)" class="w3-button w3-red w3-margin-right" onclick="w3_open()">☰</a>
  <span>Imóveis!</span>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:340px;margin-right:40px">

  <!-- Header -->
  <div class="w3-container" style="margin-top:80px" id="showcase">
    <h1 class="w3-jumbo"><b>As melhores ofertas!</b></h1>
    <h1 class="w3-xxxlarge w3-text-red"><b>Encontre aqui!</b></h1>
    <hr style="width:50px;border:5px solid red" class="w3-round">
  </div>
  
 
  <!-- Modal for full size images on click-->
  <div id="modal01" class="w3-modal w3-black" style="padding-top:0" onclick="this.style.display='none'">
    <span class="w3-button w3-black w3-xxlarge w3-display-topright">×</span>
    <div class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
      <img id="img01" class="w3-image">
      <p id="caption"></p>
    </div>
  </div>

 
 

  
<!-- End page content -->
</div>





</body>
</html>

</form>
</t:wrapper>