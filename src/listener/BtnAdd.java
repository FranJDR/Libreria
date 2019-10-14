package listener;

import java.awt.event.ActionEvent;

import control.Control;
import control.ParaUI;

public class BtnAdd extends BtnAddBaja {

	public BtnAdd(Control control, ParaUI paraUI) {
		super(control, paraUI);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (!isNull(respuesta)) {
			control.aumentarNumLibro(this.paraUI.getDatos()[this.paraUI.getTable().getSelectedRow()][4], respuesta);
			this.paraUI.rellenarTable(control.obtenerDatosLibros(), this.paraUI.getTable());
		}
		if (validarDatos(isbn, cantidad)) {
			control.aumentarNumLibro(isbn, cantidad);
			this.paraUI.rellenarTable(control.obtenerDatosLibros(), this.paraUI.getTable());
		}
	}

}
