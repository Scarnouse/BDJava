import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Conexion4 {
	
	private static Connection conexion4;
	
	private Conexion4 () {} ;
	
	public static Connection getConexion4() {
		//Patron singleton
		//no permite crear más de un objeto

		if (conexion4==null){
			Runtime.getRuntime().addShutdownHook(new MiShutdown());
			ResourceBundle rb = ResourceBundle.getBundle("sqlite");
			String url = rb.getString("url");
			String driver = rb.getString("driver");
			try {
				//carga del driver
				Class.forName(driver);
				//carga de url
				conexion4 = DriverManager.getConnection(url);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conexion4;
	}
	
	static class MiShutdown extends Thread{
		@Override
		public void run() {
			Connection con = Conexion4.getConexion4();
		    if (con!=null){
		    	try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		    }
		}
	}
	
	public static void main(String[] args) {
		Connection c = Conexion4.getConexion4();
		System.out.println(c);
	}

}