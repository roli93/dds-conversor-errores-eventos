package org.uqbar.arena.examples.conversor;

import java.awt.Color;

import org.uqbar.arena.Application;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.MessageBox;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.model.UserException;
import org.uqbar.ui.view.ErrorViewer;

/**
 * Ejemplo de conversor de medidas con el framework Arena. Es una ventana que tiene como modelo una instancia
 * de la clase {@link Conversor}.
 * 
 * Muestra:
 * <ul>
 * <li>un textbox donde se ingresa el valor de entrada</li>
 * <li>un botón para ejecutar la conversión.</li>
 * <li>un label donde se muestra el resultado de la conversión.</li>
 * </ul>
 * 
 * @author npasserini
 */
@SuppressWarnings("serial")
//Como no estamos usando una MainWindow,creamos una Aplication que nos permite
//iniciar la ejecución con un main.
public class ConversorApplication extends Application {
	
	public static void main(String[] args) {
		new ConversorApplication().start();
	}
	

	@Override
	protected Window<Conversor> createMainWindow() {
		return new ConversorWindow(this);
	}
}
