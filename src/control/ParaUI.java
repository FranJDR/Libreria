package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import listener.EventoEliminarLibro;
import listener.EventoModificar;
import listener.EventoNuevoLibro;
import listener.EventoQuitarCantidad;
import listener.EventoVerDetalles;
import listener.EventosMasCantidad;
import listener.LogicaEventos;
import modelo.Referencia;
import vista.UI;

public class ParaUI extends UI {

	public ParaUI() {
		super();
		Control control = new Control();
		LogicaEventos logicaEventos = new LogicaEventos(control, this);
		rellenarTable(control.obtenerDatosLibros());

		getBtn(Referencia.BTN_ALTA).addActionListener(new EventosMasCantidad(logicaEventos));
		getBtn(Referencia.BTN_BAJA).addActionListener(new EventoQuitarCantidad(logicaEventos));
		getBtn(Referencia.BTN_ELIMINAR).addActionListener(new EventoEliminarLibro(logicaEventos));
		getBtn(Referencia.BTN_NUEVO).addActionListener(new EventoNuevoLibro(logicaEventos));
		getBtn(Referencia.BTN_VERDETALLES).addActionListener(new EventoVerDetalles(logicaEventos));
		getBtn(Referencia.BTN_MODIFICAR).addActionListener(new EventoModificar(logicaEventos));

		getField(Referencia.FIELD_BUSQUEDAISBN).addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				logicaEventos.buscarISBN();
			}
		});
	}
}
