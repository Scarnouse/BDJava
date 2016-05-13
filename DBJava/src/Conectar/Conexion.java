package Conectar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static final String DB_URL = "jdbc:sqlite:database.db";
	private static final String DRIVER = "org.sqlite.JDBC";
	
	public static Connection conexion;
	
	public static Connection getConexion() {
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(DB_URL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conexion;
	}
	
	public static void main(String[] args) {
		Connection c = Conexion.getConexion();
	}

}
