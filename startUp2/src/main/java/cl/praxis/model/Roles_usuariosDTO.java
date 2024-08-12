package cl.praxis.model;

public class Roles_usuariosDTO {
private int usuario_id;
private int roles_id;
public Roles_usuariosDTO() {
	super();
}
public Roles_usuariosDTO(int usuario_id, int roles_id) {
	super();
	this.usuario_id = usuario_id;
	this.roles_id = roles_id;
}
public int getUsuario_id() {
	return usuario_id;
}
public void setUsuario_id(int usuario_id) {
	this.usuario_id = usuario_id;
}
public int getRoles_id() {
	return roles_id;
}
public void setRoles_id(int roles_id) {
	this.roles_id = roles_id;
}

}
