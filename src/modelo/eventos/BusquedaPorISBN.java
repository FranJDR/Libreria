package modelo.eventos;

import control.Control;
import modelo.interfaces.Ejecutable;
import vista.UI;

public class BusquedaPorISBN implements Ejecutable {

	@Override
	public void execute(Control control, UI ui) {
		if (ui.getTextbusquedaISBN().getText().isEmpty()) {
			ui.actualizarTabla(control.obtenerDatosLibros());
		} else {
			ui.actualizarTabla(control.getDatosPorBusqueda(ui.getDatos(), ui.getTextbusquedaISBN().getText()));
		}
	}

}
