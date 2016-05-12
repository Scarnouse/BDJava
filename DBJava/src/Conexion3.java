import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Conexion3 {
	
	private static Connection conexion3;
	
	private Conexion3 () {} ;
	
	public static Connection getConexion3() {
		//Patron singleton
		//no permite crear más de un objeto
		
		if (conexion3==null){
			ResourceBundle rb = ResourceBundle.getBundle("sqlite");
			String url = rb.getString("url");
			String driver = rb.getString("driver");
			try {
				//carga del driver
				Class.forName(driver);
				//carga de url
				conexion3 = DriverManager.getConnection(url);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conexion3;
	}
	
	public static void main(String[] args) {
		Connection c = Conexion3.getConexion3();
		System.out.println(c);
		Connection c1 = Conexion3.getConexion3();
		System.out.println(c1);
	}

}