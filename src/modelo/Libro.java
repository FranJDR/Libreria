package modelo;

public class Libro {

	private final String titulo;
	private final String autor;
	private final String ISBN;
	private final String paginas;
	private final Tematica tema;
	private String precio;

	public Libro(String titulo, String autor, String iSBN, String paginas, Tematica tema, String prec) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = iSBN;
		this.paginas = paginas;
		this.tema = tema;
		this.precio = prec;
	}

	@Override
	public String toString() {
		return "Titulo : " + this.titulo + " / Autor : " + this.autor + " / ISBN : " + this.ISBN + " / Paginas : "
				+ this.paginas + " / Tematica : " + this.tema.toString() + " / Precio : " + this.precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getPaginas() {
		return paginas;
	}

	public String getPrecio() {
		return precio;
	}

	public Tematica getTema() {
		return tema;
	}

}
