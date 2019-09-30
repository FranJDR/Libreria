package control;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.Libro;

public class Control {

	private ArrayList<Libro> libros = new ArrayList<Libro>();

	public void eliminarLibro(String ISBN) {
		for (Iterator iterator = libros.iterator(); iterator.hasNext();) {
			Libro libro = (Libro) iterator.next();
			if (libro.getISBN() == ISBN) {
				iterator.remove();
			}
		}
	}

	public void insertarLibro(Libro libro) {
		this.libros.add(libro);
	}

	public void mostrarLibros() {
		int indice = 1;
		for (Libro libro : libros) {
			System.out.println(indice + "." + libro.toString());
			indice++;

		}
		System.out.println("**********************************************");
	}

}
