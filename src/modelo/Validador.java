package modelo;

import java.util.HashMap;

import javax.swing.JOptionPane;

public class Validador {

	public boolean validarLibro(HashMap<Referencia, String> map) {
		if (!map.get(Referencia.titulo).isEmpty() && !map.get(Referencia.autor).isEmpty()
				&& !map.get(Referencia.isbn).isEmpty() && !map.get(Referencia.paginas).isEmpty()
				&& !map.get(Referencia.precio).isEmpty()) {
			if (isNumber(map.get("isbn"), "El campo ISBN debe ser digitos")
					&& isNumber(map.get("precios"), "El campo de precio deben ser digitos")
					&& isNumber(map.get("precio"), "El campo de paginas deben ser digito")) {
				if (map.get("isbn").length() == 13) {
					return true;
				} else {
					WarningMessage("El campo ISBN debe contener 13 digitos");
					return false;
				}
			} else {
				return false;
			}
		} else {
			WarningMessage("Campos vacios");
			return false;
		}
	}

	public void WarningMessage(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "error de datos ", JOptionPane.WARNING_MESSAGE);
	}

	private boolean isNumber(String cadena, String mensaje) {
		boolean retorno = true;
		for (int i = 0; i < cadena.length(); i++) {
			if (!Character.isDigit(cadena.charAt(i))) {
				retorno = false;
			}
		}
		if (!retorno) {
			WarningMessage(mensaje);
		}
		return retorno;
	}
}
