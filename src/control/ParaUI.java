package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JOptionPane;

import modelo.Referencia;
import vista.PanelInfo;
import vista.UI;

public class ParaUI extends UI {

	private Control control = new Control();

	public ParaUI() {
		super();
		listenerBtn();
		rellenarTable(control.obtenerDatosLibros(), table);
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
				if (indice != -1) {
					control.eliminarLibro(datos[indice][4]);
					rellenarTable(control.obtenerDatosLibros(), table);
				}
			}
		});

		this.btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isSelectFormato() && isSelectEstado()) {
					if (control.insertarLibro(obtenerTematica(), obtenerMap())) {
						rellenarTable(control.obtenerDatosLibros(), table);
						vaciarCampos();
					}
				}
			}
		});

		this.btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					String respuesta = JOptionPane.showInputDialog("¿Que cantidad desea añadir?");
					if (respuesta != null) {
						control.aumentarNumLibro(datos[table.getSelectedRow()][4], respuesta);
						rellenarTable(control.obtenerDatosLibros(), table);
					}
				} else
					JOptionPane.showMessageDialog(null, "Selecciona un fila de la tabla.", "error de datos ",
							JOptionPane.WARNING_MESSAGE);
			}
		});

		this.btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashMap<Referencia, String> map = panelInfo.getMap();
				control.modificarLibro(map.get(Referencia.isbn), map);
				rellenarTable(control.obtenerDatosLibros(), table);
			}
		});

		this.btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() != -1) {
					String respuesta = JOptionPane.showInputDialog("¿Que cantidad desea dar de baja?");
					if (respuesta != null) {
						control.reducirNumLibro(datos[table.getSelectedRow()][4], respuesta);
						rellenarTable(control.obtenerDatosLibros(), table);
					}
				} else
					JOptionPane.showMessageDialog(null, "Selecciona un fila de la tabla.", "error de datos ",
							JOptionPane.WARNING_MESSAGE);
			}
		});

	}

}
