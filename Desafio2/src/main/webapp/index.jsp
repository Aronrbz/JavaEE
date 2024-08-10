<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="cl.praxis.model.Habitacion" %>
<%@ page import="cl.praxis.business.HabitacionBusiness" %>

<%@ include file="assets/html/head.jsp" %>
<%@ include file="assets/html/header.jsp" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <title>Reserva de Habitación</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/styles.css">
</head>
<body>
    <div class="container">
        <h1 class="text-center">Formulario de Reserva</h1>
        <div class="row">
            <%
                HabitacionBusiness habitacionBusiness = new HabitacionBusiness();
                List<Habitacion> habitaciones = habitacionBusiness.getHabitaciones();
                for (Habitacion habitacion : habitaciones) {
            %>
            <div class="col-md-4 mb-4">
                <div class="card">
                    <img src="assets/img/habitacion.jpg" class="card-img-top" alt="<%= habitacion.getNombre() %>">
                    <div class="card-body">
                        <h5 class="card-title"><%= habitacion.getNombre() %></h5>
                        <p class="card-text"><%= habitacion.getDescripcion() %></p>
                        <p class="card-text"><strong>CLP <%= habitacion.getPrecio() %></strong></p>
                        <input type="radio" name="idhabitacion" value="<%= habitacion.getId() %>"> Seleccionar
                    </div>
                </div>
            </div>
            <%
                }
            %>
        </div>
        <form method="post" action="procesa.jsp">
            <h2 class="mt-5">Información de Reserva Habitación</h2>
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>
            <div class="form-group">
                <label for="apellido">Apellido:</label>
                <input type="text" class="form-control" id="apellido" name="apellido" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="medio_pago">Medio de Pago:</label>
                <select id="medio_pago" name="medio_pago" class="form-control">
                    <option value="Contado">Contado</option>
                    <option value="Tarjeta">Tarjeta</option>
                    <option value="Transferencia">Transferencia</option>
                </select>
            </div>
            <div class="form-group">
                <label for="dias">Número de Días:</label>
                <input type="number" class="form-control" id="dias" name="dias" min="1" required>
            </div>
            <div class="form-group">
                <label for="fecha_entrada">Fecha de Entrada:</label>
                <input type="date" class="form-control" id="fecha_entrada" name="fecha_entrada" required>
            </div>
            <button type="submit" class="btn btn-primary mt-3">Enviar Solicitud de Reserva</button>
        </form>
    </div>

    <%@ include file="assets/html/footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
