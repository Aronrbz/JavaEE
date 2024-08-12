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
        <h1 class="text-center">Error en la Operación</h1>
        <div class="alert alert-danger mt-4">
            <strong>Hubo un error al procesar su solicitud. Asegúrese de ingresar números enteros válidos.</strong>
        </div>
        <div class="text-center">
            <a href="index.jsp" class="btn btn-primary">Volver al formulario</a>
        </div>
    </div>

    <!-- Incluyendo el archivo footer.jsp -->
    <%@ include file="/assets/html/footer.jsp" %>
</body>
</html>
