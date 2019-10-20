package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Referencia;

public class Eventos {

	private LogicaEventos logica;

	public Eventos(LogicaEventos eventos) {
		super();
		this.logica = eventos;
	}

	public ActionListener getBuscar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (logica.existeISBN(logica.getTextFiled(Referencia.FIELD_BUSQUEDAISBN))) {

				}
			}
		};
	}

	public ActionListener getEliminarLibroJTable() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (logica.isSelectedRow()) {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que quieres eliminarlo?");
					if (respuesta == 0) {
						logica.eliminarLibroJTable();
					}
				}
			}
		};
	}

	public ActionListener getMasCantidadTable() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (logica.isSelectedRow()) {
					String cantidad = JOptionPane.showInputDialog("¿Que cantidad desea añadir?");
					if (cantidad != null)
						logica.aumentarCantidadTable(cantidad);
				}
			}
		};
	}

	public ActionListener getMenosCantidadTable() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (logica.isSelectedRow()) {
					String cantidad = JOptionPane.showInputDialog("¿Que cantidad desea quitar?");
					if (cantidad != null)
						logica.reducirCantidadTable(cantidad);
				}
			}
		};
	}

	public ActionListener getModificarLibro() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logica.modificarLibro();
			}
		};
	}

	public ActionListener getVerDetalles() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (logica.isSelectedRow())
					logica.verDetalles();
			}
		};
	}

	public ActionListener getNuevoLibro() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logica.nuevoLibro();
			}
		};
	}

}
