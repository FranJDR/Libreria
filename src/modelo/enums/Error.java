package modelo.enums;

public enum Error {

	DIGIT_ISBN("El ISBN debe estar formado por numeros."),
	DIGIT_PAGINAS("El campo Nº de Paginas debe contener numeros."),
	DIGIT_PRECIO("El campo Precio debe contener numeros."),
	LENGTH_ISBN("El ISBN debe tener un longitud de 13."),
	DIGIT_AUTOR("El autor no puede tener digitos."),
	PRECIO_CERO("El precio debe ser mayor de cero."),
	PAGINAS_CERO("El Nº de paginas debe ser mayor de cero."),
	CAMPO_VACIO("Campos vacios.");

	private String mensaje;

	private Error(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}
