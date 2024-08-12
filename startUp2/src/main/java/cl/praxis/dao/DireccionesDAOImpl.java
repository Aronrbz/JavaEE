package cl.praxis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cl.praxis.conexion.Conexion;
import cl.praxis.model.DireccionesDTO;

public class DireccionesDAOImpl implements IDireccionesDAO{

	@Override
	public void create(DireccionesDTO p) {
		try {
			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "insert into direcciones (nombre, numeracion, usuario_id) values "
					+ "('" + p.getNombre() + "','" + p.getNumeracion() + "','" + p.getUsuario_id() + "')";

			ResultSet re = s.executeQuery(sql);
			
		} catch (SQLException e) {
			System.out.println(" create(DireccionesDTO p)");
			e.printStackTrace();
		}
		
	}

}
