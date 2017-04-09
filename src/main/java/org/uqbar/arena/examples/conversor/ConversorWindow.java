package org.uqbar.arena.examples.conversor;

import java.awt.Color;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.MessageBox;
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
public class ConversorWindow extends MainWindow<Conversor> implements ErrorViewer {

	public ConversorWindow() {
		super(new Conversor());
	}

	@Override
	public void createContents(Panel mainPanel) {
		
		//Asignamos un error viewer a la ventana, que será el encargado de saber qué
		//hacer cuando haya un error. En este caso la misma ventana es su propio error viewer
		this.getDelegate().setErrorViewer(this);
		
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
		this.getModelObject().convertir();			
	}
	
	@Override
	public void showError(String message) {
		//Este es el método que se va a ejecutar cada vez que haya un error en las ventanas que tienen 
		//a este Error Viewer steteado. Acá mostramos el Message Box de error
		showErrorMessageBox(message);
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
	
	@Override
	public void showInfo(String message) {
		//Este método no nos importa por ahora, lo dejamos que no haga nada
	}

	@Override
	public void showWarning(String message) {
		//Este método no nos importa por ahora, lo dejamos que no haga nada
	}
}
