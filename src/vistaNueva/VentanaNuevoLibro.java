package vistaNueva;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

import modelo.Referencia;
import vista.CreadorComponentes;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaNuevoLibro extends JDialog {

	private CreadorComponentes creador = new CreadorComponentes();

	private final JPanel contentPanel = new JPanel();

	private ButtonGroup formato = new ButtonGroup();
	private ButtonGroup estado = new ButtonGroup();

	private JRadioButton radioButtonCartone = new JRadioButton("Cartone");
	private JRadioButton radioButtonRustica = new JRadioButton("Rustica");
	private JRadioButton radioButtonDigital = new JRadioButton("Digital");
	private JRadioButton radioButtonNovedad = new JRadioButton("Novedad");
	private JRadioButton radioButtonReedicion = new JRadioButton("Reedicion");

	private HashMap<Referencia, JTextField> fields;

	public VentanaNuevoLibro() {
		crearFields();
		enlazarRadioButton();
		setTitle("Nuevo Libro");
		setBounds(100, 100, 588, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(15).addGroup(gl_contentPanel
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
						.addGap(15)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addGap(15).addComponent(panel, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
				.addGap(21).addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE).addGap(15)
				.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE).addContainerGap()));

		JPanel panelLabel = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(panelLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(481, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGap(10)
						.addComponent(panelLabel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE).addGap(10)));
		panelLabel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.setLayout(gl_panel);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Estado :");
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);

		Box horizontalBox_1 = Box.createHorizontalBox();
		panel_2.add(horizontalBox_1);

		radioButtonNovedad.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		horizontalBox_1.add(radioButtonNovedad);

		radioButtonReedicion.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		horizontalBox_1.add(radioButtonReedicion);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblNewLabel = new JLabel("Formato :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		panel_1.add(lblNewLabel);

		Box horizontalBox = Box.createHorizontalBox();
		panel_1.add(horizontalBox);

		horizontalBox.add(radioButtonCartone);
		radioButtonCartone.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));

		radioButtonRustica.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		horizontalBox.add(radioButtonRustica);

		radioButtonDigital.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		horizontalBox.add(radioButtonDigital);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
			}
		}
	}

	private void crearFields() {
		this.fields.put(Referencia.FIELD_TITULO, this.creador.dameJTextField());
		this.fields.put(Referencia.FIELD_AUTOR, this.creador.dameJTextField());
		this.fields.put(Referencia.FIELD_PRECIO, this.creador.dameJTextField());
		this.fields.put(Referencia.FIELD_ISBN, this.creador.dameJTextField());
		this.fields.put(Referencia.FIELD_PAGINAS, this.creador.dameJTextField());
	}

	public HashMap<Referencia, String> getDatosVista() {
		HashMap<Referencia, String> map = new HashMap<Referencia, String>();
		map.put(Referencia.TITULO, this.getTextField(Referencia.FIELD_TITULO));
		map.put(Referencia.AUTOR, this.getTextField(Referencia.FIELD_AUTOR));
		map.put(Referencia.PRECIO, this.getTextField(Referencia.FIELD_PRECIO));
		map.put(Referencia.ISBN, this.getTextField(Referencia.FIELD_ISBN));
		map.put(Referencia.PAGINAS, this.getTextField(Referencia.FIELD_PAGINAS));
		return map;
	}

	private void enlazarRadioButton() {
		this.formato.add(this.radioButtonCartone);
		this.formato.add(this.radioButtonRustica);
		this.formato.add(this.radioButtonDigital);
		this.estado.add(this.radioButtonNovedad);
		this.estado.add(this.radioButtonReedicion);
	}

	public boolean isSelectEstadoFormato() {
		return this.isSelectEstado() && this.isSelectFormato();
	}

	private boolean isSelectFormato() {
		if (this.radioButtonCartone.isSelected())
			return true;
		if (this.radioButtonRustica.isSelected())
			return true;
		if (this.radioButtonDigital.isSelected())
			return true;
		WarningMessage("Debes marcar Formato.");
		return false;
	}

	private boolean isSelectEstado() {
		if (this.radioButtonNovedad.isSelected())
			return true;
		if (this.radioButtonReedicion.isSelected())
			return true;
		WarningMessage("Debes marcar Estado.");
		return false;
	}

	public boolean isEmptyField(Referencia referencia) {
		return this.fields.get(referencia).getText().isEmpty();
	}

	public JTextField getField(Referencia referencia) {
		return this.fields.get(referencia);
	}

	public String getTextField(Referencia referencia) {
		return this.fields.get(referencia).getText();
	}

	private void WarningMessage(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "error de datos ", JOptionPane.WARNING_MESSAGE);
	}
}
