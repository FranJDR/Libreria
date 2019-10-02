package modelo;

public class Libro {

	private final String TITULO;
	private final String AUTOR;
	private final String ISBN;
	private final String PAGINAS;
	private final Tematica tema;
	private String precio;

	private String formato;
	private String estado;

	public Libro(String titulo, String autor, String isbn, String paginas, Tematica tema, String precio, String formato,
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

	public Tematica getTema() {
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

}
