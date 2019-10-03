package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import modelo.Libro;
import modelo.Referencia;
import modelo.Tematica;
import modelo.Validador;

public class Control {

	private Validador validador = new Validador();
	private ArrayList<Libro> libros = new ArrayList<Libro>();

	public void eliminarLibro(String ISBN) {
		for (Iterator iterator = libros.iterator(); iterator.hasNext();) {
			Libro libro = (Libro) iterator.next();
			if (libro.getISBN() == ISBN) {
				iterator.remove();
			}
		}
	}

	private boolean validarIsbn(String isbn) {
		for (Libro libro : libros)
			if (libro.getISBN().equals(isbn)) {
				this.validador.WarningMessage("El ISBN ya existe.");
				return false;
			}
		return true;
	}

	public boolean insertarLibro(Tematica tematica, HashMap<Referencia, String> map) {
		return this.validador.validarLibro(map) && validarIsbn(map.get(Referencia.isbn))
				? this.libros.add(new Libro(map.get(Referencia.titulo), map.get(Referencia.autor),
						map.get(Referencia.isbn), map.get(Referencia.paginas), tematica, map.get(Referencia.precio),
						map.get(Referencia.formato), map.get(Referencia.estado)))
				: false;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

}
