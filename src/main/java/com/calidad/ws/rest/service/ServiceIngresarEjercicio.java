package com.calidad.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.calidad.ws.rest.vo.VOEjercicio;

@Path("/Taller")
public class ServiceIngresarEjercicio {

	@POST
	@Path("/IngresarEjercicio")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOEjercicio validaUsuario(VOEjercicio vo) {
		VOEjercicio ejercicio = new VOEjercicio();
		ejercicio.setFuente("Ejemplo");
		ejercicio.setPregunta("Pregunta ejemplo");
		return ejercicio;
	}
	
}
