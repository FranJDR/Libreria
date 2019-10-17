package control;

import java.util.HashMap;

import modelo.Referencia;
import modelo.Tematica;
import modelo.Validador;

public class Control {

	private Validador validador = new Validador();
	private Logica libreria;

	public Control() {
		super();
		this.libreria = new Logica();
	}

	public void eliminarLibro(String ISBN) {
		this.libreria.eliminarLibro(ISBN);
	}

	public boolean insertarLibro(Tematica tematica, HashMap<Referencia, String> map) {
		return this.validador.validarLibro(map) && this.libreria.validarIsbn(map.get(Referencia.ISBN))
				? this.libreria.insertarLibro(tematica, map)
				: false;
	}

	public void aumentarNumLibro(String ISBN, String cantidad) {
		if (this.validador.isNumber(cantidad))
			this.libreria.aumentarNumLibro(ISBN, Integer.parseInt(cantidad));
	}

	public void reducirNumLibro(String ISBN, String cantidad) {
		if (this.validador.isNumber(cantidad))
			this.libreria.reducirNumLibro(ISBN, Integer.parseInt(cantidad));
	}

	public String[][] obtenerDatosLibros() {
		return this.libreria.obtenerDatosLibros();
	}

	public void modificarLibro(String ISBN, HashMap<Referencia, String> map) {
		if (this.validador.isNumber(ISBN))
			this.libreria.modificarLibro(ISBN, map);
	}

}
