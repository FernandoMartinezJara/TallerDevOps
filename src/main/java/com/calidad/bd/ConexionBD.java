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
	
	//Objeto de conexión a base de datos tipo Connection
	Connection conn = null;

	//Objeto de propiedades donde vamos a cargar las propiedades del archivo
	Properties props = new Properties();

	//Resultset donde vamos a buscar el resultado que genera el query
	ResultSet rs = null;

	//Input Stream donde leemos el recurso donde está el archivo de propiedades
	InputStream is = JavaMysqlEjemplo.class.getClassLoader().getResourceAsStream("app.properties");

	//Objeto que utilizaremos para lanzar un query a la base de datos
	PreparedStatement ps = null;

	

    public ConexionBD() throws IOException
    {
        try {
        	
        	//Cargamos las propiedades que vienene del archivo
        	props.load(is);

        	//Cerramos el recurso
        	is.close();
        	
        
        	//Abrimos conexión a base de datos
    		//conn = DriverManager.getConnection(props.getProperty("url"), props);
        	conn = DriverManager.getConnection("jdbc:mysql://104.198.185.19:3306/Taller?autoReconnect=true&useSSL=false", "root", "k.ndP9yT");
            System.out.println("Conexión realizada a la base de datos con éxito.");
        }  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn; // Retorno el objeto Connection
    }

}
