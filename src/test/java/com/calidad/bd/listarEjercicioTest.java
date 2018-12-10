package com.calidad.bd;

import static org.junit.Assert.*;
import org.junit.Assert;
import java.io.IOException;

import org.junit.Test;

public class listarEjercicioTest {

	@Test
	public void testListarEjercicio() {
		listarEjercicio le = null;
		try {
			le = new listarEjercicio(0);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("....testListarEjercicio....");
		//Assert.assertNotNull(null);
		Assert.assertNotNull(le.getEjercicio());	
	}

	@Test
	public void testGetEjercicio() {
		listarEjercicio le = null;
		try {
			le = new listarEjercicio(0);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("....testGetEjercicio....");
		Assert.assertNotNull(le.getEjercicio());	
	}

}
