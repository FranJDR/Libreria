package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.Control;
import control.ParaUI;

public class BtnBaja implements ActionListener {

	private Control control;
	private ParaUI paraUI;

	public BtnBaja(Control control, ParaUI paraUI) {
		super();
		this.control = control;
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.paraUI.getTable().getSelectedRow() != -1) {
			String respuesta = JOptionPane.showInputDialog("¿Que cantidad desea dar de baja?");
			if (respuesta != null) {
				this.control.reducirNumLibro(this.paraUI.getDatos()[this.paraUI.getTable().getSelectedRow()][4],
						respuesta);
				this.paraUI.rellenarTable(control.obtenerDatosLibros(), this.paraUI.getTable());
			}
		} else
			JOptionPane.showMessageDialog(null, "Selecciona un fila de la tabla.", "error de datos ",
					JOptionPane.WARNING_MESSAGE);
	}

}
