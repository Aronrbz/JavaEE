package cl.praxis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.conexion.Conexion;
import cl.praxis.model.RolesDTO;
import cl.praxis.model.Roles_usuariosDTO;
import cl.praxis.model.UsuarioDTO;

public class RolesDAOImpl implements IRolesDAO{

	@Override
	public List<RolesDTO> read() {
		List<RolesDTO> rolesDTO = new ArrayList<RolesDTO>();

		try {
			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "select id, nombre from roles order by nombre asc";

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {

				rolesDTO.add(new RolesDTO(rs.getInt("id"), rs.getString("nombre")));

			}

		} catch (SQLException e) {
			System.out.println(" List<RolesDTO> read()");
			e.printStackTrace();
		}
		return rolesDTO;
	}

	@Override
	public void create(Roles_usuariosDTO p) {
		try {
			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "insert into roles_usuarios ( usuario_id,  roles_id) values "
					+ "('" + p.getUsuario_id() + "','" + p.getRoles_id() + "')";

			ResultSet re = s.executeQuery(sql);
			
		} catch (SQLException e) {
			System.out.println("create(Roles_usuariosDTO p)");
			e.printStackTrace();
		}
		
	}

	@Override
	public int idAdmin() {
		int admin =0;
		RolesDTO p = null;
		try {
			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "select id, nombre from roles where nombre = 'Administrador'";

			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				p = new RolesDTO(rs.getInt("id"),rs.getString("nombre"));
			}
			System.out.println("RolEncontrado"+p.getId()+" "+p.getNombre());
			admin = p.getId();
			
		} catch (SQLException e) {
			System.out.println("idAdmin()");
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public int userRol(int userId) {
		int admin =0;
		Roles_usuariosDTO p = null;
		try {
			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "select usuario_id, roles_id from roles_usuarios where usuario_id = '"+userId+"'";
			System.out.println(sql);
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				p = new Roles_usuariosDTO(rs.getInt("usuario_id"),rs.getInt("roles_id"));
			}
			System.out.println("RoldelUser"+ p.getRoles_id());
			admin = p.getRoles_id();
			
		} catch (SQLException e) {
			System.out.println("userRol(int userId)");
			e.printStackTrace();
		}
		return admin;
	}

}
