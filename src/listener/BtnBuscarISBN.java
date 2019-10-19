package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import control.Control;
import control.ParaUI;

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
		String isbn = JOptionPane.showInputDialog("Introduce ISBN.");
		if (validarIsbn(isbn)) {

		} else
			WarningMessage("No se ha encotrando el ISBN");
	}

	public boolean validarIsbn(String isbn) {
		if (isbn == null)
			return false;
		return this.control.existeISBN(isbn);
	}

	public void WarningMessage(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "error de datos ", JOptionPane.WARNING_MESSAGE);
	}

}
