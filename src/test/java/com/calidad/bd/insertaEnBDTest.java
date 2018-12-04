package com.calidad.bd;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.calidad.ws.rest.vo.VOEjercicio;

public class insertaEnBDTest {

	@Test
	public void testInsertarEjercicio() throws IOException {
		
		VOEjercicio ejercicio = new VOEjercicio();
		ejercicio.setCodigo("print 60");
		ejercicio.setPregunta("pregunta test");
		insertaEnBD in = new insertaEnBD();
		in.InsertarEjercicio(ejercicio);
		System.out.println("....testInsertarEjercicio....");
	}

}
