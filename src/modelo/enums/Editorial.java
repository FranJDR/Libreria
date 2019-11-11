package modelo.enums;

public enum Editorial {

	BlackieBooks("Blackie Books"), Impedimenta("Impedimenta"), Malpaso("Malpaso"), Nordica("Nordica"),
	LaSeñoraDalloway("La Señora Dalloway"), Austral("Austral");

	private String nombre;

	private Editorial(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

}
