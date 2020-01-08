package modelo.eventos;

import javax.swing.JOptionPane;

import control.Control;
import modelo.interfaces.Ejecutable;
import vista.UI;

public class NuevoTema implements Ejecutable {

	@Override
	public void execute(Control control, UI ui) {
		String tema = JOptionPane.showInputDialog("¿Nombre del Tema?");
		if (tema != null) {
			control.insertarTema(tema);
			ui.actualizarComboTema();
		}
	}

}
