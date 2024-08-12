<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="cl.praxis.model.Proveedor" %>
<%@ page import="cl.praxis.dao.ProveedorDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Proveedor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h1 class="text-center">Editar Proveedor</h1>
        
        <%
            String idStr = request.getParameter("id");
            int id = Integer.parseInt(idStr);
            ProveedorDAO proveedorDAO = new ProveedorDAO();
            Proveedor proveedor = proveedorDAO.obtenerProveedorPorId(id);
        %>

        <form method="post" action="MainServlet?action=update">
            <input type="hidden" name="id" value="<%= proveedor.getId() %>">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre:</label>
                <input type="text" id="nombre" name="nombre" class="form-control" value="<%= proveedor.getNombre() %>" required>
            </div>

            <div class="mb-3">
                <label for="rut" class="form-label">RUT:</label>
                <input type="text" id="rut" name="rut" class="form-control" value="<%= proveedor.getRut() %>" required>
            </div>

            <div class="mb-3">
                <label for="direccion" class="form-label">Dirección:</label>
                <input type="text" id="direccion" name="direccion" class="form-control" value="<%= proveedor.getDireccion() %>" required>
            </div>

            <div class="mb-3">
                <label for="correo" class="form-label">Correo:</label>
                <input type="email" id="correo" name="correo" class="form-control" value="<%= proveedor.getCorreo() %>" required>
            </div>

            <div class="mb-3">
                <label for="telefono" class="form-label">Teléfono:</label>
                <input type="text" id="telefono" name="telefono" class="form-control" value="<%= proveedor.getTelefono() %>" required>
            </div>

            <div class="mb-3">
                <label for="contacto" class="form-label">Contacto:</label>
                <input type="text" id="contacto" name="contacto" class="form-control" value="<%= proveedor.getContacto() %>" required>
            </div>

            <div class="mb-3">
                <label for="telefono_contacto" class="form-label">Teléfono de Contacto:</label>
                <input type="text" id="telefono_contacto" name="telefono_contacto" class="form-control" value="<%= proveedor.getTelefonoContacto() %>" required>
            </div>

            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
        </form>
        
        <div class="mt-3">
            <a href="index.jsp" class="btn btn-secondary">Cancelar</a>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
