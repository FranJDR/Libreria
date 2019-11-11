package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import control.Logica;
import modelo.enums.ReferenciaDatos;
import modelo.enums.Tematica;

class LibreriaTest {

	Logica libreria = new Logica();

	@Test
	void testModificarLibro() {
		String isbn = libreria.getLibros().get(0).getISBN();
		String precioOriginal = libreria.getLibros().get(0).getPrecio();
		HashMap<ReferenciaDatos, String> map = new HashMap<ReferenciaDatos, String>();
		map.put(ReferenciaDatos.PRECIO, "50");
		libreria.modificarLibro(isbn, map);
		assertTrue(precioOriginal.compareTo(libreria.getLibros().get(0).getPrecio()) != 0);
	}

	@Test
	void testAumentarNumLibro() {
		String isbn = libreria.getLibros().get(0).getISBN();
		int cantidad = 15;
		int cantidadInicial = libreria.getLibros().get(0).getCantidad();
		libreria.aumentarNumLibro(isbn, cantidad);
		assertTrue(cantidadInicial + cantidad == libreria.getLibros().get(0).getCantidad());
	}

	@Test
	void testReducirNumLibro() {
		String isbn = libreria.getLibros().get(0).getISBN();
		libreria.aumentarNumLibro(isbn, 100);
		int cantidad = 15;
		int cantidadInicial = libreria.getLibros().get(0).getCantidad();
		libreria.reducirNumLibro(isbn, cantidad);
		assertTrue(cantidadInicial - cantidad == libreria.getLibros().get(0).getCantidad());
	}

	@Test
	void testValidarIsbn() {
		String isbn = libreria.getLibros().get(0).getISBN();
		assertFalse(libreria.validarIsbn(isbn));
	}

	@Test
	void testEliminarLibro() {
		String isbn = libreria.getLibros().get(0).getISBN();
		int longitudInicial = libreria.getLibros().size();
		libreria.eliminarLibro(isbn);
		assertTrue(longitudInicial > libreria.getLibros().size());
	}

	@Test
	void testInsertarLibro() {
		int longitudInicial = libreria.getLibros().size();
		HashMap<ReferenciaDatos, String> map = new HashMap<ReferenciaDatos, String>();
		libreria.insertarLibro(map);
		assertTrue(longitudInicial < libreria.getLibros().size());
	}

}
