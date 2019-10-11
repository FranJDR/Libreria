package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import control.Control;
import control.ParaUI;

public class BtnAdd implements ActionListener {

	private Control control;
	private ParaUI paraUI;

	public BtnAdd(Control control, ParaUI paraUI) {
		super();
		this.control = control;
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.paraUI.getTable().getSelectedRow() != -1) {
			String respuesta = JOptionPane.showInputDialog("¿Que cantidad desea añadir?");
			if (respuesta != null) {
				control.aumentarNumLibro(this.paraUI.getDatos()[this.paraUI.getTable().getSelectedRow()][4], respuesta);
				this.paraUI.rellenarTable(control.obtenerDatosLibros(), this.paraUI.getTable());
			}
		} else {
			String respuesta = JOptionPane.showInputDialog("ISBN-CANTIDAD");
			if (respuesta != null) {
				if (Pattern.matches("[0-9]{13}[\\-]{1}[0-9]{1, 200}", respuesta)) {
					String[] dat = respuesta.split("-");
					control.aumentarNumLibro(dat[0], dat[1]);
					this.paraUI.rellenarTable(control.obtenerDatosLibros(), this.paraUI.getTable());
				}
			} else
				JOptionPane.showMessageDialog(null, "Error al introducir los datos.", "error de datos ",
						JOptionPane.WARNING_MESSAGE);
		}
	}

}
