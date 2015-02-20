<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
			<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
	<link rel="stylesheet" href="css/bootstrap.css" type="text/css" >
	
	<title>Estudiantes</title>
</head>
<body >
<div class="col-lg-12 col-md-12 col-sm-12">
<div class="col-lg-10 col-md-10 col-sm-12">
<h1>Administrador Estudiantes <small>S4DS</small></h1>
<br>
<br>
<div class="row"> 
	<div class="col-md-4 text-left">
		<p class=""> Lorem ipsum dolor sit amet, consectetur adipisicing elit. Debitis aliquam sunt.</p>
			</div>
	<div class="col-md-4 text-justify">
		<p class=""> Lorem ipsum dolor sit amet, consectetur adipisicing elit. Debitis aliquam sunt.</p>
		
	</div>
	<div class="col-md-4 text-justify">
		<p class="text-capitalize"> Lorem ipsum dolor sit amet, consectetur adipisicing elit. Debitis aliquam sunt.</p>
	</div>
 </div>
<br>
<br> 

<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr class="info">
			<th>Identificacion Estudiante</th>
			<th>Nombre</th>
			<th>Nota 1</th>
			<th>Nota 2</th>
			<th>Nota 3</th>
			<th>Nota 4</th>
			<th colspan=2>Action</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${estudiantes}" var="estudiante">
		<tr>
			<td><c:out value="${estudiante.id}" /></td>
			<td><c:out value="${estudiante.nombre}" /></td>
			<td><c:out value="${estudiante.n1}" /></td>
			<td><c:out value="${estudiante.n2}" /></td>
			<td><c:out value="${estudiante.n3}" /></td>
			<td><c:out value="${estudiante.n4}" /></td>
			<td><a href="UserController?action=edit&id=<c:out value="${estudiante.id}"/>">Update</a></td>
			<td><a href="UserController?action=delete&id=<c:out value="${estudiante.id}"/>">Delete</a></td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
</div>
	<p><a class="btn btn-primary" href="UserController?action=insert">Agregar Nuevo Estudiante</a></p>
	<br>
	<br>
	<form method="GET" action='UserController?action=Consultar&id'>
		<label for="option">Buscar Estudiante </label>
		<input class="form-control" placeholder="Ingrese ID estudiante" name="id" value="<c:out value="${estudiante.id}"/>"/>
     	<input class="btn btn-primary" type="submit" value="Consultar" name="action"  />
   </form>
   <h2><span>${searchmessage}</span></h2>
   <script src="js/jquery.js" type="text/javascript"></script>
   <script src="js/bootstrap.min.js" type="text/javascript"></script>
 </div>
 </div>  
</body>
<footer> <blockquote> - Alejandro Villegas - </blockquote></footer>
</html>