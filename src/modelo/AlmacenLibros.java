package modelo;

import java.util.ArrayList;

public class AlmacenLibros {

	private ArrayList<Libro> libros = new ArrayList<Libro>();

	public AlmacenLibros() {
		super();
		this.libros.add(new Libro("El Silmarillion", "J.R.R. Tolkien", "6784561234568", "365", Tematica.Fantasia, "25",
				"Rustico", "Novedad"));
		this.libros.add(new Libro("El nombre del viento", "Patrick Rothfuss", "1231232344567", "613", Tematica.Fantasia,
				"19", "Rustica", "Novedad"));
		this.libros.add(new Libro("Naruto", "Masashi Kishimoto", "1232343454568", "1500", Tematica.Ficcion, "150",
				"Digital", "Reedicion"));
		this.libros.add(new Libro("Harry Potter", "J. K. Rowling,", "8459352473859", "3407", Tematica.Fantasia, "30",
				"Rustica", "Novedad"));
		this.libros.add(new Libro("El Código da Vinci", "Dan Brown", "9464573284765", "1200", Tematica.Psicologia, "15",
				"Cartone", "Reedicion"));

	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

}
