package listener;

import java.util.HashMap;

import javax.swing.JOptionPane;

import control.Control;
import control.ParaUI;
import modelo.Referencia;
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
		if (this.paraUI.isEmptyField(Referencia.FIELD_BUSQUEDAISBN)) {
			this.actualizarJTable();
		} else {
			this.paraUI.rellenarTable(this.control.getDatosPorBusqueda(this.paraUI.getDatos(),
					this.paraUI.getTextField(Referencia.FIELD_BUSQUEDAISBN)));
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
		String[] datos = new String[6];
		for (int i = 0; i < datos.length; i++)
			datos[i] = this.paraUI.getDatos()[this.paraUI.getTable().getSelectedRow()][i];
		this.paraUI.setPanelInfo(new PanelInfo(datos, this.paraUI.getBtn(Referencia.BTN_MODIFICAR), this.paraUI));
	}

	public void modificarLibro() {
		HashMap<Referencia, String> map = this.paraUI.getMapPanelInfo();
		this.control.modificarLibro(map.get(Referencia.ISBN), map);
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

	public void aumentarCantidadTable(String cantidad) {
		this.aumentarCantidad(this.obtenerISBNTable(), cantidad);
	}

	public void reducirCantidadTable(String cantidad) {
		this.reducirCantidad(this.obtenerISBNTable(), cantidad);
	}

	public void eliminarLibroJTable() {
		this.eliminarLibro(this.obtenerISBNTable());
	}

	private void eliminarLibro(String isbn) {
		this.control.eliminarLibro(isbn);
		actualizarJTable();
	}

	private void aumentarCantidad(String isbn, String cantidad) {
		control.aumentarNumLibro(isbn, cantidad);
		actualizarJTable();
	}

	private void reducirCantidad(String isbn, String cantidad) {
		this.control.reducirNumLibro(isbn, cantidad);
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

	public String getTextFiled(Referencia referencia) {
		return this.paraUI.getTextField(referencia);
	}

}
