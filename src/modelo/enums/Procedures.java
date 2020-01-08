package modelo.enums;

public enum Procedures {

	INSERTAR_LIBRO("insertarLibro(?,?,?,?,?,?,?,?,?,?)", 10), INSERTAR_TEMA("insertarTema(?)", 1),
	INSERTAR_EDITORIAL("insertarEditorial(?)", 1), ELIMINAR_LIBRO("eliminarLibro(?)", 1),
	ELIMINAR_TEMA("eliminarTema(?)", 1), ELIMINAR_EDITORIAL("eliminarEditorial(?)", 1),
	MODIFICAR_CANTIDAD("modificarCantidad(?,?)", 2), MODIFICAR_PRECIO("modificarPrecio(?,?)", 2);

	private String nombre;
	private int numParametros;

	private Procedures(String nombre, int numParametros) {
		this.nombre = nombre;
		this.numParametros = numParametros;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumParametros() {
		return numParametros;
	}

}
