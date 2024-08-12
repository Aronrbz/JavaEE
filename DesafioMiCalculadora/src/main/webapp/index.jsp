<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <%@ include file="assets/html/head.jsp" %>
</head>
<body class="bg-light">
    <%@ include file="assets/html/header.jsp" %>
    <div class="container mt-5">
        <h1 class="text-center">Calculadora</h1>
        <form method="post" action="MainServlet" class="mt-4">
            <div class="mb-3">
                <label for="numero1" class="form-label">Número 1:</label>
                <input type="text" class="form-control" id="numero1" name="numero1" required>
            </div>
            <div class="mb-3">
                <label for="numero2" class="form-label">Número 2:</label>
                <input type="text" class="form-control" id="numero2" name="numero2" required>
            </div>
            <div class="mb-3">
                <label for="operacion" class="form-label">Operación:</label>
                <select class="form-select" id="operacion" name="operacion" required>
                    <option value="suma">Suma</option>
                    <option value="resta">Resta</option>
                    <option value="multiplicacion">Multiplicación</option>
                    <option value="division">División</option>
                    <option value="ordenar">Ordenar</option>
                    <option value="paridad">Par e Impar</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Calcular</button>
        </form>
    </div>
    <%@ include file="assets/html/footer.jsp" %>
</body>
</html>
