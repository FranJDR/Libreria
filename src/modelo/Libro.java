package modelo;

import java.io.Serializable;
import java.util.HashMap;

import modelo.enums.ReferenciaDatos;

public class Libro implements Serializable {

	private final String TITULO;
	private final String AUTOR;
	private final String ISBN;
	private final String PAGINAS;
	private final String TEMA;
	private String editorial;
	private String precio;
	private int cantidad;

	private String formato;
	private String estado;

	public Libro(String titulo, String autor, String ISBN, String paginas, String tema, String editorial, String precio,
			String formato, String estado) {
		super();
		this.TITULO = titulo;
		this.AUTOR = autor;
		this.ISBN = ISBN;
		this.PAGINAS = paginas;
		this.TEMA = tema;
		this.editorial = editorial;
		this.precio = precio;
		this.cantidad = 1;
		this.formato = formato;
		this.estado = estado;
	}

	public void modificarLibro(HashMap<ReferenciaDatos, String> map) {
		this.precio = map.get(ReferenciaDatos.PRECIO);
	}

	public void aumentarCantidad(int cantidad) {
		this.cantidad += cantidad;
	}

	public void reducirCantidad(int cantidad) {
		this.cantidad -= cantidad;
	}

	public String getTITULO() {
		return TITULO;
	}

	public String getAUTOR() {
		return AUTOR;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getPAGINAS() {
		return PAGINAS;
	}

	public String getTema() {
		return this.TEMA;
	}

	public String getPrecio() {
		return precio;
	}

	public String getFormato() {
		return formato;
	}

	public String getEstado() {
		return estado;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public int getCantidad() {
		return cantidad;
	}

}
