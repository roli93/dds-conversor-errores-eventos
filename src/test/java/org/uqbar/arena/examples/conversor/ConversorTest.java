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

}
