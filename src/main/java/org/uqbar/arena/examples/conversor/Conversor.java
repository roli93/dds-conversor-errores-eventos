package org.uqbar.arena.examples.conversor;

import org.uqbar.commons.utils.Observable;

@Observable
public class Conversor {
	private double lasMillas;
	private double km;

	// ********************************************************
	// ** Acciones
	// ********************************************************
	
	public void convertir() {
		this.km = this.lasMillas * 1.60934;
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
		return this.km;
	}

	public void setKilometros(double kilometros) {
		this.km = kilometros;
	}

}
