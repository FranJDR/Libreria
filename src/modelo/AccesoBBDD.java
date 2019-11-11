package modelo;

import java.sql.*;
import java.util.*;

public class AccesoBBDD {

	private final String user = "";
	private final String password = "";

	private final String nombreBD = "jdbc:mysql://localhost/libreria";

	private Connection miConexion;
	private Statement miStatement;
	private PreparedStatement preparedStatement;

	public AccesoBBDD() throws SQLException {
		super();
		this.miConexion = DriverManager.getConnection(this.nombreBD, this.user, this.password);
		this.miStatement = miConexion.createStatement();
	}

	public ArrayList<Libro> dameListaLibros() {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		try {
			ResultSet resul = miStatement.executeQuery("select");
			while (resul.next()) {
//				libros.add(new Libro(rs.getString("titulo"), rs.getString("autor"), rs.getString("tema"),
//						rs.getString("paginas"), rs.getString("isbn"), rs.getInt("formato"), rs.getInt("estado"),
//						rs.getString("ejemplares"), rs.getString("editorial")));
			}
		} catch (Exception e) {
		}
		return libros;
	}

	public void guardarLibro(Libro nuevoLibro) throws SQLException {
//		miStatement.executeUpdate("INSERT INTO
//		LIBRERIA(isbn,autor,titulo,tema,ejemplares,paginas,editorial,formato,estado) VALUES ('"
//		+ nuevoLibro.getIsbm() + "','" + nuevoLibro.getAutor() + "','" + nuevoLibro.getTitulo() + "','"
//		+ nuevoLibro.getTema() + "','" + nuevoLibro.getNumeroEjemplares() + "','" +
//		nuevoLibro.getPaginas() + "','" + nuevoLibro.getEditorial() + "','" +
//		nuevoLibro.getFormato() + "','" + nuevoLibro.getEstado() + "')");
	}

	public void borrarLibro(Libro libroSeleccionado) {
//		String sql = "DELETE FROM LIBRERIA WHERE isbn LIKE '" + libroSeleccionado.getIsbm() + "'";
//		try {
//			miStatement.executeUpdate(sql);
//			System.out.println("libro borrado");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	public void modificarLibro(Libro libroSeleccionado, String nuevoAutor, int nuevoEstado, int nuevoFormato,
			String nuevoNumEjemplares, String newPaginas, String newTema, String newTitulo, String newEditorial) {
//		String sql = "UPDATE LIBRERIA SET AUTOR = ?,TITULO =?,TEMA=?,EJEMPLARES=?,PAGINAS=?,EDITORIAL=?,FORMATO=?,ESTADO=? WHERE ISBN = ' + libroSeleccionado.getIsbm() + ' ";
		// try {
//			preparedStatement = miConexion.prepareStatement(sql);
//			preparedStatement.setString(1, nuevoAutor);
//			System.out.println(nuevoAutor);
//			preparedStatement.setString(2, newTitulo);
//			System.out.println(newTitulo);
//			preparedStatement.setString(3, newTema);
//			System.out.println(newTema);
//			preparedStatement.setString(4, nuevoNumEjemplares);
//			System.out.println(nuevoNumEjemplares);
//			preparedStatement.setString(5, newPaginas);
//			System.out.println(newPaginas);
//			preparedStatement.setString(6, newEditorial);
//			System.out.println(newEditorial);
//			preparedStatement.setInt(7, nuevoFormato);
//			System.out.println(nuevoFormato);
//			preparedStatement.setInt(8,nuevoEstado);
//			System.out.println(nuevoEstado);
//			preparedStatement.executeUpdate();
//			} catch (SQLException e) {
//			e.printStackTrace();
//			}
	}

	public void cambiarCantidad(Libro libroSeleccionado, Integer cantidadModificar) {
//		String sql = "UPDATE LIBRERIA SET EJEMPLARES=? WHERE ISBN ='" + libroSeleccionado.getIsbm() + "' ";
//		try {
//			preparedStatement = miConexion.prepareStatement(sql);
//			int cant = Integer.parseInt(libroSeleccionado.getNumeroEjemplares());
//			cant = cant + cantidadModificar;
//			String cantNueva = Integer.toString(cant);
//			preparedStatement.setString(1, cantNueva);
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

}
