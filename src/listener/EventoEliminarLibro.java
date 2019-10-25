package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EventoEliminarLibro implements ActionListener {

	private LogicaEventos logica;

	public EventoEliminarLibro(LogicaEventos logica) {
		super();
		this.logica = logica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (logica.isSelectedRow()) {
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que quieres eliminarlo?");
			if (respuesta == 0) {
				logica.eliminarLibro();
			}
		}
	}

}
