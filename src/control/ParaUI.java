package control;

import listener.BtnAdd;
import listener.BtnBaja;
import listener.BtnEliminarLibro;
import listener.BtnInsertarLibro;
import listener.BtnSalir;
import vista.UI;

public class ParaUI extends UI {

	public ParaUI() {
		super();
		Control control = new Control();

		rellenarTable(control.obtenerDatosLibros(), getTable());

		getBtnAdd().addActionListener(new BtnAdd(control, this));
		getBtnBaja().addActionListener(new BtnBaja(control, this));
		getBtnEliminar().addActionListener(new BtnEliminarLibro(control, this));
		getBtnNuevo().addActionListener(new BtnInsertarLibro(control, this));
		getBtnSalir().addActionListener(new BtnSalir());

	}

}
