package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoModificar implements ActionListener {

	private LogicaEventos logica;

	public EventoModificar(LogicaEventos logica) {
		super();
		this.logica = logica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		logica.modificarLibro();
	};

}
