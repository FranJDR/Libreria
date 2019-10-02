package modelo;

import javax.swing.JOptionPane;

public class Validador {

	public boolean validarLibro(Libro libro) {
		if (!libro.getTITULO().isEmpty() && !libro.getAUTOR().isEmpty() && !libro.getISBN().isEmpty()
				&& !libro.getPrecio().isEmpty() && !libro.getPAGINAS().isEmpty()) {
			if (isNumber(libro.getISBN(), "El campo ISBN debe ser digitos")
					&& isNumber(libro.getPrecio(), "El campo de precio deben ser digitos")
					&& isNumber(libro.getPAGINAS(), "El campo de paginas deben ser digito")) {
				if (libro.getISBN().length() == 13) {
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
