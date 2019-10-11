package control;

import listener.BtnAdd;
import listener.BtnBaja;
import listener.BtnEliminarLibro;
import listener.BtnModificar;
import listener.BtnNuevoLibro;
import listener.BtnSalir;
import listener.BtnVerDetalles;
import vista.UI;

public class ParaUI extends UI {

	public ParaUI() {
		super();
		Control control = new Control();

		rellenarTable(control.obtenerDatosLibros(), getTable());

		getBtnAdd().addActionListener(new BtnAdd(control, this));
		getBtnBaja().addActionListener(new BtnBaja(control, this));
		getBtnEliminar().addActionListener(new BtnEliminarLibro(control, this));
		getBtnModificar().addActionListener(new BtnModificar(control, this));
		getBtnNuevo().addActionListener(new BtnNuevoLibro(control, this));
		getBtnSalir().addActionListener(new BtnSalir());
		getBtnVerDetalles().addActionListener(new BtnVerDetalles(this));

	}

}
