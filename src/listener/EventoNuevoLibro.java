package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoNuevoLibro implements ActionListener {

	private LogicaEventos logica;

	public EventoNuevoLibro(LogicaEventos logica) {
		super();
		this.logica = logica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		logica.nuevoLibro();
	}

}
