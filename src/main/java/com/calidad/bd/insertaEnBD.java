package com.calidad.bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.calidad.ws.rest.vo.VOEjercicio;

public class insertaEnBD {

	public void InsertarEjercicio(VOEjercicio objEjercicio) throws IOException {


		PreparedStatement ps = null;
		Connection conn = null;
		String insertTableSQL = "INSERT INTO Taller.Ejercicio"
				+ "(pregunta,ejercicio,tipo) VALUES"
				+ "(?,?,?)";

		try {

			ConexionBD conexion = new ConexionBD();
			conn = conexion.getConnection();
			ps = conn.prepareStatement(insertTableSQL);

			ps.setString(1, objEjercicio.getPregunta());
			ps.setString(2, objEjercicio.getCodigo());
			ps.setString(3, "tipo desde java");

			// execute insert SQL stetement
			ps.executeUpdate();

			System.out.println("Record is inserted into DBUSER table!");


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}finally{
			if (conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
}
