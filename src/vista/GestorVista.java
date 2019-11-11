package vista;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import modelo.enums.Editorial;
import modelo.enums.RefereciaRadioButton;
import modelo.enums.ReferenciaButton;
import modelo.enums.ReferenciaDatos;
import modelo.enums.ReferenciaFields;
import modelo.enums.Tematica;

public class GestorVista {

	private CreadorComponentes creador;

	private HashMap<ReferenciaFields, JTextField> fields;
	private HashMap<ReferenciaButton, JButton> button;
	private HashMap<RefereciaRadioButton, JRadioButton> jradbtn;

	private JComboBox<Tematica> comboTematica;
	private JComboBox<String> comboEditorial;

	private ButtonGroup formato;
	private ButtonGroup estado;

	public GestorVista() {
		super();
		this.creador = new CreadorComponentes();
		this.fields = new HashMap<ReferenciaFields, JTextField>();
		this.button = new HashMap<ReferenciaButton, JButton>();
		this.jradbtn = new HashMap<RefereciaRadioButton, JRadioButton>();
		this.formato = new ButtonGroup();
		this.estado = new ButtonGroup();

		this.comboTematica = this.creador.dameJComboBox();
		for (Tematica tema : Tematica.values()) {
			this.comboTematica.addItem(tema);
		}
		this.comboEditorial = this.creador.dameJComboBox();
		for (Editorial editorial : Editorial.values()) {
			this.comboEditorial.addItem(editorial.getNombre());
		}

		this.fields.put(ReferenciaFields.TITULO, this.creador.dameJTextField());
		this.fields.put(ReferenciaFields.AUTOR, this.creador.dameJTextField());
		this.fields.put(ReferenciaFields.PRECIO, this.creador.dameJTextField());
		this.fields.put(ReferenciaFields.ISBN, this.creador.dameJTextField());
		this.fields.put(ReferenciaFields.PAGINAS, this.creador.dameJTextField());
		this.fields.put(ReferenciaFields.BUSQUEDAISBN, this.creador.dameJTextField());

		soloLetras(this.fields.get(ReferenciaFields.AUTOR));
		soloNumeros(this.fields.get(ReferenciaFields.PRECIO));
		soloNumeros(this.fields.get(ReferenciaFields.PAGINAS));
		soloNumeros(this.fields.get(ReferenciaFields.BUSQUEDAISBN));
		soloNumeros(this.fields.get(ReferenciaFields.ISBN));
		longitudMax(this.fields.get(ReferenciaFields.ISBN), 13);
		longitudMax(this.fields.get(ReferenciaFields.BUSQUEDAISBN), 13);

		this.button.put(ReferenciaButton.NUEVO, this.creador.dameJButton(ReferenciaButton.NUEVO.getNombre()));
		this.button.put(ReferenciaButton.ALTA, this.creador.dameJButton(ReferenciaButton.ALTA.getNombre()));
		this.button.put(ReferenciaButton.BAJA, this.creador.dameJButton(ReferenciaButton.BAJA.getNombre()));
		this.button.put(ReferenciaButton.VERDETALLES,
				this.creador.dameJButton(ReferenciaButton.VERDETALLES.getNombre()));
		this.button.put(ReferenciaButton.MODIFICAR, this.creador.dameJButton(ReferenciaButton.MODIFICAR.getNombre()));
		this.button.put(ReferenciaButton.ELIMINAR, this.creador.dameJButton(ReferenciaButton.ELIMINAR.getNombre()));

		this.jradbtn.put(RefereciaRadioButton.DIGITAL, this.creador.dameJRadioButton("Digital"));
		this.jradbtn.put(RefereciaRadioButton.REEDICION, this.creador.dameJRadioButton("Reedicion"));
		this.jradbtn.put(RefereciaRadioButton.RUSTICA, this.creador.dameJRadioButton("Rustica"));
		this.jradbtn.put(RefereciaRadioButton.CARTONE, this.creador.dameJRadioButton("Cartone"));
		this.jradbtn.put(RefereciaRadioButton.NOCEDAD, this.creador.dameJRadioButton("Novedad"));

		formato.add(this.jradbtn.get(RefereciaRadioButton.CARTONE));
		formato.add(this.jradbtn.get(RefereciaRadioButton.RUSTICA));
		formato.add(this.jradbtn.get(RefereciaRadioButton.DIGITAL));
		estado.add(this.jradbtn.get(RefereciaRadioButton.NOCEDAD));
		estado.add(this.jradbtn.get(RefereciaRadioButton.REEDICION));

	}

