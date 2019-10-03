package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import modelo.Referencia;
import modelo.Validador;
import vista.UI;

public class ParaUI extends UI {

	private Control control = new Control();
	private Validador validador = new Validador();

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

				if (isSelectFormato()) {
					if (isSelectEstado()) {
						HashMap<Referencia, String> map = obtenerMap();
						if (validador.validarLibro(map)) {
							if (control.validarIsbn(map.get("isbn"))) {
								control.insertarLibro(obtenerTematica(), map);
								rellenarTable(control.getLibros(), table);
								vaciarCampos();
							} else
								validador.WarningMessage("El ISBN ya existe.");
						}
					} else
						validador.WarningMessage("Debes marcar estado.");
				} else
					validador.WarningMessage("Debes marcar formato.");
			}
		});

	}

}
