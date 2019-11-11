package modelo.enums;

public enum ReferenciaButton {

	NUEVO("Añadir nuevo libro"), ALTA("Añadir"), BAJA("Quitar"), VERDETALLES("Ver Detalles"), MODIFICAR("Modificar"),
	ELIMINAR("Eliminar");

	private String nombre;

	private ReferenciaButton(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

}
