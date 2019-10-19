package control;

import listener.BtnBuscarISBN;
import listener.BtnEliminarLibro;
import listener.BtnModificar;
import listener.BtnNuevoLibro;
import listener.BtnVerDetalles;
import listener.masCantidad.BtnMasCantidadTable;
import listener.menosCantidad.BtnMenosCantidadTable;
import modelo.Referencia;
import vista.UI;

public class ParaUI extends UI {

	public ParaUI() {
		super();
		Control control = new Control();

		rellenarTable(control.obtenerDatosLibros());

		getBtn(Referencia.BTN_NUEVO).addActionListener(new BtnNuevoLibro(control, this));
		getBtn(Referencia.BTN_ALTA).addActionListener(new BtnMasCantidadTable(control, this));
		getBtn(Referencia.BTN_BAJA).addActionListener(new BtnMenosCantidadTable(control, this));
		getBtn(Referencia.BTN_ELIMINAR).addActionListener(new BtnEliminarLibro(control, this));
		getBtn(Referencia.BTN_MODIFICAR).addActionListener(new BtnModificar(control, this));
		getBtn(Referencia.BTN_VERDETALLES).addActionListener(new BtnVerDetalles(this));
		getBtn(Referencia.BTN_BUSCAR).addActionListener(new BtnBuscarISBN(this, control));
	}

}
