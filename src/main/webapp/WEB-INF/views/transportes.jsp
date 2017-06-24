<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Transportes</title>
     <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
    <div class="generic-container">
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Transportes </span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Tipo</th>
                        <th>Marca</th>
                        <th>Patente</th>
                        <th>Modelo</th>
                        <th>Color</th>
                        <th>Año</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${transportes}" var="transporte">
                    <tr>
                        <td>${transporte.tipo}</td>
                        <td>${transporte.marca}</td>
                        <td>${transporte.patente}</td>
                        <td>${transporte.modelo}</td>
                        <td>${transporte.color}</td>
                        <td>${transporte.anio}</td>
                        <td><a href="<c:url value='/edit-user-${transporte.patente}' />" class="btn btn-success 
 
custom-width">editar</a></td>
                        <td><a href="<c:url value='/delete-user-${transporte.patente}' />" class="btn btn-danger 
 
custom-width">eliminar</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="well">
            <a href="<c:url value='/newuser' />">Nuevo Transporte</a>
        </div>
    </div>
</body>
</html>