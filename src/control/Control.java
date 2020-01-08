package control;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Validador;
import modelo.enums.Libro;

public class Control {

	private Validador validador = new Validador();
	private Logica logica;

	public Control() {
		super();
		this.logica = new Logica();
	}

	public void eliminarLibro(String ISBN) {
		this.logica.eliminarLibro(ISBN);
	}

	public boolean insertarLibro(HashMap<Libro, String> map) {
		return this.validador.validarLibro(map) && this.logica.validarIsbn(map.get(Libro.ISBN))
				? this.logica.insertarLibro(map)
				: false;
	}

	public void modifcarCantidadLibro(String ISBN, int cantidad) {
		this.logica.modifcarCantidadLibro(ISBN, cantidad);
	}

	public String[][] obtenerDatosLibros() {
		return this.logica.obtenerDatosLibros();
	}

	public void modificarPrecio(String ISBN, String precio) {
		if (this.validador.isNumber(ISBN))
			this.logica.modificarPrecio(ISBN, precio);
	}

	public void insertarTema(String tema) {
		if (this.validador.isLetter(tema)) {
			this.logica.insertarTema(tema);
		}
	}

	public void eliminarTema(String tema) {
		this.logica.eliminarTema(tema);
	}

	public void eliminarEditorial(String editorial) {
		this.logica.eliminarEditorial(editorial);
	}

	public void insertarEditorial(String editorial) {
		if (this.validador.isLetter(editorial)) {
			this.logica.insertarEditorial(editorial);
		}
	}

	public boolean temaEnUso(String tema) {
		return this.logica.temaEnUso(tema);
	}

	public boolean editorialEnUso(String editorial) {
		return this.logica.editorialEnUso(editorial);
	}

	public ArrayList<String> getListISBN() {
		return this.logica.getListISBN();
	}

	public boolean isNumber(String cadena) {
		return this.validador.isNumber(cadena);
	}

	public boolean existeISBN(String ISBN) {
		return this.logica.validarIsbn(ISBN);
	}

	public String[][] getDatosPorBusqueda(String[][] datos, String cadena) {
		return this.logica.getDatosPorBusqueda(datos, cadena);
	}
}
