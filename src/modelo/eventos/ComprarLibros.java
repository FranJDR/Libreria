package modelo.eventos;

import javax.swing.JOptionPane;

import control.Control;
import modelo.interfaces.Ejecutable;
import vista.UI;

public class ComprarLibros implements Ejecutable {

	@Override
	public void execute(Control control, UI ui) {
		if (ui.isSelectRowTable()) {
			String cantidad = JOptionPane.showInputDialog("¿Que cantidad deseas añadir?");
			if (cantidad != null) {
				if (control.isNumber(cantidad) && ui.isSelectRowTable()) {
					control.modifcarCantidadLibro(ui.obtenerISBNTable(), Integer.valueOf(cantidad));
					ui.actualizarTabla(control.obtenerDatosLibros());
					ui.actualizarTableHistorico();
				}
			}
		}
	}

}
