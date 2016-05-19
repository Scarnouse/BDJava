package Trigger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TriggerBorrado {
	
	private static Statement sentencia;
	
	public static void triggerBorrado(Connection c){
		
		String sql = "CREATE TABLE IF NOT EXISTS historial ("
				+"id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+"nombre TEXT,"
				+"edad INTEGER,"
				+"fecha_baja DATE"
				+ "); ";
		String sql2 = "CREATE TRIGGER IF NOT EXISTS borrado BEFORE DELETE "
				+"ON usuario "
				+"BEGIN "
				+"INSERT INTO historial (nombre, edad, fecha_baja) VALUES (old.nombre, old.edad, datetime('now'));"
				+"END";
		try {
			sentencia = c.createStatement();
			sentencia.addBatch(sql);
			sentencia.addBatch(sql2);
			sentencia.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
