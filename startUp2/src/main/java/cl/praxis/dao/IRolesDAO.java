package cl.praxis.dao;

import java.util.List;

import cl.praxis.model.RolesDTO;
import cl.praxis.model.Roles_usuariosDTO;


public interface IRolesDAO {
	List<RolesDTO> read();
	void create(Roles_usuariosDTO p);
	int idAdmin();
	int userRol(int userId);
}
