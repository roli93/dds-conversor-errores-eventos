package org.uqbar.arena.examples.conversor.swt;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.uqbar.commons.StringUtils;

/**
 * Implementación del Conversor en swt "crudo".
 * 
 * @author jfernandes
 */
public class ConversorSWT extends ApplicationWindow {
	private Label millasLabel;
	private Text millasTextBox;
	private Label kilometrosFieldLabel;
	private Label kilometrosLabel;

	public ConversorSWT() {
		super(null);
		this.addStatusLine();
	}

	@Override
	public Control createContents(Composite parent) {
		this.getShell().setText("Conversor SWT");
		
		Composite panel = new Composite(parent, SWT.NULL);
		panel.setLayout(new GridLayout(4, true));

		this.millasLabel = new Label(panel, SWT.NULL);
		this.millasLabel.setText("Millas: ");
		this.millasTextBox = new Text(panel, SWT.SINGLE | SWT.BORDER);

		this.kilometrosFieldLabel = new Label(panel, SWT.NULL);
		this.kilometrosFieldLabel.setText("Kilometros: ");
		this.kilometrosLabel = new Label(panel, SWT.SINGLE | SWT.BORDER);
		this.kilometrosLabel.setLayoutData(new GridData(GridData.FILL_BOTH));

		Button button = new Button(panel, SWT.PUSH);
		button.setText("Covertir");
		button.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				String selected = ConversorSWT.this.millasTextBox.getText();
				if(StringUtils.isBlank(selected)) {
					ConversorSWT.this.kilometrosLabel.setText("");
				}
				else {
					try {
						double millas = Double.parseDouble(selected);
						double kilometros = millas * 1.60934;
						ConversorSWT.this.kilometrosLabel.setText(Double.toString(kilometros));
					}
					catch (NumberFormatException e) {
						ConversorSWT.this.setStatus("Millas ingresadas incorrectas !: " + e.getMessage());
					}
				}
			}
		});
		return panel;
	}

	public static void main(String[] args) {
		ConversorSWT converter = new ConversorSWT();
		converter.setBlockOnOpen(true);
		converter.open();
	}

}