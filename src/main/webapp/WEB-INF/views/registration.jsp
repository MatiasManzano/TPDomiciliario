<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Alta de transportes</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
 
    <div class="generic-container">
    <div class="well lead">Alta de transportes</div>
    <form:form method="POST" modelAttribute="transporte" class="form-horizontal">
        <form:input type="hidden" path="idTransporte" id="idTransporte"/> <!-- cambiar por idTransporte -->
         
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="tipo">Tipo de transporte</label>
                <div class="col-md-7">
                    <form:input type="text" path="tipo" id="tipo" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="tipo" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="marca">Marca</label>
                <div class="col-md-7">
                    <form:input type="text" path="marca" id="marca" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="marca" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="patente">Patente</label>
                <div class="col-md-7">
                    <c:choose>
                        <c:when test="${edit}">
                            <form:input type="text" path="patente" id="patente" class="form-control 
 
input-sm" disabled="true"/>
                        </c:when>
                        <c:otherwise>
                            <form:input type="text" path="patente" id="patente" class="form-control 
 
input-sm" />
                            <div class="has-error">
                                <form:errors path="patente" class="help-inline"/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="modelo">Modelo</label>
                <div class="col-md-7">
                    <form:input type="text" path="modelo" id="modelo" class="form-control input-sm"
 
/>
                    <div class="has-error">
                        <form:errors path="modelo" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="color">Color</label>
                <div class="col-md-7">
                    <form:input type="text" path="color" id="color" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="color" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        
         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="anio">Año</label>
                <div class="col-md-7">
                    <form:input type="text" path="anio" id="anio" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="anio" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
 
<!--         <div class="row"> -->
<!--             <div class="form-group col-md-12"> -->
<!--                 <label class="col-md-3 control-lable" for="userProfiles">Roles</label> -->
<!--                 <div class="col-md-7"> -->
<%--                     <form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" --%>
 
<%-- itemLabel="type" class="form-control input-sm" /> --%>
<!--                     <div class="has-error"> -->
<%--                         <form:errors path="userProfiles" class="help-inline"/> --%>
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
 
        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
 
href="<c:url value='/list' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
 
href="<c:url value='/list' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
    </div>
</body>
</html>