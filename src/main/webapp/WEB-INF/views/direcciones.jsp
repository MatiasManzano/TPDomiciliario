<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Direcciones</title>
     <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
    <div class="generic-container">
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Direcciones </span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Calle</th>
                        <th>Numero</th>
                        <th>Piso</th>
                        <th>Departamento</th>
                        <th>CP</th>
                        <th>Localidad</th>
                        <th>Provincia</th>
                        <th>Pais</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${direcciones}" var="direccion">
                    <tr>
                        <td>${direccion.calle}</td>
                        <td>${direccion.numero}</td>
                        <td>${direccion.piso}</td>
                        <td>${direccion.departamento}</td>
                        <td>${direccion.codigoPostal}</td>
                        <td>${direccion.localidad.nombreLocalidad}</td>
                        <td>${direccion.localidad.provincia.nombreProvincia}</td>
                        <td>${direccion.localidad.provincia.pais.nombrePais}</td>
                        <td><a href="<c:url value='/edit-direccion-${direccion.idDireccion}' />" class="btn btn-success 
 
custom-width">Editar</a></td>
                        <td><a href="<c:url value='/delete-direccion-${direccion.calle}' />" class="btn btn-danger 
 
custom-width">Eliminar</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="well">
            <a href="<c:url value='/nuevaDireccion' />">Nueva direccion</a>
        </div>
    </div>
</body>
</html>