package modelo.eventos;

import javax.swing.JOptionPane;

import control.Control;
import modelo.interfaces.Ejecutable;
import vista.UI;

public class NuevaEditorial implements Ejecutable {

	@Override
	public void execute(Control control, UI ui) {
		String editorial = JOptionPane.showInputDialog("¿Nombre de la Editorial?");
		if (editorial != null) {
			control.insertarEditorial(editorial);
			ui.actualizarComboEditorial();
		}
	}

}
