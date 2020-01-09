package modelo.eventos;

import control.Control;
import modelo.interfaces.Ejecutable;
import vista.UI;

import javax.swing.*;

public class EliminarLibro implements Ejecutable {

	@Override
	public void execute(Control control, UI ui) {
		if (ui.isSelectRowTable()) {
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres eliminarlo?");
			if (respuesta == 0) {
				control.eliminarLibro(ui.obtenerISBNTable());
				ui.actualizarTabla(control.obtenerDatosLibros());
				ui.actualizarTableHistorico();
			}
		}
	}

}
