package modelo;

import javax.swing.JOptionPane;

public class Validador {

	public boolean validarLibro(Libro libro) {
		if (!libro.getTitulo().isEmpty() && !libro.getAutor().isEmpty() && !libro.getISBN().isEmpty()
				&& !libro.getPrecio().isEmpty() && !libro.getPaginas().isEmpty()) {
			if (isNumber(libro.getISBN(), "El campo ISBN debe ser digitos")
					&& isNumber(libro.getPrecio(), "El campo de precio debe ser digitos")
					&& isNumber(libro.getPaginas(), "El campo de paginas debe ser un digito")) {
				return true;
			} else {
				return false;
			}
		} else {
			WarningMessage("Campos vacios");
			return false;
		}
	}

	private void WarningMessage(String mensaje) {
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
