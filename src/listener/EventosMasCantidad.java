package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EventosMasCantidad implements ActionListener {

	private LogicaEventos logica;

	public EventosMasCantidad(LogicaEventos logica) {
		super();
		this.logica = logica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (logica.isSelectedRow()) {
			String cantidad = JOptionPane.showInputDialog("¿Que cantidad desea añadir?");
			if (cantidad != null)
				logica.aumentarCantidad(cantidad);
		}
	}

}
