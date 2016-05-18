package Consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Usuario;

public class ObtenerResultados {

	private static Statement sentencia;
	private static PreparedStatement sentenciaPreparada;
	
	public static List<Usuario> obtenerTodos (Connection c){
		List<Usuario> nuevaLista = new ArrayList<Usuario>();
		try {
			sentencia = c.createStatement();
			String sql = "SELECT * FROM usuario";
			ResultSet resultado = sentencia.executeQuery(sql);
			while(resultado.next()){
					nuevaLista.add(new Usuario(resultado.getString("nombre"), resultado.getInt("edad")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nuevaLista;
		
	}
	
	public static List<Usuario> obtenerResultadosPorEdad(Connection c, int edad){
		List<Usuario> nuevaLista = new ArrayList<Usuario>();
		try {
			String sql = "SELECT * FROM usuario WHERE edad<?";
			sentenciaPreparada = c.prepareStatement(sql);
			sentenciaPreparada.setInt(1, edad);
			ResultSet resultado = sentenciaPreparada.executeQuery();

			while(resultado.next()){
				nuevaLista.add(new Usuario(resultado.getString("nombre"), resultado.getInt("edad")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nuevaLista;
	}
	
}
