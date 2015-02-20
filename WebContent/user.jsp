<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html">
<html>
<head>
<title>ingresar / Modificar Estudiante</title>


<link rel="stylesheet" href="css/bootstrap.css" type="text/css" >
<script>function formulario(f) {
if (f.n1.value   >= 6) { alert ('la nota 1 es superior a 5'); 
errorMessageClass: 'help-block'
f.nombre.focus(); return false; }
if (f.n2.value   >= 6) { alert ('la nota 2 es superior a 5'); 
f.nombre.focus(); return false; }
if (f.n3.value   >= 6) { alert ('la nota 3 es superior a 5'); 
f.nombre.focus(); return false; }
if (f.n4.value   >= 6) { alert ('la nota 4 es superior a 5'); 
f.nombre.focus(); return false; }
}
</script>
</head>
<body>
<h1>Ingresar / Modificar Estudiante</h1>
<br>

<div class="container">

    <form method="POST" action='UserController' name="frmAddUser" class="form-horizontal ws-validate" onsubmit="return formulario(this)">
    <div class="form-group">
        <input type="hidden"  name="id"
            value="<c:out value="${estudiantes.id}" />" /> <br /> 
        <label for="option" class="control-label">Nombre: </label> <input class="form-control" placeholder="Nombre:" 
        type="text" name="nombre"
            value="<c:out value="${estudiantes.nombre}" />" required/> <br /> 
        <label for="option" class="control-label">Nota 1 </label> <input class="form-control" placeholder="Nota 1:"
            type="text" name="n1"
            value="<c:out value="${estudiantes.n1}" />" required/> <br /> 
        <label for="option" class="control-label">Nota 2 </label> <input class="form-control" placeholder="Nota 2:"
            type="text" name="n2" 
            value="<c:out value="${estudiantes.n2}" />" required /> <br /> 
        <label for="option" class="control-label">Nota 3 </label><input class="form-control" placeholder="Nota 3:"
            type="text" name="n3" 
            value="<c:out value="${estudiantes.n3}"/>" required /> <br />
       <label for="option" class="control-label">Nota 4 </label> <input class="form-control" placeholder="Nota 4:"
            type="text" name="n4" 
            value="<c:out value="${estudiantes.n4}" />"  required/> <br />        
        
       <input type="submit"  class="btn btn-default" value="Crear/Actualizar" />
        </div>
    </form>
    </div>
 <script src="js/jquery.js" type="text/javascript"></script>
 <script src="js/bootstrap.min.js" type="text/javascript"></script>
 <script type="text/javascript" src="http://afarkas.github.io/webshim/js-webshim/minified/polyfiller.js"></script>
 
 <script>
 (function () {
	    webshim.setOptions('forms', {
	        lazyCustomMessages: true,
	        iVal: {
	            sel: '.ws-validate',
	            handleBubble: 'hide', // hide error bubble

	            //add bootstrap specific classes
	            errorMessageClass: 'help-block',
	            successWrapperClass: 'has-success',
	            errorWrapperClass: 'has-error',

	            //add config to find right wrapper
	            fieldWrapper: '.form-group'
	        }
	    });

	    //load forms polyfill + iVal feature
	    webshim.polyfill('forms');
	})();</script>
</body>
</html>