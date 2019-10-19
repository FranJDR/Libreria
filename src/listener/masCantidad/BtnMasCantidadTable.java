package listener.masCantidad;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import control.Control;
import control.ParaUI;

public class BtnMasCantidadTable extends BtnMasCantidad {

	public BtnMasCantidadTable(Control control, ParaUI paraUI) {
		super(control, paraUI);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.paraUI.getTable().getSelectedRow() != -1) {
			String cantidad = JOptionPane.showInputDialog("¿Que cantidad desea añadir?");
			if (cantidad != null) {
				this.cantidad = cantidad;
				this.isbn = paraUI.getDatos()[this.paraUI.getTable().getSelectedRow()][4];
				super.actionPerformed(e);
			}
		} else
			JOptionPane.showMessageDialog(null, "Debes seleccionar un libro de la tabla.", "error de datos ",
					JOptionPane.WARNING_MESSAGE);
	}

}
