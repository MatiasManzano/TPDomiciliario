<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Nuevo plan de Envio</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

</head>
 
<body>
 
    <div class="generic-container" overflow="auto">
    <div class="well lead">Nuevo plan de Envio</div>
    
    <form:form method="POST" modelAttribute="envio" class="form-horizontal" id="envio">
        <form:input type="hidden" path="numeroEnvio" id="numeroEnvio"/>
         
          <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="calle">Calle</label>
                <div class="col-md-7">
                    <form:input type="text" path="calle" id="calle" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="calle" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="numero">Numero</label>
                <div class="col-md-7">
                    <form:input type="text" path="numero" id="numero" class="form-control input-sm"/>
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
                    <form:input type="text" path="piso" id="piso" class="form-control input-sm" />
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
					<label class="col-md-3 control-lable" for="localidad">Ciudad</label>
					<div class="col-md-2">

						<form:select class="form-control" path="localidad.idLocalidad">
							<form:options items="${localidades}" itemValue="idLocalidad"
 								itemLabel="nombreLocalidad" class="form-control input-sm" /> 
						</form:select> 
						<div class="has-error">
							<form:errors path="localidad" class="help-inline" /> 
					</div> 
					</div>
				</div> 
			</div> 
			
		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="paquete">Descripcion del paquete</label>
                <div class="col-md-7">
                    <form:input type="text" path="paquete" id="paquete" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="paquete" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="categoriaPaquete">Categoria</label>
					<div class="col-md-2">

						<form:select class="form-control" path="categoriaPaquete.idCategoriaPaquete">
							<form:options items="${categoriasPaquete}" itemValue="idCategoriaPaquete"
 								itemLabel="descripcion" class="form-control input-sm" /> 
						</form:select> 
						<div class="has-error">
							<form:errors path="categoriaPaquete" class="help-inline" /> 
					</div> 
					</div>
				</div> 
			</div>

			<div class="row" id="nroCertificacion">
				<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="nroCertificacion">N° Certificacíon</label>
					<div class="col-md-7">
						<form:input type="text" path="nroCertificacion" id="nroCertificacion"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="nroCertificacion" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="tipoPaquete">Tipo</label>
					<div class="col-md-2">

						<form:select class="form-control" path="tipoPaquete.idTipoPaquete">
							<form:options items="${tiposPaquete}" itemValue="idTipoPaquete"
								itemLabel="descripcion" class="form-control input-sm" />
						</form:select>
						<div class="has-error">
							<form:errors path="tipoPaquete" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			
         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="peso">Peso</label>
                <div class="col-md-2">
                    <form:input type="text" path="peso" id="peso" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="peso" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        
         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="cantidad">Cantidad</label>
                <div class="col-md-7">
                    <form:input type="text" path="cantidad" id="cantidad" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="cantidad" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
         
         <div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="transporte">Transporte</label>
					<div class="col-md-2">

						<form:select class="form-control" path="transporte.idTransporte">
							<form:options items="${transportes}" itemValue="idTransporte"
 								itemLabel="tipo" class="form-control input-sm" /> 
						</form:select> 
						<div class="has-error">
							<form:errors path="transporte" class="help-inline" /> 
					</div> 
					</div>
				</div> 
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="remitente">Su nombre</label>
					<div class="col-md-7">
						<form:input type="text" path="remitente" id="remitente"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="remitente" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="destinatario">Destinatario</label>
					<div class="col-md-7">
						<form:input type="text" path="destinatario" id="destinatario"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="destinatario" class="help-inline" />
						</div>
					</div>
				</div>
			</div>			
			
			<div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Modificar" class="btn btn-primary btn-sm"/> or <a
 
href="<c:url value='/listaEnvios' />">Cancelar</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Aceptar" class="btn btn-primary btn-sm"/> or <a
 
href="<c:url value='/listaEnvios' />">Cancelar</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
		</form:form>
    </div>
</body>
</html>