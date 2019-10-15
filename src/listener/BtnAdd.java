package listener;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import control.Control;
import control.ParaUI;

public class BtnAdd extends BtnAddBaja {

	public BtnAdd(Control control, ParaUI paraUI) {
		super(control, paraUI);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		boolean bandera = isNull(this.respuesta);

		if (!bandera) {
			control.aumentarNumLibro(this.paraUI.getDatos()[this.paraUI.getTable().getSelectedRow()][4], respuesta);
			this.paraUI.rellenarTable(control.obtenerDatosLibros(), this.paraUI.getTable());
		}

		if (bandera) {
			if (validarDatos(isbn, cantidad)) {
				control.aumentarNumLibro(isbn, cantidad);
				this.paraUI.rellenarTable(control.obtenerDatosLibros(), this.paraUI.getTable());
			} else
				JOptionPane.showMessageDialog(null, "Datos erroneos!!", "error de datos ", JOptionPane.WARNING_MESSAGE);
		}

	}

}
