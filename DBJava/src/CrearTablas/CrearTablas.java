package CrearTablas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTablas {
	private static Statement sentencia;
	public static  void crearTablaUsuario(Connection con){
		//String sql0 = "DROP TABLE IF NOT EXISTS USUARIO";
		String sql1 = "CREATE TABLE IF NOT EXISTS USUARIO ("
				+ "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "NOMBRE TEXT,"
				+ "EDAD INTEGER)";
		try {
			sentencia = con.createStatement();
			//sentencia.executeUpdate(sql0);
			sentencia.executeUpdate(sql1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}
}

