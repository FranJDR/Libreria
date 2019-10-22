package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import listener.Eventos;
import listener.LogicaEventos;
import modelo.Referencia;
import vista.UI;

public class ParaUI extends UI {

	public ParaUI() {
		super();
		Control control = new Control();
		LogicaEventos logicaEventos = new LogicaEventos(control, this);
		Eventos eventos = new Eventos(logicaEventos);
		rellenarTable(control.obtenerDatosLibros());

		getBtn(Referencia.BTN_ALTA).addActionListener(eventos.getMasCantidadTable());
		getBtn(Referencia.BTN_BAJA).addActionListener(eventos.getMenosCantidadTable());
		getBtn(Referencia.BTN_ELIMINAR).addActionListener(eventos.getEliminarLibroJTable());
		getBtn(Referencia.BTN_NUEVO).addActionListener(eventos.getNuevoLibro());
		getBtn(Referencia.BTN_VERDETALLES).addActionListener(eventos.getVerDetalles());
		getBtn(Referencia.BTN_MODIFICAR).addActionListener(eventos.getModificarLibro());
		getBtn(Referencia.BTN_BUSCAR).addActionListener(eventos.getBuscar());

		getField(Referencia.FIELD_BUSQUEDAISBN).addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				logicaEventos.buscarISBN();
			}
		});
	}
}
