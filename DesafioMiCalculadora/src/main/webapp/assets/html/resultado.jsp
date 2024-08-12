<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <!-- Incluyendo el archivo head.jsp -->
    <%@ include file="/assets/html/head.jsp" %>
</head>
<body class="bg-light">
    <!-- Incluyendo el archivo header.jsp -->
    <%@ include file="/assets/html/header.jsp" %>

    <!-- Contenido principal de la página -->
    <div class="container mt-5">
        <h1 class="text-center">Resultado de la Operación</h1>
        <div class="alert alert-success mt-4">
            <strong><%= request.getAttribute("resultado") %></strong>
        </div>
        <div class="text-center">
            <a href="index.jsp" class="btn btn-primary">Volver al formulario</a>
        </div>
    </div>

    <!-- Incluyendo el archivo footer.jsp -->
    <%@ include file="/assets/html/footer.jsp" %>
</body>
</html>
