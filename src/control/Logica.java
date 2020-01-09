package control;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import modelo.AlmacenLibros;
import modelo.enums.Libro;

public class Logica {

	private AlmacenLibros acceso;

	public Logica() {
		super();
		this.acceso = new AlmacenLibros();
	}

	public String[][] getDatosPorBusqueda(String[][] datos, String ISBN) {
		ArrayList<HashMap<Libro, String>> aux = new ArrayList<HashMap<Libro, String>>();
		for (HashMap<Libro, String> libro : this.obtenerListaLibros()) {
			if (coincide(libro.get(Libro.ISBN), ISBN)) {
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

	public void modifcarCantidadLibro(String ISBN, int cantidad) {
		HashMap<Libro, String> libro = this.obtenerLibro(ISBN);
		int cantidadModificada = Integer.parseInt(libro.get(Libro.CANTIDAD)) + cantidad;
		this.acceso.modificarCantidad(ISBN, String.valueOf(cantidadModificada));
	}

	public boolean validarIsbn(String ISBN) {
		if (this.getListISBN().contains(ISBN)) {
			JOptionPane.showMessageDialog(null, "El ISBN ya existe.", "error de datos ", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public String[][] obtenerDatosLibros() {
		return this.crearMatrizDatos(this.obtenerListaLibros());
	}

	private String[][] crearMatrizDatos(ArrayList<HashMap<Libro, String>> libros) {
		String[][] retorno = new String[libros.size()][10];
		int index = 0;
		for (HashMap<Libro, String> libro : libros) {
			int aux = 0;
			for (Libro enumLibro : Libro.values()) {
				retorno[index][aux] = libro.get(enumLibro);
				aux++;
			}
			index++;
		}
		return retorno;
	}

	public boolean temaEnUso(String tema) {
		for (HashMap<Libro, String> libro : this.obtenerListaLibros()) {
			if (libro.get(Libro.TEMATICA).compareTo(tema) == 0) {
				return true;
			}
		}
		return false;
	}

	public boolean editorialEnUso(String editorial) {
		for (HashMap<Libro, String> libro : this.obtenerListaLibros()) {
			if (libro.get(Libro.EDITORIAL).compareTo(editorial) == 0) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<String> getListISBN() {
		return this.acceso.obtenerListaISBN();
	}

	public void modificarPrecio(String ISBN, String precio) {
		this.acceso.modificarPrecio(ISBN, precio);
	}

	public void eliminarTema(String tema) {
		this.acceso.eliminartema(tema);
	}

	public void eliminarEditorial(String editorial) {
		this.acceso.eliminarEditorial(editorial);
	}

	public void insertarTema(String tema) {
		this.acceso.insertarTema(tema);
	}

	public void insertarEditorial(String editorial) {
		this.acceso.insertarEditorial(editorial);
	}

	public boolean insertarLibro(HashMap<Libro, String> map) {
		return this.acceso.insertarLibro(map);
	}

	public void eliminarLibro(String ISBN) {
		this.acceso.borrarLibro(ISBN);
	}

	public HashMap<Libro, String> obtenerLibro(String ISBN) {
		return this.acceso.obtenerLibro(ISBN);
	}

	public ArrayList<HashMap<Libro, String>> obtenerListaLibros() {
		return this.acceso.obtenerListaLibros();
	}

}
