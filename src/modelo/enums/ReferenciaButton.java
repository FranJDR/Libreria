package modelo.enums;

public enum ReferenciaButton {

	NUEVO("A�adir nuevo libro"), ALTA("A�adir"), BAJA("Quitar"), VERDETALLES("Ver Detalles"), MODIFICAR("Modificar"),
	ELIMINAR("Eliminar");

	private String nombre;

	private ReferenciaButton(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

}
