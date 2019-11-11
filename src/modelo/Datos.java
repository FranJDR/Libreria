package modelo;

import java.io.File;
import java.util.ArrayList;

import almacen.DTO;

public class Datos {

	private DTO<Libro> dtoLibros;

	private final static String directorio = "./libros";

	public Datos() {
		super();

		File directorio = new File(this.directorio);
		if (!directorio.exists())
			directorio.mkdir();

		this.dtoLibros = new DTO<Libro>();
	}

	public boolean grabarLibro(Libro libro) {
		return this.dtoLibros.grabar(libro, this.obtenerRutaLibro(libro.getISBN()));
	}

	public Libro getLibro(String ISBN) {
		return this.dtoLibros.leer(this.obtenerRutaLibro(ISBN));
	}

	public void eliminarLibro(String ISBN) {
		File file = new File(this.obtenerRutaLibro(ISBN));
		if (file.exists())
			file.delete();
	}

	public ArrayList<Libro> getLibros() {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		String[] nombreArchivo = new File(this.directorio).list();
		for (int i = 0; i < nombreArchivo.length; i++)
			libros.add(this.dtoLibros.leer(this.directorio + "/" + nombreArchivo[i]));
		return libros;
	}

	private String obtenerRutaLibro(String ISBN) {
		return this.directorio + "/" + ISBN + ".dat";
	}

}
