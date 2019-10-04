package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.UI;

public class ParaUI extends UI {

	private Control control = new Control();

	public ParaUI() {
		super();
		listenerBtn();
	}

	private void listenerBtn() {

		this.btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		this.btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = table.getSelectedRow();
				if (indice >= 0) {
					control.eliminarLibro(datos[indice][0]);
					rellenarTable(control.getLibros(), table);
				}
			}
		});

		this.btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isSelectFormato() && isSelectEstado()) {
					if (control.insertarLibro(obtenerTematica(), obtenerMap())) {
						rellenarTable(control.getLibros(), table);
						vaciarCampos();
					}
				}
			}
		});

	}

}
