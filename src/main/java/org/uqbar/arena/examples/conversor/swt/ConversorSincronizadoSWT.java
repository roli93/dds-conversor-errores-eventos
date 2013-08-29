package org.uqbar.arena.examples.conversor.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Conversor entre celsius y fahrenheit:
 *  - en ambas direcciones
 *  - sin botón, es decir, automáticamente al escribir
 * 
 * @author jfernandes (basado en algún ejemplo de internet, emprolijando un poco)
 */
public class ConversorSincronizadoSWT implements VerifyListener, ModifyListener {
	// Widgets
	private Text millasText;
	private Text kilometrosText;
	private Label feedbackLabel;

	/**
	 * Runs the application
	 */
	public void run() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Conversor Sincronizado SWT");
		this.createContents(shell);
		shell.pack();
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	/**
	 * Create the main window's contents
	 * @param shell the main window
	 */
	private void createContents(Shell shell) {
		shell.setLayout(new GridLayout(3, true));

		// millas
		new Label(shell, SWT.LEFT).setText("Millas:");
		this.millasText = new Text(shell, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;
		this.millasText.setLayoutData(data);

		this.millasText.addVerifyListener(this);
		this.millasText.addModifyListener(this);

		// km
		new Label(shell, SWT.LEFT).setText("Kilometros:");
		this.kilometrosText = new Text(shell, SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;
		this.kilometrosText.setLayoutData(data);
		this.kilometrosText.addVerifyListener(this);
		this.kilometrosText.addModifyListener(this);
		
		// feedback
		this.feedbackLabel = new Label(shell, SWT.LEFT | SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 3;
		this.feedbackLabel.setLayoutData(data);
	}

	/**
	 * Called when the user types into a text box, but before the text box gets what the user typed
	 */
	@Override
	public void verifyText(VerifyEvent event) {
		event.doit = false;

		// Get the character typed
		char typedCharacter = event.character;
		String text = ((Text) event.widget).getText();

		// Allow '-' if first character
		if(typedCharacter == '-' && text.length() == 0) {
			event.doit = true;
		}

		// Allow 0-9
		if(Character.isDigit(typedCharacter)) {
			event.doit = true;
		}

		// Allow backspace
		if(typedCharacter == '\b') {
			event.doit = true;
		}
	}

	/**
	 * Called when the user modifies the text in a text box
	 */
	@Override
	public synchronized void modifyText(ModifyEvent event) {
		// Remove all the listeners (avoid infinite loops)
		this.kilometrosText.removeVerifyListener(this);
		this.kilometrosText.removeModifyListener(this);
		this.millasText.removeVerifyListener(this);
		this.millasText.removeModifyListener(this);

		Text modifiedText = (Text) event.widget;

		try {
			// 
			int newValue = Integer.parseInt(modifiedText.getText());

			if(modifiedText == this.millasText) {
				// millas -> km
				this.kilometrosText.setText(String.valueOf(newValue * 1.60934));
			}
			else {
				// km -> millas
				this.millasText.setText(String.valueOf(newValue / 1.60934));
			}
		}
		catch(NumberFormatException e) {
			this.feedbackLabel.setText("Error en la conversión: " + e.getMessage());
		}

		// Add the listeners back
		this.kilometrosText.addVerifyListener(this);
		this.kilometrosText.addModifyListener(this);
		this.millasText.addVerifyListener(this);
		this.millasText.addModifyListener(this);
	}

	/**
	 * The application entry point
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		new ConversorSincronizadoSWT().run();
	}
}