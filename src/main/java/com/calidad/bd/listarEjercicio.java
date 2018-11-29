package com.calidad.bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.calidad.ws.rest.vo.VOEjercicio;

public class listarEjercicio {
	
	VOEjercicio ejercicio = new VOEjercicio();

	public listarEjercicio(int id) throws IOException {
		
		Connection conn = null;
		try {

			// Establecer conexión con la base de datos
			ConexionBD conexion = new ConexionBD();
			String where = (id == 0 ? " ORDER BY RAND() LIMIT 1;" : " where id = "+id);
			conn = conexion.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = conn.prepareStatement("SELECT * FROM Taller.Ejercicio" + where);
			rs = ps.executeQuery();

			if(rs.next())
			{
				ejercicio.setCodigo(rs.getString("ejercicio").toString());
				ejercicio.setPregunta(rs.getString("pregunta").toString());
				ejercicio.setId(rs.getInt("id"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			//Bloque finally para cerrar la conexión
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
	
	public VOEjercicio getEjercicio() {
        return ejercicio;
    }

}
