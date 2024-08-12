package cl.praxis.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cl.praxis.conexion.Conexion;

public class Conexion {

private static Connection con = null;
	
	private Conexion() {
		
		try {
			
			Class.forName("org.postgresql.Driver"); 			
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/startup", "postgres", "admin");
			
			boolean isValid = con.isValid(50000);
			
			System.out.println(isValid ? " POSTGRES TEST OK" : "POSTGRES TEST NO SO GOOD");
			
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("Error con BD: " + ex.getMessage());
		}
		
	}

	public static Connection getCon() {	
		if (con == null) {
			new Conexion();
		}
		
		return con;
	}	
}
