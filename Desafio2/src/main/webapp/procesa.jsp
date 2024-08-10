<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="cl.praxis.model.Habitacion" %>
<%@ page import="cl.praxis.business.HabitacionBusiness" %>

<%@ include file="assets/html/head.jsp" %>
<%@ include file="assets/html/header.jsp" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <title>Detalle de Reserva</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Detalle Solicitud Habitación</h1>
        <%
            int idHabitacion = Integer.parseInt(request.getParameter("idhabitacion"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            String medioPago = request.getParameter("medio_pago");
            int dias = Integer.parseInt(request.getParameter("dias"));
            String fechaEntrada = request.getParameter("fecha_entrada");

            HabitacionBusiness habitacionBusiness = new HabitacionBusiness();
            Habitacion habitacion = habitacionBusiness.getHabitacionByID(idHabitacion);

            int valorPagar = habitacionBusiness.calculaValorPagar(idHabitacion, dias);
        %>
        <table class="table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Item</th>
                    <th>Valor</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Nombre</td>
                    <td><%= nombre %></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Apellido</td>
                    <td><%= apellido %></td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Email</td>
                    <td><%= email %></td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>Medio Pago</td>
                    <td><%= medioPago %></td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>Días</td>
                    <td><%= dias %></td>
                </tr>
                <tr>
                    <td>6</td>
                    <td>Fecha Entrada</td>
                    <td><%= fechaEntrada %></td>
                </tr>
                <tr>
                    <td>7</td>
                    <td>Valor Pagar</td>
                    <td>CLP <%= valorPagar %></td>
                </tr>
            </tbody>
        </table>
    </div>

    <%@ include file="assets/html/footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.amazonaws.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
