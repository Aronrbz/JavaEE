package cl.praxis.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.db.DatabaseConnection;
import cl.praxis.dao.ProveedorDAO;
import cl.praxis.model.Proveedor;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MainServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        List<Proveedor> proveedores = proveedorDAO.obtenerProveedores();
        request.setAttribute("proveedores", proveedores);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String contacto = request.getParameter("contacto");
        String telefonoContacto = request.getParameter("telefono_contacto");

        if (nombre == null || nombre.isEmpty() || rut == null || rut.isEmpty() ||
            direccion == null || direccion.isEmpty() || correo == null || correo.isEmpty() ||
            telefono == null || telefono.isEmpty() || contacto == null || contacto.isEmpty() ||
            telefonoContacto == null || telefonoContacto.isEmpty()) {

            request.setAttribute("error", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO proveedores (nombre, rut, direccion, correo, telefono, contacto, telefono_contacto) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nombre);
                statement.setString(2, rut);
                statement.setString(3, direccion);
                statement.setString(4, correo);
                statement.setString(5, telefono);
                statement.setString(6, contacto);
                statement.setString(7, telefonoContacto);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    response.sendRedirect("MainServlet"); // Redirige al servlet para mostrar la tabla actualizada
                } else {
                    request.setAttribute("error", "Error al registrar el proveedor.");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("error", "Error en la base de datos: " + e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }
    }
}
