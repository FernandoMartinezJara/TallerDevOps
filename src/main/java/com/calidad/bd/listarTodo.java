package com.calidad.bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.calidad.ws.rest.vo.VOEjercicio;

public class listarTodo {
	
	ArrayList<VOEjercicio> ejercicios = new ArrayList<VOEjercicio>();

	public listarTodo() throws IOException {
		
		Connection conn = null;
		try {

			ConexionBD conexion = new ConexionBD();
			String where = (" ORDER by id desc");
			conn = conexion.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = conn.prepareStatement("SELECT * FROM Taller.Ejercicio" + where);
			rs = ps.executeQuery();
				
			while(rs.next())
			{
				VOEjercicio ejercicio = new VOEjercicio();
				ejercicio.setCodigo(rs.getString("ejercicio").toString());
				ejercicio.setPregunta(rs.getString("pregunta").toString());
				ejercicio.setId(rs.getInt("id"));
				ejercicios.add(ejercicio);
			}

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
	
	public ArrayList<VOEjercicio> getEjercicios() {
        return ejercicios;
    }

}
