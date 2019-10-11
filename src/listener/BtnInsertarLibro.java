package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Control;
import control.ParaUI;

public class BtnInsertarLibro implements ActionListener {

	private Control control;
	private ParaUI paraUI;

	public BtnInsertarLibro(Control control, ParaUI paraUI) {
		super();
		this.control = control;
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		fvr();
	}

	private void fvr() {
		if (this.paraUI.isSelectFormato() && this.paraUI.isSelectEstado()) {
			if (control.insertarLibro(this.paraUI.obtenerTematica(), this.paraUI.obtenerMap())) {
				this.paraUI.rellenarTable(this.control.obtenerDatosLibros(), this.paraUI.getTable());
				this.paraUI.vaciarCampos();
			}
		}
	}

}
