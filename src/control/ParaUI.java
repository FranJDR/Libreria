package control;

import listener.Eventos;
import listener.LogicaEventos;
import modelo.Referencia;
import vista.UI;

public class ParaUI extends UI {

	public ParaUI() {
		super();
		Control control = new Control();
		Eventos eventos = new Eventos(new LogicaEventos(control, this));
		rellenarTable(control.obtenerDatosLibros());

		getBtn(Referencia.BTN_ALTA).addActionListener(eventos.getMasCantidadTable());
		getBtn(Referencia.BTN_BAJA).addActionListener(eventos.getMenosCantidadTable());
		getBtn(Referencia.BTN_ELIMINAR).addActionListener(eventos.getEliminarLibroJTable());
		getBtn(Referencia.BTN_NUEVO).addActionListener(eventos.getNuevoLibro());
		getBtn(Referencia.BTN_VERDETALLES).addActionListener(eventos.getVerDetalles());
		getBtn(Referencia.BTN_MODIFICAR).addActionListener(eventos.getModificarLibro());
		getBtn(Referencia.BTN_BUSCAR).addActionListener(eventos.getBuscar());

	}

}
