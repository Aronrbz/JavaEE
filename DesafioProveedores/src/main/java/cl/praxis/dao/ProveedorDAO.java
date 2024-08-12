package cl.praxis.dao;

import cl.praxis.db.DatabaseConnection;
import cl.praxis.model.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    public List<Proveedor> obtenerProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedores ORDER BY nombre ASC";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId(rs.getInt("id"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setRut(rs.getString("rut"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setCorreo(rs.getString("correo"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setContacto(rs.getString("contacto"));
                proveedor.setTelefonoContacto(rs.getString("telefono_contacto"));
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedores;
    }
}
