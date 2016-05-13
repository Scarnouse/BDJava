package InsertarDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Modelo.Usuario;

public class InsertarListaUsuarios {
	
private static Statement sentencia;
	
	public static void insertarUsuario(Connection c, List<Usuario> lista){
		
		String sql = "";
		
		for (Usuario usuario : lista) {
			sql = "INSERT INTO USUARIO VALUES (null,'"+usuario.getNombre()+"',"+(usuario.getEdad())+")";
			try {
				sentencia = c.createStatement();
				sentencia.executeUpdate(sql);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
