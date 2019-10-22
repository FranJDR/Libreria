package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

import modelo.Datos;
import modelo.Libro;
import modelo.Referencia;
import modelo.Tematica;

public class Logica {

	private Datos datos;

	public Logica() {
		super();
		this.datos = new Datos();
	}

	public String[][] getDatosPorBusqueda(String[][] datos, String ISBN) {
		ArrayList<String> aux = new ArrayList<String>();
		for (Libro libro : this.datos.getLibros()) {
			if (coincide(libro.getISBN(), ISBN)) {
				aux.add(libro.getDatos());
			}
		}
		String[][] retorno = new String[aux.size()][7];
		int indice = 0;
		for (String cadena : aux) {
			String[] libro = cadena.split(" ");
			retorno[indice][0] = libro[0];
			retorno[indice][1] = libro[1];
			retorno[indice][2] = libro[2];
			retorno[indice][3] = libro[3];
			retorno[indice][4] = libro[4];
			retorno[indice][5] = libro[5];
			retorno[indice][6] = libro[6];
			indice++;
		}
		return retorno;
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
				iterator.remove();
		}
		guardarCambios();
	}

	public void modificarLibro(String ISBN, HashMap<Referencia, String> map) {
		Libro libro = getLibroISBN(ISBN);
		if (libro != null) {
			libro.modificarLibro(map);
			guardarCambios();
		}
	}

	public void aumentarNumLibro(String ISBN, int cantidad) {
		Libro libro = getLibroISBN(ISBN);
		if (libro != null) {
			libro.aumentarCantidad(cantidad);
			guardarCambios();
		}
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

	public void eliminarLibro(String ISBN) {
		for (Iterator iterator = this.datos.getLibros().iterator(); iterator.hasNext();) {
			Libro libro = (Libro) iterator.next();
			if (libro.getISBN() == ISBN)
				iterator.remove();
		}
		guardarCambios();
	}

	public boolean insertarLibro(HashMap<Referencia, String> map) {
		if (this.datos.getLibros()
				.add(new Libro(map.get(Referencia.TITULO), map.get(Referencia.AUTOR), map.get(Referencia.ISBN),
						map.get(Referencia.PAGINAS), map.get(Referencia.TEMATICA), map.get(Referencia.PRECIO),
						map.get(Referencia.FORMATO), map.get(Referencia.ESTADO))))
			return guardarCambios();
		return false;
	}

	public String[][] obtenerDatosLibros() {
		int index = 0;
		String[][] datos = new String[this.datos.getLibros().size()][7];
		for (Libro libro : this.datos.getLibros()) {
			datos[index][0] = libro.getTITULO();
			datos[index][1] = libro.getAUTOR();
			datos[index][2] = libro.getTema();
			datos[index][3] = libro.getPAGINAS();
			datos[index][4] = libro.getISBN();
			datos[index][5] = libro.getPrecio();
			datos[index][6] = String.valueOf(libro.getCantidad());
			index++;
		}
		return datos;
	}

	private Libro getLibroISBN(String isbn) {
		for (Libro libro : this.datos.getLibros()) {
			if (libro.getISBN().compareTo(isbn) == 0)
				return libro;
		}
		return null;
	}

	private boolean guardarCambios() {
		return this.datos.gerGrabarLibros();
	}

	public ArrayList<Libro> getLibros() {
		return this.datos.getLibros();
	}

}
