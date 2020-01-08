package modelo.eventos;

import javax.swing.JOptionPane;

import control.Control;
import modelo.interfaces.Ejecutable;
import vista.UI;

public class ModificarPrecioLibro implements Ejecutable {

	@Override
	public void execute(Control control, UI ui) {
		if (ui.isSelectRowTable()) {
			String precio = JOptionPane.showInputDialog("¿Que precio deseas ponerle?");
			if (precio != null) {
				if (control.isNumber(precio)) {
					control.modificarPrecio(ui.obtenerISBNTable(), precio);
					ui.actualizarTabla(control.obtenerDatosLibros());
					ui.actualizarTableHistorico();
				}
			}
		}
	}

}