	public void limpiarVista() {
		this.formato.clearSelection();
		this.estado.clearSelection();
		for (JTextField field : this.fields.values()) {
			field.setText(null);
		}
	}

	public JRadioButton getRadioBtn(RefereciaRadioButton referencia) {
		return this.jradbtn.get(referencia);
	}

	public JButton getBtn(ReferenciaButton referencia) {
		return this.button.get(referencia);
	}

	public JTextField getField(ReferenciaFields referencia) {
		return this.fields.get(referencia);
	}

	public JComboBox<Tematica> getComboTematica() {
		return comboTematica;
	}

	public JLabel dameJLabel(String title) {
		return this.creador.dameJLabel(title);
	}

	public HashMap<ReferenciaDatos, String> getDatosField() {
		HashMap<ReferenciaDatos, String> retorno = new HashMap<ReferenciaDatos, String>();
		retorno.put(ReferenciaDatos.TITULO, getField(ReferenciaFields.TITULO).getText());
		retorno.put(ReferenciaDatos.AUTOR, getField(ReferenciaFields.AUTOR).getText());
		retorno.put(ReferenciaDatos.PRECIO, getField(ReferenciaFields.PRECIO).getText());
		retorno.put(ReferenciaDatos.ISBN, getField(ReferenciaFields.ISBN).getText());
		retorno.put(ReferenciaDatos.PAGINAS, getField(ReferenciaFields.PAGINAS).getText());
		retorno.put(ReferenciaDatos.TEMATICA, this.comboTematica.getSelectedItem().toString());
		retorno.put(ReferenciaDatos.EDITORIAL, this.comboEditorial.getSelectedItem().toString());
		retorno.put(ReferenciaDatos.ESTADO, getFormato());
		retorno.put(ReferenciaDatos.FORMATO, getEstado());
		return retorno;
	}

	private void WarningMessage(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "error de datos ", JOptionPane.WARNING_MESSAGE);
	}

	public boolean isSelectFormato() {
		if (this.jradbtn.get(RefereciaRadioButton.CARTONE).isSelected()
				|| this.jradbtn.get(RefereciaRadioButton.RUSTICA).isSelected()
				|| this.jradbtn.get(RefereciaRadioButton.DIGITAL).isSelected())
			return true;
		WarningMessage("Debes marcar Formato.");
		return false;
	}

	private String getFormato() {
		if (this.jradbtn.get(RefereciaRadioButton.CARTONE).isSelected())
			return this.jradbtn.get(RefereciaRadioButton.CARTONE).getText();
		if (this.jradbtn.get(RefereciaRadioButton.RUSTICA).isSelected())
			return this.jradbtn.get(RefereciaRadioButton.RUSTICA).getText();
		if (this.jradbtn.get(RefereciaRadioButton.DIGITAL).isSelected())
			return this.jradbtn.get(RefereciaRadioButton.DIGITAL).getText();
		return null;
	}

	public boolean isSelectEstado() {
		if (this.jradbtn.get(RefereciaRadioButton.NOCEDAD).isSelected()
				|| this.jradbtn.get(RefereciaRadioButton.REEDICION).isSelected())
			return true;
		WarningMessage("Debes marcar Estado.");
		return false;
	}

	private String getEstado() {
		if (this.jradbtn.get(RefereciaRadioButton.NOCEDAD).isSelected())
			return this.jradbtn.get(RefereciaRadioButton.NOCEDAD).getText();
		if (this.jradbtn.get(RefereciaRadioButton.REEDICION).isSelected())
			return this.jradbtn.get(RefereciaRadioButton.REEDICION).getText();
		return null;
	}

	private void longitudMax(JTextField field, int longitud) {
		field.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (field.getText().length() == longitud)
					e.consume();
			}
		});
	}

	private void soloLetras(Component component) {
		component.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE))
					e.consume();
			}
		});
	}

	private void soloNumeros(Component component) {
		component.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < '0' || e.getKeyChar() > '9'))
					e.consume();
			}
		});
	}

	public JComboBox<String> getComboEditorial() {
		return comboEditorial;
	}

}
