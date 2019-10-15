package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import control.Control;
import control.ParaUI;
import modelo.Referencia;

public class BtnNuevoLibro implements ActionListener {

	private Control control;
	private ParaUI paraUI;

	public BtnNuevoLibro(Control control, ParaUI paraUI) {
		super();
		this.control = control;
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		fvr();
	}

	private void fvr() {
		if (this.paraUI.isSelectFormato() && this.paraUI.isSelectEstado()) {
			HashMap<Referencia, String> map = this.paraUI.obtenerMap();
			if (validarSinCeros(map.get(Referencia.PRECIO)) && validarSinCeros(map.get(Referencia.PAGINAS))) {
				if (control.insertarLibro(this.paraUI.obtenerTematica(), map)) {
					this.paraUI.rellenarTable(this.control.obtenerDatosLibros(), this.paraUI.getTable());
					this.paraUI.vaciarCampos();
				}
			} else
				JOptionPane.showMessageDialog(null, "Paginas y precio debe ser mayor de 0.", "error de datos ",
						JOptionPane.WARNING_MESSAGE);
		}
	}

	private boolean validarSinCeros(String cadena) {
		return Pattern.matches("[1-9]{1}[1-9]{0,200}", cadena);
	}

}
