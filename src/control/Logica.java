package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

import modelo.Datos;
import modelo.Libro;
import modelo.enums.ReferenciaDatos;

public class Logica {

	private Datos datos;

	public Logica() {
		super();
		this.datos = new Datos();
	}

	public String[][] getDatosPorBusqueda(String[][] datos, String ISBN) {
		ArrayList<Libro> aux = new ArrayList<Libro>();
		for (Libro libro : this.datos.getLibros()) {
			if (coincide(libro.getISBN(), ISBN)) {
				aux.add(libro);
			}
		}
		return this.crearMatrizDatos(aux);
	}

	private boolean coincide(String libro, String iSBN) {
		for (int i = 0; i < iSBN.length(); i++) {
			if (iSBN.charAt(i) != libro.charAt(i))
				return false;
		}
		return true;
	}

	private void quitarLibrosACero() {
		for (Iterator iterator = this.datos.getLibros().iterator(); iterator.hasNext();) {
			Libro libro = (Libro) iterator.next();
			if (libro.getCantidad() <= 0)
				this.datos.eliminarLibro(libro.getISBN());
		}
	}

	public void modificarLibro(String ISBN, HashMap<ReferenciaDatos, String> map) {
		Libro libro = this.datos.getLibro(ISBN);
		if (libro != null) {
			libro.modificarLibro(map);
			this.datos.grabarLibro(libro);
		}
	}

	public void aumentarNumLibro(String ISBN, int cantidad) {
		Libro libro = this.datos.getLibro(ISBN);
		if (libro != null) {
			libro.aumentarCantidad(cantidad);
			this.datos.grabarLibro(libro);
		}
	}

	public void reducirNumLibro(String ISBN, int cantidad) {
		Libro libro = this.datos.getLibro(ISBN);
		if (libro != null) {
			if (libro.getCantidad() >= cantidad) {
				libro.reducirCantidad(cantidad);
				this.datos.grabarLibro(libro);
				quitarLibrosACero();
			} else
				JOptionPane.showMessageDialog(null, "La cantidad es superior al numero de unidades.", "error de datos ",
						JOptionPane.WARNING_MESSAGE);
		}
	}

	public boolean validarIsbn(String ISBN) {
		if (this.getListISBN().contains(ISBN)) {
			JOptionPane.showMessageDialog(null, "El ISBN ya existe.", "error de datos ", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public ArrayList<String> getListISBN() {
		ArrayList<String> isbn = new ArrayList<String>();
		for (Libro libro : this.datos.getLibros())
			isbn.add(libro.getISBN());
		return isbn;
	}

	public String[][] obtenerDatosLibros() {
		return this.crearMatrizDatos(this.datos.getLibros());
	}

	public void eliminarLibro(String ISBN) {
		this.datos.eliminarLibro(ISBN);
	}

	public boolean insertarLibro(HashMap<ReferenciaDatos, String> map) {
		return this.datos
				.grabarLibro(new Libro(map.get(ReferenciaDatos.TITULO), map.get(ReferenciaDatos.AUTOR), map.get(ReferenciaDatos.ISBN),
						map.get(ReferenciaDatos.PAGINAS), map.get(ReferenciaDatos.TEMATICA), map.get(ReferenciaDatos.EDITORIAL),
						map.get(ReferenciaDatos.PRECIO), map.get(ReferenciaDatos.FORMATO), map.get(ReferenciaDatos.ESTADO)));
	}

	private String[][] crearMatrizDatos(ArrayList<Libro> libros) {
		String[][] retorno = new String[libros.size()][8];
		int index = 0;
		for (Libro libro : libros) {
			retorno[index][0] = libro.getTITULO();
			retorno[index][1] = libro.getAUTOR();
			retorno[index][2] = libro.getTema();
			retorno[index][3] = libro.getPAGINAS();
			retorno[index][4] = libro.getISBN();
			retorno[index][5] = libro.getPrecio();
			retorno[index][6] = String.valueOf(libro.getCantidad());
			retorno[index][7] = libro.getEditorial();
			index++;
		}
		return retorno;
	}

	public ArrayList<Libro> getLibros() {
		return this.datos.getLibros();
	}

}
