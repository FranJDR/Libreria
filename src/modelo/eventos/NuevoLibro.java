package modelo.eventos;

import control.Control;
import modelo.interfaces.Ejecutable;
import vista.UI;

public class NuevoLibro implements Ejecutable {

	@Override
	public void execute(Control control, UI ui) {
		if (control.insertarLibro(ui.obtenerDatosAltaLibro())) {
			ui.actualizarTabla(control.obtenerDatosLibros());
			ui.limpiarVista();
			ui.actualizarTableHistorico();
		}
	}

}
