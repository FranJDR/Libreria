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

import modelo.Referencia;
import modelo.Tematica;

public class GestorVista {

	private CreadorComponentes creador;

	private HashMap<Referencia, JTextField> fields;
	private HashMap<Referencia, JButton> button;
	private HashMap<Referencia, JRadioButton> jradbtn;

	private JComboBox<Tematica> comboTematica;

	private ButtonGroup formato;
	private ButtonGroup estado;

	public GestorVista() {
		super();
		this.creador = new CreadorComponentes();
		this.fields = new HashMap<Referencia, JTextField>();
		this.button = new HashMap<Referencia, JButton>();
		this.jradbtn = new HashMap<Referencia, JRadioButton>();
		this.formato = new ButtonGroup();
		this.estado = new ButtonGroup();

		this.comboTematica = this.creador.dameJComboBox();
		for (Tematica tema : Tematica.values()) {
			this.comboTematica.addItem(tema);
		}

		this.fields.put(Referencia.FIELD_TITULO, this.creador.dameJTextField());
		this.fields.put(Referencia.FIELD_AUTOR, this.creador.dameJTextField());
		this.fields.put(Referencia.FIELD_PRECIO, this.creador.dameJTextField());
		this.fields.put(Referencia.FIELD_ISBN, this.creador.dameJTextField());
		this.fields.put(Referencia.FIELD_PAGINAS, this.creador.dameJTextField());
		this.fields.put(Referencia.FIELD_BUSQUEDAISBN, this.creador.dameJTextField());

		soloLetras(this.fields.get(Referencia.FIELD_AUTOR));
		soloNumeros(this.fields.get(Referencia.FIELD_PRECIO));
		soloNumeros(this.fields.get(Referencia.FIELD_PAGINAS));
		soloNumeros(this.fields.get(Referencia.FIELD_ISBN));
		longitudMax(this.fields.get(Referencia.FIELD_ISBN), 13);

		this.button.put(Referencia.BTN_NUEVO, this.creador.dameJButton("Añadir nuevo libro"));
		this.button.put(Referencia.BTN_ALTA, this.creador.dameJButton("Añadir"));
		this.button.put(Referencia.BTN_BAJA, this.creador.dameJButton("Quitar"));
		this.button.put(Referencia.BTN_VERDETALLES, this.creador.dameJButton("Ver Detalles"));
		this.button.put(Referencia.BTN_MODIFICAR, this.creador.dameJButton("Modificar"));
		this.button.put(Referencia.BTN_ELIMINAR, this.creador.dameJButton("Eliminar"));

		this.jradbtn.put(Referencia.RADIOBTN_DIGITAL, this.creador.dameJRadioButton("Digital"));
		this.jradbtn.put(Referencia.RADIOBTN_REEDICION, this.creador.dameJRadioButton("Reedicion"));
		this.jradbtn.put(Referencia.RADIOBTN_RUSTICA, this.creador.dameJRadioButton("Rustica"));
		this.jradbtn.put(Referencia.RADIOBTN_CARTONE, this.creador.dameJRadioButton("Cartone"));
		this.jradbtn.put(Referencia.RADIOBTN_NOVEDAD, this.creador.dameJRadioButton("Novedad"));

		formato.add(this.jradbtn.get(Referencia.RADIOBTN_CARTONE));
		formato.add(this.jradbtn.get(Referencia.RADIOBTN_RUSTICA));
		formato.add(this.jradbtn.get(Referencia.RADIOBTN_DIGITAL));
		estado.add(this.jradbtn.get(Referencia.RADIOBTN_NOVEDAD));
		estado.add(this.jradbtn.get(Referencia.RADIOBTN_REEDICION));

	}

	public void limpiarVista() {
		this.formato.clearSelection();
		this.estado.clearSelection();
		for (JTextField field : this.fields.values()) {
			field.setText(null);
		}
	}

	public JRadioButton getRadioBtn(Referencia referencia) {
		return this.jradbtn.get(referencia);
	}

	public JButton getBtn(Referencia referencia) {
		return this.button.get(referencia);
	}

	public JTextField getField(Referencia referencia) {
		return this.fields.get(referencia);
	}

	public JComboBox<Tematica> getComboTematica() {
		return comboTematica;
	}

	public JLabel dameJLabel(String title, int longitud) {
		return this.creador.dameJLabel(title, longitud);
	}

	public HashMap<Referencia, String> getDatosField() {
		HashMap<Referencia, String> retorno = new HashMap<Referencia, String>();
		retorno.put(Referencia.TITULO, getField(Referencia.FIELD_TITULO).getText());
		retorno.put(Referencia.AUTOR, getField(Referencia.FIELD_AUTOR).getText());
		retorno.put(Referencia.PRECIO, getField(Referencia.FIELD_PRECIO).getText());
		retorno.put(Referencia.ISBN, getField(Referencia.FIELD_ISBN).getText());
		retorno.put(Referencia.PAGINAS, getField(Referencia.FIELD_PAGINAS).getText());
		retorno.put(Referencia.TEMATICA, this.comboTematica.getSelectedItem().toString());
		retorno.put(Referencia.ESTADO, getFormato());
		retorno.put(Referencia.FORMATO, getEstado());
		return retorno;
	}

	private void WarningMessage(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "error de datos ", JOptionPane.WARNING_MESSAGE);
	}

	public boolean isSelectFormato() {
		if (this.jradbtn.get(Referencia.RADIOBTN_CARTONE).isSelected()
				|| this.jradbtn.get(Referencia.RADIOBTN_RUSTICA).isSelected()
				|| this.jradbtn.get(Referencia.RADIOBTN_DIGITAL).isSelected())
			return true;
		WarningMessage("Debes marcar Formato.");
		return false;
	}

	private String getFormato() {
		if (this.jradbtn.get(Referencia.RADIOBTN_CARTONE).isSelected())
			return this.jradbtn.get(Referencia.RADIOBTN_CARTONE).getText();
		if (this.jradbtn.get(Referencia.RADIOBTN_RUSTICA).isSelected())
			return this.jradbtn.get(Referencia.RADIOBTN_RUSTICA).getText();
		if (this.jradbtn.get(Referencia.RADIOBTN_DIGITAL).isSelected())
			return this.jradbtn.get(Referencia.RADIOBTN_DIGITAL).getText();
		return null;
	}

	public boolean isSelectEstado() {
		if (this.jradbtn.get(Referencia.RADIOBTN_NOVEDAD).isSelected()
				|| this.jradbtn.get(Referencia.RADIOBTN_REEDICION).isSelected())
			return true;
		WarningMessage("Debes marcar Estado.");
		return false;
	}

	private String getEstado() {
		if (this.jradbtn.get(Referencia.RADIOBTN_NOVEDAD).isSelected())
			return this.jradbtn.get(Referencia.RADIOBTN_NOVEDAD).getText();
		if (this.jradbtn.get(Referencia.RADIOBTN_REEDICION).isSelected())
			return this.jradbtn.get(Referencia.RADIOBTN_REEDICION).getText();
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

}
