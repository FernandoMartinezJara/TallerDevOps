package com.calidad.ws.rest.service;

import java.io.IOException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.calidad.bd.insertaEnBD;
import com.calidad.bd.listarEjercicio;
import com.calidad.ws.rest.vo.VOEjercicio;
import com.jdoodle.APITest;

@Path("/Taller")
public class ServiceEjercicio {

	@POST
	@Path("/insertarEjercicio")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public void insertarEjercicio(VOEjercicio vo) throws IOException {
		VOEjercicio ejercicio = new VOEjercicio();
		ejercicio.setCodigo(vo.getCodigo());
		ejercicio.setPregunta(vo.getPregunta());
		insertaEnBD in = new insertaEnBD();
		in.InsertarEjercicio(ejercicio);		
	}

	@GET
	@Path("/recuperarEjercicio")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public VOEjercicio recuperarEjercicio() {
		listarEjercicio le = null;
		try {
			le = new listarEjercicio(0);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return le.getEjercicio();
		
	}

	@POST
	@Path("/listaEjercicios")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<VOEjercicio> listaEjercicios() {
		VOEjercicio ejercicio = new VOEjercicio();
		ejercicio.setCodigo("Ejemplo");
		ejercicio.setPregunta("Pregunta ejemplo");

		ArrayList<VOEjercicio> l = new ArrayList<VOEjercicio>();
		l.add(ejercicio);

		return l;
	}

	@POST
	@Path("/validarEjercicios")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String validarEjercicios(int id) {
		listarEjercicio le = null;
		APITest ve = null;
		try {
			le = new listarEjercicio(id);
			ve = new APITest(le.getEjercicio());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ve.getRespuesta();
		
	}

}
