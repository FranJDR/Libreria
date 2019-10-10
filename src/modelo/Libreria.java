package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Libreria {

	private ArrayList<Libro> libros = new ArrayList<Libro>();

	public Libreria() {
		super();
		this.libros.addAll(new AlmacenLibros().getLibros());
	}

	private void quitarLibrosACero() {
		for (Iterator iterator = libros.iterator(); iterator.hasNext();) {
			Libro libro = (Libro) iterator.next();
			if (libro.getCantidad() <= 0)
				iterator.remove();
		}
	}

	public void modificarLibro(String ISBN, HashMap<Referencia, String> map) {
		Libro libro = getLibroISBN(ISBN);
		if (libro != null) {
			libro.modificarLibro(map);
		}
	}

	public void aumentarNumLibro(String ISBN, int cantidad) {
		Libro libro = getLibroISBN(ISBN);
		if (libro != null)
			libro.aumentarCantidad(cantidad);
	}

	public void reducirNumLibro(String ISBN, int cantidad) {
		Libro libro = getLibroISBN(ISBN);
		if (libro != null) {
			if (libro.getCantidad() >= cantidad) {
				libro.reducirCantidad(cantidad);
				quitarLibrosACero();
			} else
				JOptionPane.showMessageDialog(null, "La cantidad es superior al numero de unidades.", "error de datos ",
						JOptionPane.WARNING_MESSAGE);
		}
	}

	public boolean validarIsbn(String ISBN) {
		for (Libro libro : this.libros) {
			if (libro.getISBN().compareTo(ISBN) == 0) {
				JOptionPane.showMessageDialog(null, "El ISBN ya existe.", "error de datos ",
						JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		return true;
	}

	public void eliminarLibro(String ISBN) {
		for (Libro libro : libros) {

		}
		for (Iterator iterator = libros.iterator(); iterator.hasNext();) {
			Libro libro = (Libro) iterator.next();
			if (libro.getISBN() == ISBN)
				iterator.remove();
		}
	}

	public boolean insertarLibro(Tematica tematica, HashMap<Referencia, String> map) {
		return this.libros.add(new Libro(map.get(Referencia.titulo), map.get(Referencia.autor),
				map.get(Referencia.isbn), map.get(Referencia.paginas), tematica, map.get(Referencia.precio),
				map.get(Referencia.formato), map.get(Referencia.estado)));
	}

	public String[][] obtenerDatosLibros() {
		int index = 0;
		String[][] datos = new String[this.libros.size()][7];
		for (Libro libro : libros) {
			datos[index][0] = libro.getTITULO();
			datos[index][1] = libro.getAUTOR();
			datos[index][2] = libro.getTema().toString();
			datos[index][3] = libro.getPAGINAS();
			datos[index][4] = libro.getISBN();
			datos[index][5] = libro.getPrecio();
			datos[index][6] = String.valueOf(libro.getCantidad());
			index++;
		}
		return datos;
	}

	private Libro getLibroISBN(String isbn) {
		for (Libro libro : this.libros) {
			if (libro.getISBN().compareTo(isbn) == 0)
				return libro;
		}
		return null;
	}

}
