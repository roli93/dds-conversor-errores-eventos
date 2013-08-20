/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/*
 * CelsiusConverterGUI.java
 *
 */

package org.uqbar.arena.examples.conversor.swing;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * 
 * @author internet
 */
public class ConversorSwing extends JFrame {
	private static final long serialVersionUID = -611799915561260226L;

	private JLabel millasLabel;
	private JButton convertirButton;
	private JLabel kilometrosLabel;
	private JTextField millasTextField;
	private Conversor conversor = new Conversor();

	public ConversorSwing() {
		this.initComponents();
	}

	private void initComponents() {
		this.setTitle("Conversor Millas/Km");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		this.millasTextField = new JTextField();
		this.kilometrosLabel = new JLabel();

		this.millasLabel = new JLabel();
		this.millasLabel.setText("Millas");

		this.convertirButton = new JButton();
		this.convertirButton.setText("Convertir");
		this.convertirButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				ConversorSwing.this.convertButtonActionPerformed(evt);
			}
		});

		this.kilometrosLabel.setText("Kilometros");
		this.configureLayout();
		this.pack();
	}

	protected void configureLayout() {
		this.getContentPane().setLayout(new GridLayout(2,2, 10, 10));
		this.getContentPane().add(this.millasTextField);
		this.getContentPane().add(this.millasLabel);
		this.getContentPane().add(this.convertirButton);
		this.getContentPane().add(this.kilometrosLabel);
	}

	private void convertButtonActionPerformed(java.awt.event.ActionEvent evt) {
		double millas = Double.parseDouble(this.millasTextField.getText());
		double kilometros = this.conversor.convertir(millas);
		this.kilometrosLabel.setText(kilometros + " Km");
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ConversorSwing().setVisible(true);
			}
		});
	}

}