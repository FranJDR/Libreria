package control;

import java.util.HashMap;

import modelo.enums.NombreEvento;
import modelo.interfaces.Ejecutable;
import vista.UI;

public class GestorEventos {

	private static Control control;
	private static UI ui;
	private static HashMap<NombreEvento, Ejecutable> listEventos;

	public GestorEventos() {
		control = new Control();
		ui = new UI();
		listEventos = new HashMap<NombreEvento, Ejecutable>();

		ui.actualizarTabla(control.obtenerDatosLibros());
		for (NombreEvento evento : NombreEvento.values()) {
			this.registrarEvento(evento);
		}
	}

	private void registrarEvento(NombreEvento nombre) {
		String nameClass = "modelo.eventos." + nombre;
		try {
			this.listEventos.put(nombre, (Ejecutable) Class.forName(nameClass).newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ejecuta(NombreEvento nombreEvento) {
		listEventos.get(nombreEvento).execute(control, ui);
	}

}
