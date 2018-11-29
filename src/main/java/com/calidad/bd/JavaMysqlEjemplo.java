package com.calidad.bd;


/*Bloque para importar clases necesarias*/
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.calidad.ws.rest.vo.VOEjercicio;
import com.jdoodle.APITest;


public class JavaMysqlEjemplo {

	public static void main(String[] args) throws IOException, SQLException {

		listarEjercicio le = null;
		APITest ve = null;
		le = new listarEjercicio(2);
		ve = new APITest(le.getEjercicio());

		System.out.println(ve.getRespuesta());

	}

}
