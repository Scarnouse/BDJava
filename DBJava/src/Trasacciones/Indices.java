package Trasacciones;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Indices {
	private static Statement sentencia;
	
	public static void crearIndices(Connection c){
		try {
			c.setAutoCommit(false);
			
			String sql = "CREATE INDEX NAME ON usuario (nombre)";
			String sql2 = "CREATE INDEX AGE ON usuario (edad)";
			
			sentencia = c.createStatement();
			
			sentencia.executeUpdate(sql);
			sentencia.executeUpdate(sql2);
			
			c.commit();	
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
}
