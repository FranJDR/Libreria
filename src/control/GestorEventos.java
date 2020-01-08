package control;

import modelo.enums.NombreEvento;
import modelo.interfaces.Ejecutable;
import vista.UI;

public class GestorEventos {

	private static Control control = new Control();
	private static UI ui = new UI();

	public GestorEventos() {
		this.ui.actualizarTabla(this.control.obtenerDatosLibros());
	}

	public static void execute(NombreEvento nombreEvento) {
		String nameClass = "modelo.eventos." + nombreEvento;
		Object object = null;
		try {
			object = Class.forName(nameClass).newInstance();
			((Ejecutable) object).execute(control, ui);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
