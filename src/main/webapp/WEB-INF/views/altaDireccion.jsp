<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Nueva direccion</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
 
    <div class="generic-container">
    <div class="well lead">Nueva direccion</div>
    <form:form method="POST" modelAttribute="direccion" class="form-horizontal">
        <form:input type="hidden" path="idDireccion" id="idDireccion"/>
         
         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="calle">Calle</label>
                <div class="col-md-7">
                    <c:choose>
                        <c:when test="${edit}">
                            <form:input type="text" path="calle" id="calle" class="form-control input-sm" disabled="true"/>
                        </c:when>
                        <c:otherwise>
                            <form:input type="text" path="calle" id="calle" class="form-control input-sm" />
                            <div class="has-error">
                                <form:errors path="calle" class="help-inline"/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
         
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="numero">Numero</label>
                <div class="col-md-7">
                    <form:input type="text" path="numero" id="numero" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="numero" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
 
       <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="piso">Piso</label>
                <div class="col-md-7">
                    <form:input type="text" path="piso" id="piso" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="piso" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="departamento">Departamento</label>
                <div class="col-md-7">
                    <form:input type="text" path="departamento" id="departamento" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="departamento" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        
         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="codigoPostal">Codigo postal</label>
                <div class="col-md-7">
                    <form:input type="text" path="codigoPostal" id="codigoPostal" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="codigoPostal" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="localidad">Localidades</label>
					<div class="col-md-7">

						<form:select path="localidad.idLocalidad">
							<form:options items="${localidades}" itemValue="idLocalidad"
								itemLabel="nombreLocalidad" class="form-control input-sm" />
						</form:select>
						
							<form:errors path="localidad" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Modificar" class="btn btn-primary btn-sm"/> or <a
 
href="<c:url value='/listaDirecciones' />">Cancelar</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Aceptar" class="btn btn-primary btn-sm"/> or <a
 
href="<c:url value='/listaDirecciones' />">Cancelar</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
    </div>
</body>
</html>