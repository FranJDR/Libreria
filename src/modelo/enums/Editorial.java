package modelo.enums;

public enum Editorial {

	BlackieBooks("Blackie Books"), Impedimenta("Impedimenta"), Malpaso("Malpaso"), Nordica("Nordica"),
	LaSe�oraDalloway("La Se�ora Dalloway"), Austral("Austral");

	private String nombre;

	private Editorial(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

}
