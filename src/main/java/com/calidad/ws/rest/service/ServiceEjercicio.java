package com.calidad.ws.rest.service;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.calidad.ws.rest.vo.VOEjercicio;

@Path("/Taller")
public class ServiceEjercicio {

	@POST
	@Path("/insertarEjercicio")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public VOEjercicio insertarEjercicio(VOEjercicio vo) {
		VOEjercicio ejercicio = new VOEjercicio();
		ejercicio.setCodigo("Ejemplo");
		ejercicio.setPregunta("Pregunta ejemplo");
		return ejercicio;
	}

	@POST
	@Path("/recuperarEjercicio")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public VOEjercicio recuperarEjercicio() {
		VOEjercicio ejercicio = new VOEjercicio();
		ejercicio.setCodigo("Ejemplo");
		ejercicio.setPregunta("Pregunta ejemplo");
		return ejercicio;
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
	public VOEjercicio validarEjercicios(VOEjercicio ejercicio) {

		VOEjercicio e = new VOEjercicio();
		e.setCodigo("Ejemplo");
		e.setPregunta("Pregunta ejemplo");

		return e;
	}

}
