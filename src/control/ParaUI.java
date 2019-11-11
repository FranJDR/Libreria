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
import modelo.enums.ReferenciaButton;
import modelo.enums.ReferenciaDatos;
import modelo.enums.ReferenciaFields;
import vista.UI;

public class ParaUI extends UI {

	public ParaUI() {
		super();
		Control control = new Control();
		LogicaEventos logicaEventos = new LogicaEventos(control, this);
		rellenarTable(control.obtenerDatosLibros());

		getBtn(ReferenciaButton.ALTA).addActionListener(new EventosMasCantidad(logicaEventos));
		getBtn(ReferenciaButton.BAJA).addActionListener(new EventoQuitarCantidad(logicaEventos));
		getBtn(ReferenciaButton.ELIMINAR).addActionListener(new EventoEliminarLibro(logicaEventos));
		getBtn(ReferenciaButton.NUEVO).addActionListener(new EventoNuevoLibro(logicaEventos));
		getBtn(ReferenciaButton.VERDETALLES).addActionListener(new EventoVerDetalles(logicaEventos));
		getBtn(ReferenciaButton.MODIFICAR).addActionListener(new EventoModificar(logicaEventos));

		getField(ReferenciaFields.BUSQUEDAISBN).addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				logicaEventos.buscarISBN();
			}
		});
	}
}
