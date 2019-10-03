package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import modelo.Libro;
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

	public boolean validarIsbn(String isbn) {
		for (Libro libro : libros)
			if (libro.getISBN().equals(isbn))
				return false;
		return true;
	}

	public void insertarLibro(Tematica tematica, HashMap<String, String> map) {
		this.libros.add(new Libro(map.get("titulo"), map.get("autor"), map.get(key), paginas, tema, precio, formato, estado))
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

}
