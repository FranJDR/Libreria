package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

import almacen.AlmacenIndividual;
import modelo.Libro;
import modelo.enums.ReferenciaDatos;

public class Logica {

	private AlmacenIndividual<Libro> almacenLibros;

	public Logica() {
		super();
		this.almacenLibros = new AlmacenIndividual<Libro>("libros", "dat");
	}

	public String[][] getDatosPorBusqueda(String[][] datos, String ISBN) {
		ArrayList<Libro> aux = new ArrayList<Libro>();
		for (Libro libro : this.almacenLibros.getListObject()) {
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
		for (Iterator iterator = this.almacenLibros.getListObject().iterator(); iterator.hasNext();) {
			Libro libro = (Libro) iterator.next();
			if (libro.getCantidad() <= 0)
				this.almacenLibros.eliminarFichero(libro.getISBN());
		}
	}

	public void modificarLibro(String ISBN, HashMap<ReferenciaDatos, String> map) {
		Libro libro = this.almacenLibros.getObject(ISBN);
		if (libro != null) {
			libro.modificarLibro(map);
			this.almacenLibros.grabarObject(libro.getISBN(), libro);
		}
	}

	public void aumentarNumLibro(String ISBN, int cantidad) {
		Libro libro = this.almacenLibros.getObject(ISBN);
		if (libro != null) {
			libro.aumentarCantidad(cantidad);
			this.almacenLibros.grabarObject(libro.getISBN(), libro);
		}
	}

	public void reducirNumLibro(String ISBN, int cantidad) {
		Libro libro = this.almacenLibros.getObject(ISBN);
		if (libro != null) {
			if (libro.getCantidad() >= cantidad) {
				libro.reducirCantidad(cantidad);
				this.almacenLibros.grabarObject(libro.getISBN(), libro);
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
		for (Libro libro : this.almacenLibros.getListObject())
			isbn.add(libro.getISBN());
		return isbn;
	}

	public String[][] obtenerDatosLibros() {
		return this.crearMatrizDatos(this.almacenLibros.getListObject());
	}

	public void eliminarLibro(String ISBN) {
		this.almacenLibros.eliminarFichero(ISBN);
	}

	public boolean insertarLibro(HashMap<ReferenciaDatos, String> map) {
		return this.almacenLibros.grabarObject(map.get(ReferenciaDatos.ISBN), new Libro(map.get(ReferenciaDatos.TITULO),
				map.get(ReferenciaDatos.AUTOR), map.get(ReferenciaDatos.ISBN), map.get(ReferenciaDatos.PAGINAS),
				map.get(ReferenciaDatos.TEMATICA), map.get(ReferenciaDatos.EDITORIAL), map.get(ReferenciaDatos.PRECIO),
				map.get(ReferenciaDatos.FORMATO), map.get(ReferenciaDatos.ESTADO)));
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
		return this.almacenLibros.getListObject();
	}

}
