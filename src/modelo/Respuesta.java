package modelo;

public class Respuesta {

	private String mensage;
	private boolean valido;

	public Respuesta(String mensage, boolean valido) {
		super();
		this.mensage = mensage;
		this.valido = valido;
	}

	public String getMensage() {
		return mensage;
	}

	public boolean isValido() {
		return valido;
	}

}
