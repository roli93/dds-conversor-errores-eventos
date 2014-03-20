package org.uqbar.arena.examples.conversor;

import org.uqbar.commons.utils.Observable;

@Observable
public class Conversor {
	private double lasMillas;
	private double losKilometros;

	// ********************************************************
	// ** Acciones
	// ********************************************************
	
	public void convertir() {
		this.losKilometros = this.lasMillas * 1.60934;
	}
	
	// ********************************************************
	// ** Atributos
	// ********************************************************

	public double getMillas() {
		return this.lasMillas;
	}

	public void setMillas(double millas) {
		this.lasMillas = millas;
	}

	public double getKilometros() {
		return this.losKilometros;
	}

	public void setKilometros(double kilometros) {
		this.losKilometros = kilometros;
	}

}
