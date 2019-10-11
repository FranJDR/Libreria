package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Validador {

	private ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

	public boolean validarLibro(HashMap<Referencia, String> map) {
		this.respuestas.clear();
		for (String campo : map.values())
			this.respuestas.add(new Respuesta("Campo vacios.", !campo.isEmpty()));
		this.respuestas.add(new Respuesta("El campo ISBN debe contener digitos.", isNumber(map.get(Referencia.ISBN))));
		this.respuestas
				.add(new Respuesta("El campo paginas debe contener digitos.", isNumber(map.get(Referencia.PAGINAS))));
		this.respuestas
				.add(new Respuesta("El campo precio debe contener digitos.", isNumber(map.get(Referencia.PRECIO))));
		this.respuestas.add(new Respuesta("El ISBN de tener 13 digitos.", map.get(Referencia.ISBN).length() == 13));
		this.respuestas.add(
				new Respuesta("El nombre del autor no puede tener digitos.", validarAutor(map.get(Referencia.AUTOR))));

		for (Respuesta respuesta : respuestas) {
			if (!respuesta.isValido()) {
				WarningMessage(respuesta.getMensage());
				return false;
			}
		}
		return true;
	}

	public void WarningMessage(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "error de datos ", JOptionPane.WARNING_MESSAGE);
	}

	private boolean validarAutor(String nombre) {
		return Pattern.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$*", nombre);
	}

	private boolean validarISBN(String ISBN) {
		return Pattern.matches("\\d{13}", ISBN);
	}

	public boolean isNumber(String cadena) {
		if (Pattern.matches("[0-9]{1,200}", cadena))
			return true;
		WarningMessage("Tiene que ser un digito.");
		return false;
	}

}
