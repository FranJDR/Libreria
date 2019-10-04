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
		this.respuestas.add(new Respuesta("El campo ISBN debe contener digitos.", isNumber(map.get(Referencia.isbn))));
		this.respuestas
				.add(new Respuesta("El campo paginas debe contener digitos.", isNumber(map.get(Referencia.paginas))));
		this.respuestas
				.add(new Respuesta("El campo precio debe contener digitos.", isNumber(map.get(Referencia.precio))));
		this.respuestas.add(new Respuesta("El ISBN de tener 13 digitos.", map.get(Referencia.isbn).length() == 13));
		this.respuestas.add(
				new Respuesta("El nombre del autor no puede tener digitos.", validarAutor(map.get(Referencia.autor))));

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

	// ascii < 48 && 57 < ascii int ascii = (int) cadena.charAt(i);
	private boolean isNumber(String cadena) {
		for (int i = 0; i < cadena.length(); i++) {
			if (!Character.isDigit((int) cadena.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNumeric(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}
}
