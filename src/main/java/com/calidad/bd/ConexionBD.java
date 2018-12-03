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


public class ConexionBD {

	Connection conn = null;
	Properties props = new Properties();
	ResultSet rs = null;
	InputStream is = JavaMysqlEjemplo.class.getClassLoader().getResourceAsStream("app.properties");
	PreparedStatement ps = null;
    public ConexionBD() throws IOException
    {
        try {
        	
        	props.load(is);
        	is.close();
    		//conn = DriverManager.getConnection(props.getProperty("url"), props);
        	DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
        	conn = DriverManager.getConnection("jdbc:mysql://35.239.88.179:3306/Taller?autoReconnect=true&useSSL=false", "root", "k.ndP9yT");            
        }  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn; // Retorno el objeto Connection
    }

}
