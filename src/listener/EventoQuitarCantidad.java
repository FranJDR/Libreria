package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EventoQuitarCantidad implements ActionListener {

	private LogicaEventos logica;

	public EventoQuitarCantidad(LogicaEventos logica) {
		super();
		this.logica = logica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (logica.isSelectedRow()) {
			String cantidad = JOptionPane.showInputDialog("¿Que cantidad desea quitar?");
			if (cantidad != null)
				logica.reducirCantidad(cantidad);
		}

	}

}
