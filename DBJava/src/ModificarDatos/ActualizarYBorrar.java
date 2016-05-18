package ModificarDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarYBorrar {
	
	private static PreparedStatement sentencia;
	
	public static int setNombre(Connection c, String nombreNuevo, String nombreViejo){
		int datosAfectados = 0;	
		try {
			String sql = "UPDATE usuario SET nombre=? WHERE nombre=?";
			sentencia = c.prepareStatement(sql);
			sentencia.setString(1, nombreNuevo);
			sentencia.setString(2, nombreViejo);
			datosAfectados = sentencia.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return datosAfectados;
	}
	
	public static int borrarUsuario(Connection c, String nombre){
		int datosAfectados = 0;	
		try {
			String sql = "DELETE FROM usuario WHERE nombre=?";
			sentencia = c.prepareStatement(sql);
			sentencia.setString(1, nombre);
			datosAfectados = sentencia.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return datosAfectados;
	}
}
