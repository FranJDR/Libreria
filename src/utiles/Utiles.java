package utiles;

import javax.swing.JOptionPane;

public class Utiles {

	public static void mensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.WARNING_MESSAGE);
	}
}
