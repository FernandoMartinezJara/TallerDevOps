package com.jdoodle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import com.calidad.ws.rest.vo.RespuestaValida;
import com.calidad.ws.rest.vo.VOEjercicio;
import com.calidad.ws.rest.vo.VOValidaEjercicio;

public class APITest {
	
	String salida;
	RespuestaValida rep = new RespuestaValida();
	
    public APITest(VOEjercicio obj, VOValidaEjercicio objVe) {

        String clientId = "62cec4c1cbe7942994dc5866ad095203"; //Replace with your client ID
        String clientSecret = "9807a912174b396c344d9978282a9703bb3239b50fbc1112dff88a67e625263a"; //Replace with your client Secret
        //String script = "x=10; y=25; z=x+y; print 'Sum of x+y =', z;"; 
        String script = obj.getCodigo();
        String language = "python2";
        String versionIndex = "0";

        try {
            URL url = new URL("https://api.jdoodle.com/v1/execute");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String input = "{\"clientId\": \"" + clientId + "\",\"clientSecret\":\"" + clientSecret + "\",\"script\":\"" + script +
            "\",\"language\":\"" + language + "\",\"versionIndex\":\"" + versionIndex + "\"} ";

            System.out.println(input);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Please check your inputs : HTTP error code : "+ connection.getResponseCode());
            }

            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader(
            (connection.getInputStream())));

            String output;
            System.out.println("Output from JDoodle .... \n");
            while ((output = bufferedReader.readLine()) != null) {
                System.out.println(output);
                salida = output;
            }
            
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> map = mapper.readValue(salida, Map.class);
            
            System.out.println(map.get("output"));
            
            rep.setValor((String) map.get("output"));
            if( ((String) map.get("output")).trim().equals(objVe.getRespuesta().trim())) {
            	rep.setRespuesta("Correcto");
            }else {
            	rep.setRespuesta("Incorrecto");
            }
            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public RespuestaValida getRespuesta() {
        return rep;
    }
}