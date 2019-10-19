package control;

import java.util.HashMap;

import modelo.Referencia;
import modelo.Tematica;
import modelo.Validador;

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

	public boolean insertarLibro(HashMap<Referencia, String> map) {
		return this.validador.validarLibro(map) && this.logica.validarIsbn(map.get(Referencia.ISBN))
				? this.logica.insertarLibro(map)
				: false;
	}

	public void aumentarNumLibro(String ISBN, String cantidad) {
		if (this.validador.isNumber(cantidad))
			this.logica.aumentarNumLibro(ISBN, Integer.parseInt(cantidad));
	}

	public void reducirNumLibro(String ISBN, String cantidad) {
		if (this.validador.isNumber(cantidad))
			this.logica.reducirNumLibro(ISBN, Integer.parseInt(cantidad));
	}

	public String[][] obtenerDatosLibros() {
		return this.logica.obtenerDatosLibros();
	}

	public void modificarLibro(String ISBN, HashMap<Referencia, String> map) {
		if (this.validador.isNumber(ISBN))
			this.logica.modificarLibro(ISBN, map);
	}

	public boolean existeISBN(String ISBN) {
		return this.logica.validarIsbn(ISBN);
	}

}
