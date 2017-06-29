<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmacion de alta de envío</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="generic-container">
		<div class="alert alert-success lead">${success}</div>

      <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Total a pagar </span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Importe Base</th>
                        <th>Alojamiento</th>
                        <th>Comidas</th>
                        <th>Conmbustible</th>
                        <th>Peajes</th>
                        <th>Aduana</th>
                        <th>Total</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${importe.basico}</td>
                        <td>${importe.alojamiento}</td>
                        <td>${importe.comidas}</td>
                        <td>${importe.combustible}</td>
                        <td>${importe.peajes}</td>
                        <td>${importe.aduana}</td>
                        <td>${envio.importe}</td>
                    </tr>
                </tbody>
            </table>
        </div>
		<div class="texto-derecha">
			<a class="btn btn-primary btn-default"
				href="<c:url value='/listaEnvios' />">Volver a Envíos</a>
		</div>
	</div>
</body>

</html>