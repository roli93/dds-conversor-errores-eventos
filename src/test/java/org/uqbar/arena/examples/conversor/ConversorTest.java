package org.uqbar.arena.examples.conversor;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConversorTest {

	@Test
	public void testConvertirDeMillasAKilometrosDaCorrecto() {
		double millas = 12.0;
		Conversor conversor = new Conversor();
		conversor.setMillas(millas);
		
		conversor.convertir();
		
		double kilometrosExpected = millas * 1.60934;
		assertEquals(kilometrosExpected, conversor.getKilometros(),0);
	}
	
	@Test
	public void testConvertirSinSettearLasMillasDa0() {
		Conversor conversor = new Conversor();
		
		conversor.convertir();
		
		double kilometrosExpected = 0;
		assertEquals(kilometrosExpected, conversor.getKilometros(),0);
	}
	
	@Test
	public void testSetearMillasSinConvertirDa0() {
		Conversor conversor = new Conversor();
		conversor.setMillas(12.5);
		
		double kilometrosExpected = 0;
		assertEquals(kilometrosExpected, conversor.getKilometros(),0);
	}
	
	@Test
	public void testSetearKilometrosYConvertirLoDejaEn0() {
		Conversor conversor = new Conversor();
		conversor.setKilometros(12.5);
		
		conversor.convertir();
		
		double kilometrosExpected = 0;
		assertEquals(kilometrosExpected, conversor.getKilometros(),0);
	}

}
