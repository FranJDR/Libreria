package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import control.Control;
import control.ParaUI;

public class BtnAddBaja implements ActionListener {

	protected Control control;
	protected ParaUI paraUI;

	protected String respuesta;
	protected String cantidad;
	protected String isbn;

	public BtnAddBaja(Control control, ParaUI paraUI) {
		super();
		this.control = control;
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.paraUI.getTable().getSelectedRow() != -1) {
			respuesta = JOptionPane.showInputDialog("¿Que cantidad desea añadir?");
		} else {
			isbn = JOptionPane.showInputDialog("Introduce el ISBN.");
			cantidad = JOptionPane.showInputDialog("Introduce la Cantidad.");
		}
	}

	protected boolean validarDatos(String isbn, String cantidad) {
		if (!isNull(isbn) && !isNull(cantidad))
			return validarIsbn(isbn) && validarCantidad(cantidad);
		return false;
	}

	protected boolean isNull(String cadena) {
		return cadena == null;
	}

	protected boolean validarIsbn(String cadena) {
		return Pattern.matches("[0-9]{13}", cadena);
	}

	protected boolean validarCantidad(String cadena) {
		return Pattern.matches("[0-9]{1,200}", cadena);
	}

}
