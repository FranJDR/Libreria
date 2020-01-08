package modelo.eventos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import control.Control;
import modelo.Conexion;
import modelo.interfaces.Ejecutable;
import utiles.Utiles;
import vista.UI;

public class EliminarTema implements Ejecutable {

	@Override
	public void execute(Control control, UI ui) {
		ArrayList<String> tema = Conexion.instance().obtenerListCampo("SELECT * FROM TEMA", "nombre");
		String[] vectorTema = new String[tema.size()];
		tema.toArray(vectorTema);
		String resp = (String) JOptionPane.showInputDialog(null, "Seleccione el tema que desea eliminar",
				"Eliminar Tema", JOptionPane.DEFAULT_OPTION, null, vectorTema, vectorTema[0]);
		if (resp != null) {
			if (!control.temaEnUso(resp)) {
				control.eliminarTema(resp);
				ui.actualizarComboTema();
			} else {
				Utiles.mensajeError("Tema en uso");
			}
		}
	}

}
