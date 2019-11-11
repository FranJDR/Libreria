package listener;

import java.util.HashMap;

import javax.swing.JOptionPane;

import control.Control;
import control.ParaUI;
import modelo.enums.ReferenciaDatos;
import modelo.enums.ReferenciaFields;
import vista.PanelInfo;

public class LogicaEventos {

	private Control control;
	private ParaUI paraUI;

	public LogicaEventos(Control control, ParaUI paraUI) {
		super();
		this.control = control;
		this.paraUI = paraUI;
	}

	public void buscarISBN() {
		if (this.paraUI.isEmptyField(ReferenciaFields.BUSQUEDAISBN)) {
			this.actualizarJTable();
		} else {
			this.paraUI.rellenarTable(this.control.getDatosPorBusqueda(this.paraUI.getDatos(),
					this.paraUI.getTextField(ReferenciaFields.BUSQUEDAISBN)));
		}
	}

	public void nuevoLibro() {
		if (this.isSelectFormatoEstado()) {
			if (this.control.insertarLibro(this.paraUI.getDatosField())) {
				this.actualizarJTable();
				this.paraUI.limpiarVista();
			}
		}
	}

	public void verDetalles() {
		this.paraUI.getInciarPanelInfo();
	}

	public void modificarLibro() {
		HashMap<ReferenciaDatos, String> map = this.paraUI.getMapPanelInfo();
		this.control.modificarLibro(map.get(ReferenciaDatos.ISBN), map);
		this.paraUI.rellenarTable(control.obtenerDatosLibros());
	}

	public boolean existeISBN(String isbn) {
		if (isbn == null)
			return false;
		if (this.control.getListISBN().contains(isbn))
			return true;
		JOptionPane.showMessageDialog(null, "No se ha encontrado el ISBN.", "error de datos ",
				JOptionPane.WARNING_MESSAGE);
		return false;
	}

	private boolean isSelectFormatoEstado() {
		return this.paraUI.isSelectEstado() && this.paraUI.isSelectFormato();
	}

	public void aumentarCantidad(String cantidad) {
		control.aumentarNumLibro(this.obtenerISBNTable(), cantidad);
		actualizarJTable();
	}

	public void reducirCantidad(String cantidad) {
		this.control.reducirNumLibro(this.obtenerISBNTable(), cantidad);
		actualizarJTable();
	}

	public void eliminarLibro() {
		this.control.eliminarLibro(this.obtenerISBNTable());
		actualizarJTable();
	}

	private void actualizarJTable() {
		this.paraUI.rellenarTable(this.control.obtenerDatosLibros());
	}

	private String obtenerISBNTable() {
		return this.paraUI.getDatos()[this.paraUI.getTable().getSelectedRow()][4];
	}

	public boolean isSelectedRow() {
		if (this.paraUI.getTable().getSelectedRow() != -1)
			return true;
		JOptionPane.showMessageDialog(null, "Selecciona un fila de la tabla.", "error de datos ",
				JOptionPane.WARNING_MESSAGE);
		return false;
	}

	public String getTextFiled(ReferenciaFields referencia) {
		return this.paraUI.getTextField(referencia);
	}

}
