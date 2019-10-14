package listener;

import java.awt.event.ActionEvent;

import control.Control;
import control.ParaUI;

public class BtnBaja extends BtnAddBaja {

	public BtnBaja(Control control, ParaUI paraUI) {
		super(control, paraUI);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (!isNull(respuesta)) {
			this.control.reducirNumLibro(this.paraUI.getDatos()[this.paraUI.getTable().getSelectedRow()][4], respuesta);
			this.paraUI.rellenarTable(control.obtenerDatosLibros(), this.paraUI.getTable());
		}
		if (validarDatos(isbn, cantidad)) {
			control.reducirNumLibro(isbn, cantidad);
			this.paraUI.rellenarTable(control.obtenerDatosLibros(), this.paraUI.getTable());
		}
	}
}
