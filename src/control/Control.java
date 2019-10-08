package control;

import java.util.HashMap;

import modelo.Libreria;
import modelo.Referencia;
import modelo.Tematica;
import modelo.Validador;

public class Control {

	private Validador validador = new Validador();
	private Libreria libreria;

	public Control() {
		super();
		this.libreria = new Libreria();
	}

	public void eliminarLibro(String ISBN) {
		this.libreria.eliminarLibro(ISBN);
	}

	public boolean insertarLibro(Tematica tematica, HashMap<Referencia, String> map) {
		return this.validador.validarLibro(map) && this.libreria.validarIsbn(map.get(Referencia.isbn))
				? this.libreria.insertarLibro(tematica, map)
				: false;
	}

	public String[][] obtenerDatosLibros() {
		return this.libreria.obtenerDatosLibros();
	}

}
