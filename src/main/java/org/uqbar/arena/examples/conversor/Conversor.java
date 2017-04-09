package org.uqbar.arena.examples.conversor;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
public class Conversor {
	private double millas;
	private double kilometros;

	// ********************************************************
	// ** Acciones
	// ********************************************************
	
	public void convertir() {
		//Como ese converson tambien muestra los metros y no queremos mostrar
		//valores muy grandes, no dejamos convertir mas de 1000 millas
		if(this.millas > 1000){
			throw new UserException("Ingrese un valor menor a 1000");
		}
		this.setKilometros(this.millas * 1.60934);
	}
	
	// ********************************************************
	// ** Atributos
	// ********************************************************

	public double getMillas() {
		return this.millas;
	}

	public void setMillas(double millas) {
		this.millas = millas;
	}

	public double getKilometros() {
		return this.kilometros;
	}

	public void setKilometros(double kilometros) {
		//Como los metros dependen de los kilómetros y Arena no puede trackear esa dependencia solo,
		//disparamos este evento para que la vista sepa que debe atualizarse.
		this.kilometros = kilometros;
		ObservableUtils.firePropertyChanged(this, "metros");
	}
	
	public double getMetros() {
		//Los metros no son una propiedad que se defina en un atributo, sino que son una 
		//propiedad calculada en base a ellos.
		return this.kilometros*1000;
	}

}
