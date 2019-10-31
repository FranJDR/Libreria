package modelo;

import java.io.File;
import java.util.ArrayList;

import almacen.DTO;

public class Datos {

	private DTO<Libro> dtoLibros;
	private final String rutaLibros = "libros.dat";

	private final static String RUTADIRECTORIO = "./libros";

	public Datos() {
		super();

		File directorio = new File(this.RUTADIRECTORIO);
		if (!directorio.exists())
			directorio.mkdir();

		this.dtoLibros = new DTO<Libro>();
	}

	public boolean gerGrabarLibro(Libro libro) {
		return this.dtoLibros.grabar(libro, this.RUTADIRECTORIO + "/" + libro.getISBN() + ".dat");
	}

	public Libro getLibro(String ISBN) {
		return this.dtoLibros.leer(RUTADIRECTORIO + "/" + ISBN + ".dat");
	}

	public void eliminarLibro(String ISBN) {
		File file = new File(this.RUTADIRECTORIO + "/" + ISBN + ".dat");
		if (file.exists())
			file.delete();
	}

	public ArrayList<Libro> getLibros() {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		File directorio = new File(this.RUTADIRECTORIO);
		String[] nombreArchivo = directorio.list();
		for (int i = 0; i < nombreArchivo.length; i++) {
			libros.add(dtoLibros.leer(this.RUTADIRECTORIO + "/" + nombreArchivo[i]));
		}
		return libros;
	}

}
