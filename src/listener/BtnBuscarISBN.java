package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import control.Control;
import control.ParaUI;
import modelo.Referencia;

public class BtnBuscarISBN implements ActionListener {

	private ParaUI paraUI;
	private Control control;

	public BtnBuscarISBN(ParaUI paraUI, Control control) {
		super();
		this.paraUI = paraUI;
		this.control = control;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (validarIsbn(this.paraUI.getTextField(Referencia.FIELD_BUSQUEDAISBN))) {

		} else
			WarningMessage("No se ha encotrando el ISBN");
	}

	public boolean validarIsbn(String isbn) {
		if (isbn == null)
			return false;
		return this.control.getListISBN().contains(isbn);
	}

	public void WarningMessage(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "error de datos ", JOptionPane.WARNING_MESSAGE);
	}

}
