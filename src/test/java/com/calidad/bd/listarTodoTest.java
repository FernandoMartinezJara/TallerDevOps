package com.calidad.bd;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class listarTodoTest {

	@Test
	public void testListarTodo() {
		listarTodo ejercicios = null;
		try {
			ejercicios = new listarTodo();	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("....testListarTodo....");
		Assert.assertNotNull(ejercicios.getEjercicios());			
	}

	@Test
	public void testGetEjercicios() {
		listarTodo ejercicios = null;
		try {
			ejercicios = new listarTodo();	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("....testGetEjercicios 222222....");
		Assert.assertNotNull(ejercicios.getEjercicios());	
	}

}
