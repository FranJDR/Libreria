package modelo;

import java.io.Serializable;
import java.util.HashMap;

public class Libro implements Serializable {

	private final String TITULO;
	private final String AUTOR;
	private final String ISBN;
	private final String PAGINAS;
	private final String tema;
	private String precio;
	private int cantidad;

	private String formato;
	private String estado;

	public Libro(String titulo, String autor, String isbn, String paginas, String tema, String precio, String formato,
			String estado) {
		super();
		this.TITULO = titulo;
		this.AUTOR = autor;
		this.ISBN = isbn;
		this.PAGINAS = paginas;
		this.tema = tema;
		this.precio = precio;
		this.formato = formato;
		this.estado = estado;
		this.cantidad = 1;
	}

	public void modificarLibro(HashMap<Referencia, String> map) {
		this.precio = map.get(Referencia.PRECIO);
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
		return tema;
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

	public int getCantidad() {
		return cantidad;
	}

}
