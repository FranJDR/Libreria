package modelo.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.GestorEventos;
import modelo.enums.NombreEvento;

public class Evento implements ActionListener {

	private final NombreEvento evento;

	public Evento(NombreEvento nombreEvento) {
		super();
		this.evento = nombreEvento;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GestorEventos.execute(this.evento);
	}

}
