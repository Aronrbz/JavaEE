<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="cl.praxis.model.Proveedor" %>
<%@ page import="cl.praxis.dao.ProveedorDAO" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Proveedores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h1 class="text-center">Registro de Proveedores</h1>
        
        <!-- Formulario de registro -->
        <form method="post" action="MainServlet">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre:</label>
                <input type="text" id="nombre" name="nombre" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="rut" class="form-label">RUT:</label>
                <input type="text" id="rut" name="rut" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="direccion" class="form-label">Dirección:</label>
                <input type="text" id="direccion" name="direccion" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="correo" class="form-label">Correo:</label>
                <input type="email" id="correo" name="correo" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="telefono" class="form-label">Teléfono:</label>
                <input type="text" id="telefono" name="telefono" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="contacto" class="form-label">Contacto:</label>
                <input type="text" id="contacto" name="contacto" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="telefono_contacto" class="form-label">Teléfono de Contacto:</label>
                <input type="text" id="telefono_contacto" name="telefono_contacto" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary">Registrar Proveedor</button>
        </form>

        <div class="mt-5">
            <h2>Lista de Proveedores Registrados</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>RUT</th>
                        <th>Dirección</th>
                        <th>Correo</th>
                        <th>Teléfono</th>
                        <th>Contacto</th>
                        <th>Teléfono Contacto</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ProveedorDAO proveedorDAO = new ProveedorDAO();
                        List<Proveedor> listaProveedores = proveedorDAO.obtenerProveedores();
                        for (Proveedor proveedor : listaProveedores) {
                    %>
                    <tr>
                        <td><%= proveedor.getId() %></td>
                        <td><%= proveedor.getNombre() %></td>
                        <td><%= proveedor.getRut() %></td>
                        <td><%= proveedor.getDireccion() %></td>
                        <td><%= proveedor.getCorreo() %></td>
                        <td><%= proveedor.getTelefono() %></td>
                        <td><%= proveedor.getContacto() %></td>
                        <td><%= proveedor.getTelefonoContacto() %></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
