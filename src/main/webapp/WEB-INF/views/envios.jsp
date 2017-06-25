<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Planes de Envio</title>
     <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
    <div class="generic-container">
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Planes de Envio</span></div>
            <table class="table table-hover">
                <thead>
                    <tr><th>Origen</th>
                        <th>Destino</th>
                        <th>Descripcion del Paquete</th>
                        <th>Categoria del paquete</th>
                        <th>Tipo de paquete</th>
                        <th>Peso</th>
                        <th>Cantidad</th>
                        <th>Transporte</th>
                        <th>Destinatario</th>
                        <th>Fecha de envio</th>
                        <th>Fecha de entrega</th>
                        <th>Importe</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${envios}" var="envio">
                    <tr>
                        <td>${envio.direccionOrigen.calle} ${envio.direccionOrigen.numero} </td>
                        <td>${envio.direccionDestino.calle} ${envio.direccionDestino.numero}</td>
                        <td>${envio.paquete.descripcion}</td>
                        <td>${envio.paquete.categoriaPaquete.descripcion}</td>
                        <td>${envio.paquete.tipoPaquete.descripcion}</td>
                        <td>${envio.peso}</td>
                         <td>${envio.cantidad}</td>
                        <td>${envio.transporte.tipo}</td>
                        <td>${envio.destinatario}</td>
                        <td>${envio.fechaEnvio}</td>
                        <td>${envio.fechaEntrega}</td>
                        <td>${envio.importe}</td>
                        
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
            <a href="<c:url value='/nuevaDireccion' />">Nuevo Envio</a>
        </div>
    </div>
</body>
</html>