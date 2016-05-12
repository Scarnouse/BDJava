import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Conexion2 {
	
	public static Connection conexion2;
	
	public static Connection getConexion2() {
		ResourceBundle rb = ResourceBundle.getBundle("sqlite");
		String url = rb.getString("url");
		String driver = rb.getString("driver");
		try {
			//carga del driver
			Class.forName(driver);
			//carga de url
			conexion2 = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conexion2;
	}
	
	public static void main(String[] args) {
		Connection c = Conexion2.getConexion2();
	}

}
