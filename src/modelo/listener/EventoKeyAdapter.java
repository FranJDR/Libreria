package modelo.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import control.GestorEventos;
import modelo.enums.NombreEvento;

public class EventoKeyAdapter extends KeyAdapter {

	private NombreEvento evento;

	public EventoKeyAdapter(NombreEvento nombreEvento) {
		super();
		this.evento = nombreEvento;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		GestorEventos.execute(this.evento);
	}

}