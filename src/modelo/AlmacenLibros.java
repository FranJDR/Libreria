package modelo;

import java.sql.*;
import java.util.*;

import javax.sql.rowset.CachedRowSet;

import modelo.enums.Libro;
import modelo.enums.Procedures;

public class AlmacenLibros {

	public ArrayList<HashMap<Libro, String>> obtenerListaLibros() {
		ArrayList<HashMap<Libro, String>> libros = new ArrayList<HashMap<Libro, String>>();
		CachedRowSet resul = Conexion.instance().executeQuery(
				"SELECT libro.isbn, libro.titulo, libro.autor, libro.paginas, tema.nombreTema, editorial.nombreEditorial, libro.precio, libro.formato, libro.estado, libro.cantidad FROM libro, tema, editorial WHERE tema.idTema = libro.idTema AND editorial.idEditorial = libro.idEditorial");
		try {
			while (resul.next()) {
				HashMap<Libro, String> auxHashMap = new HashMap<Libro, String>();
				auxHashMap.put(Libro.TEMATICA, resul.getString("nombreTema"));
				auxHashMap.put(Libro.EDITORIAL, resul.getString("nombreEditorial"));
				auxHashMap.put(Libro.TITULO, resul.getString("titulo"));
				auxHashMap.put(Libro.AUTOR, resul.getString("autor"));
				auxHashMap.put(Libro.ISBN, resul.getString("isbn"));
				auxHashMap.put(Libro.PAGINAS, resul.getString("paginas"));
				auxHashMap.put(Libro.PRECIO, resul.getString("precio"));
				auxHashMap.put(Libro.FORMATO, resul.getString("formato"));
				auxHashMap.put(Libro.ESTADO, resul.getString("estado"));
				auxHashMap.put(Libro.CANTIDAD, resul.getString("cantidad"));
				libros.add(auxHashMap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;
	}

	public ArrayList<String> obtenerListaISBN() {
		ArrayList<String> isbn = new ArrayList<String>();
		CachedRowSet resul = Conexion.instance().executeQuery("SELECT * FROM LIBRO");
		try {
			while (resul.next())
				isbn.add(resul.getString("isbn"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isbn;
	}

	public HashMap<Libro, String> obtenerLibro(String ISBN) {
		for (HashMap<Libro, String> libro : this.obtenerListaLibros()) {
			if (libro.get(Libro.ISBN).equals(ISBN)) {
				return libro;
			}
		}
		return null;
	}

	public boolean insertarLibro(HashMap<Libro, String> map) {
		Conexion.instance().executeProcedure(Procedures.INSERTAR_LIBRO, map.get(Libro.ISBN), map.get(Libro.TITULO),
				map.get(Libro.AUTOR), map.get(Libro.PAGINAS), map.get(Libro.TEMATICA), map.get(Libro.EDITORIAL),
				map.get(Libro.PRECIO), map.get(Libro.FORMATO), map.get(Libro.ESTADO), map.get(Libro.CANTIDAD));
		return true;
	}

	public void eliminartema(String tema) {
		Conexion.instance().executeProcedure(Procedures.ELIMINAR_TEMA, tema);
	}

	public void eliminarEditorial(String editorial) {
		Conexion.instance().executeProcedure(Procedures.ELIMINAR_EDITORIAL, editorial);
	}

	public void insertarTema(String tema) {
		Conexion.instance().executeProcedure(Procedures.INSERTAR_TEMA, tema);
	}

	public void insertarEditorial(String editorial) {
		Conexion.instance().executeProcedure(Procedures.INSERTAR_EDITORIAL, editorial);
	}

	public void borrarLibro(String ISBN) {
		Conexion.instance().executeProcedure(Procedures.ELIMINAR_LIBRO, ISBN);
	}

	public void modificarCantidad(String isbn, String cantidad) {
		Conexion.instance().executeProcedure(Procedures.MODIFICAR_CANTIDAD, isbn, cantidad);
	}

	public void modificarPrecio(String isbn, String precio) {
		Conexion.instance().executeProcedure(Procedures.MODIFICAR_PRECIO, isbn, precio);
	}

}
