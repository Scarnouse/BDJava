package InsertarDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Modelo.Usuario;

public class IntertarDatos {
	
	private static Statement sentencia;
	
	public static void insertarUsuario(Connection c, Usuario u){
		String sql = "INSERT INTO USUARIO VALUES (null,'"+u.getNombre()+"',"+(u.getEdad())+")";
		try {
			sentencia = c.createStatement();
			sentencia.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
