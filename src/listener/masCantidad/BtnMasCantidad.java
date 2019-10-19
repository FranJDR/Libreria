package listener.masCantidad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Control;
import control.ParaUI;

abstract class BtnMasCantidad implements ActionListener {

	protected Control control;
	protected ParaUI paraUI;

	protected String cantidad;
	protected String isbn;

	public BtnMasCantidad(Control control, ParaUI paraUI) {
		super();
		this.control = control;
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		control.aumentarNumLibro(this.isbn, this.cantidad);
		paraUI.rellenarTable(control.obtenerDatosLibros());
		this.cantidad = null;
		this.isbn = null;
	}

}
