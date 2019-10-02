package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Libro;
import modelo.Tematica;
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
						String titulo = listCampos.get(0).getText();
						String autor = listCampos.get(1).getText();
						String paginas = listCampos.get(3).getText();
						Tematica tematica = obtenerTematica();
						String ISBN = listCampos.get(4).getText();
						String precio = listCampos.get(5).getText();

						Libro libro = new Libro(titulo, autor, ISBN, paginas, tematica, precio, obtenerFormato(),
								obtenerEstado());

						if (validador.validarLibro(libro)) {
							if (control.validarIsbn(ISBN)) {
								control.insertarLibro(libro);
								rellenarTable(control.getLibros(), table);
								vaciarCampos();
							} else {
								validador.WarningMessage("El ISBN ya existe.");
							}
						}

					} else {
						validador.WarningMessage("Debes marcar estado.");
					}
				} else {
					validador.WarningMessage("Debes marcar formato.");
				}
			}
		});

	}

}
