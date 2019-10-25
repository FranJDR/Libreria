package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoVerDetalles implements ActionListener {

	private LogicaEventos logica;

	public EventoVerDetalles(LogicaEventos logica) {
		super();
		this.logica = logica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (logica.isSelectedRow())
			logica.verDetalles();
	}

}
