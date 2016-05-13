package Conectar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.sqlite.SQLiteConfig;

import CrearTablas.CrearTablas;
import InsertarDatos.InsertarListaUsuarios;
import InsertarDatos.IntertarDatos;
import Modelo.Usuario;

public class Conexion5 {
	
	private static Connection conexion5;
	
	private Conexion5 () {} ;
	
	public static Connection getConexion5() {
		//Patron singleton
		//no permite crear más de un objeto

		if (conexion5==null){
			Runtime.getRuntime().addShutdownHook(new MiShutdown());
			ResourceBundle rb = ResourceBundle.getBundle("sqlite");
			String url = rb.getString("url");
			String driver = rb.getString("driver");
			try {
				//carga del driver
				Class.forName(driver);
				//establecemos configuarcion de SQlite particular.
				SQLiteConfig sqConfig = new SQLiteConfig();
				sqConfig.enforceForeignKeys(true);
				//carga de url
				conexion5 = DriverManager.getConnection(url,sqConfig.toProperties());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conexion5;
	}
	
	static class MiShutdown extends Thread{
		@Override
		public void run() {
			Connection con = Conexion5.getConexion5();
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
		Connection c = Conexion5.getConexion5();
		//viene de CrearTablas...
		//logica que impide la creación si el archivo existe
		CrearTablas.crearTablaUsuario(c);
		//System.out.println(c);
		IntertarDatos.insertarUsuario(conexion5, new Usuario ("pepe",23));
		Usuario[] usuarios = {new Usuario("David",8),new Usuario("Luis",65),new Usuario("Reina",32),new Usuario("Juan",83),new Usuario("Eva",13),new Usuario("Lucas",57)};
		List<Usuario> lista = Arrays.asList(usuarios);
		InsertarListaUsuarios.insertarUsuario(conexion5, lista);
	}

}