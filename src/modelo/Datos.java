package modelo;

import java.util.ArrayList;

import almacen.DTO;

public class Datos {

	private DTO<ArrayList<Libro>> dtoLibros;
	private ArrayList<Libro> libros;
	private final String rutaLibros = "libros.dat";

	public Datos() {
		super();
		this.dtoLibros = new DTO<ArrayList<Libro>>();
		this.libros = this.dtoLibros.leer(this.rutaLibros);
		if (this.libros == null)
			this.libros = new ArrayList<Libro>();
	}

	public boolean gerGrabarLibros() {
		return this.dtoLibros.grabar(this.libros, this.rutaLibros);
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

}
