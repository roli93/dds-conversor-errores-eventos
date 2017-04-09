package org.uqbar.arena.examples.conversor;

import java.awt.Color;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.MessageBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
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
//Utilizamos una SimpleWindow, que se encarga sola
//de manejar cualquier UserException que sea lanzada
public class ConversorWindow extends SimpleWindow<Conversor> {

	public ConversorWindow(WindowOwner owner) {
		super(owner, new Conversor());
		
		//Una SimpleWindow nos permite setear una descripcion de la tarea
		//Si no ponemos nada, quedara un espacio en blanco
		this.setTaskDescription("Para convertir presione \"Convertir\"");
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		
		this.setTitle("Conversor de millas a kilómetros");
		mainPanel.setLayout(new VerticalLayout());

		new Label(mainPanel).setText("Ingrese las millas a convertir");

		new NumericField(mainPanel).bindValueToProperty("millas");

		new Button(mainPanel)
			.setCaption("Convertir")
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
	protected void addActions(Panel mainPanel) {
		//Una SimpleWindow nos permite agregar una serie de botones con acciones al pie.
		//Por ahora no lo utilizaremos
	}

}
