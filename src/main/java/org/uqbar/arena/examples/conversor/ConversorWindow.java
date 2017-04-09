package org.uqbar.arena.examples.conversor;

import java.awt.Color;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.MessageBox;
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
public class ConversorWindow extends MainWindow<Conversor> {

	public ConversorWindow() {
		super(new Conversor());
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Conversor de millas a kilómetros");
		mainPanel.setLayout(new VerticalLayout());

		new Label(mainPanel).setText("Ingrese la longitud en millas");

		new NumericField(mainPanel).bindValueToProperty("millas");

		new Button(mainPanel)
			.setCaption("Convertir a kilómetros")
			.onClick(() -> convertir());

		new Label(mainPanel) //
			.setBackground(Color.ORANGE)
			.bindValueToProperty("kilometros");
		
		new Label(mainPanel).setText(" kilómetros");
		
		new Label(mainPanel) //
		.setBackground(Color.YELLOW)
		.bindValueToProperty("metros");

		new Label(mainPanel).setText("metros");
		
	}
	
	public void convertir(){
		//Atrapamos la excepción del modelo, para transofrmarla en un mensaje amigable
		//al usuario y seguir propagándola hacia él (Nótese que no estamos realmente manejándola)
		try{
			this.getModelObject().convertir();			
		}
		catch(UserException e){
			showErrorMessageBox(e.getMessage());
		}
	}
	
	protected void showErrorMessageBox(String message) {
		//Creamos la MessageBox pasándole como padre esta ventana (this) para que cuando se cierre sepa
		//a qué ventana devolverle el control de la aplicación 
		MessageBox messageBox = new MessageBox(this, MessageBox.Type.Error);
		messageBox.setMessage(message);
		messageBox.open();
	}

	public static void main(String[] args) {
		new ConversorWindow().startApplication();
	}
}
