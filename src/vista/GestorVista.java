package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import modelo.Referencia;

public class GestorVista {

	private HashMap<Referencia, JTextField> fields = new HashMap<Referencia, JTextField>();
	private HashMap<Referencia, JButton> button = new HashMap<Referencia, JButton>();
	private HashMap<Referencia, JRadioButton> jradbtn = new HashMap<Referencia, JRadioButton>();

	private ButtonGroup formato = new ButtonGroup();
	private ButtonGroup estado = new ButtonGroup();

	public GestorVista() {
		super();
		this.fields.put(Referencia.FIELD_TITULO, insertarJText());
		this.fields.put(Referencia.FIELD_AUTOR, insertarJText());
		this.fields.put(Referencia.FIELD_PRECIO, insertarJText());
		this.fields.put(Referencia.FIELD_ISBN, insertarJText());
		this.fields.put(Referencia.FIELD_PAGINAS, insertarJText());

		soloLetras(this.fields.get(Referencia.FIELD_AUTOR));
		soloNumeros(this.fields.get(Referencia.FIELD_PRECIO));
		soloNumeros(this.fields.get(Referencia.FIELD_PAGINAS));
		soloNumeros(this.fields.get(Referencia.FIELD_ISBN));
		longitudMax(this.fields.get(Referencia.FIELD_ISBN), 13);

		this.button.put(Referencia.BTN_NUEVO, insertarBtn("Nuevo"));
		this.button.put(Referencia.BTN_ALTA, insertarBtn("Alta ISBN / Alta"));
		this.button.put(Referencia.BTN_BAJA, insertarBtn("Baja ISBN / Baja"));
		this.button.put(Referencia.BTN_VERDETALLES, insertarBtn("Ver Detalles"));
		this.button.put(Referencia.BTN_MODIFICAR, insertarBtn("Modificar"));
		this.button.put(Referencia.BTN_ELIMINAR, insertarBtn("Eliminar"));
		this.button.put(Referencia.BTN_SALIR, insertarBtn("Salir"));

		this.jradbtn.put(Referencia.RADIOBTN_DIGITAL, insertarRadioBtn("Digital"));
		this.jradbtn.put(Referencia.RADIOBTN_REEDICION, insertarRadioBtn("Reedicion"));
		this.jradbtn.put(Referencia.RADIOBTN_RUSTICA, insertarRadioBtn("Rustica"));
		this.jradbtn.put(Referencia.RADIOBTN_CARTONE, insertarRadioBtn("Cartone"));
		this.jradbtn.put(Referencia.RADIOBTN_NOVEDAD, insertarRadioBtn("Novedad"));

		formato.add(this.jradbtn.get(Referencia.RADIOBTN_CARTONE));
		formato.add(this.jradbtn.get(Referencia.RADIOBTN_RUSTICA));
		formato.add(this.jradbtn.get(Referencia.RADIOBTN_DIGITAL));
		estado.add(this.jradbtn.get(Referencia.RADIOBTN_NOVEDAD));
		estado.add(this.jradbtn.get(Referencia.RADIOBTN_REEDICION));

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

	public HashMap<Referencia, String> getDatosField() {
		HashMap<Referencia, String> retorno = new HashMap<Referencia, String>();
		retorno.put(Referencia.TITULO, getField(Referencia.FIELD_TITULO).getText());
		retorno.put(Referencia.AUTOR, getField(Referencia.FIELD_AUTOR).getText());
		retorno.put(Referencia.PRECIO, getField(Referencia.FIELD_PRECIO).getText());
		retorno.put(Referencia.ISBN, getField(Referencia.FIELD_ISBN).getText());
		retorno.put(Referencia.PAGINAS, getField(Referencia.FIELD_PAGINAS).getText());
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

	private JRadioButton insertarRadioBtn(String titulo) {
		JRadioButton button = new JRadioButton();
		button.setText(titulo);
		button.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 15));
		button.setBackground(new Color(208, 222, 237));
		return button;
	}

	private JButton insertarBtn(String textBtn) {
		JButton btn = new JButton();
		btn.setText(textBtn);
		btn.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		btn.setBackground(new Color(208, 222, 237));
		btn.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		return btn;
	}

	private JTextField insertarJText() {
		JTextField field = new JTextField();
		field.setText(null);
		field.setForeground(Color.BLUE);
		field.setFont(new Font("Monospaced", Font.BOLD, 20));
		field.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		return field;
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
