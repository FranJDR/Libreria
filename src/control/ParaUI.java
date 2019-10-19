package control;

import listener.BtnAdd;
import listener.BtnBaja;
import listener.BtnBuscarISBN;
import listener.BtnEliminarLibro;
import listener.BtnModificar;
import listener.BtnNuevoLibro;
import listener.BtnVerDetalles;
import modelo.Referencia;
import vista.UI;

public class ParaUI extends UI {

	public ParaUI() {
		super();
		Control control = new Control();

		rellenarTable(control.obtenerDatosLibros(), getTable());

		getBtn(Referencia.BTN_NUEVO).addActionListener(new BtnNuevoLibro(control, this));
		getBtn(Referencia.BTN_ALTA).addActionListener(new BtnAdd(control, this));
		getBtn(Referencia.BTN_BAJA).addActionListener(new BtnBaja(control, this));
		getBtn(Referencia.BTN_ELIMINAR).addActionListener(new BtnEliminarLibro(control, this));
		getBtn(Referencia.BTN_MODIFICAR).addActionListener(new BtnModificar(control, this));
		getBtn(Referencia.BTN_VERDETALLES).addActionListener(new BtnVerDetalles(this));
		getBtn(Referencia.BTN_BUSCAR).addActionListener(new BtnBuscarISBN(this, control));
	}

}
