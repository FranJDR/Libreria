package modelo.eventos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import control.Control;
import modelo.Conexion;
import modelo.interfaces.Ejecutable;
import utiles.Utiles;
import vista.UI;

public class EliminarEditorial implements Ejecutable {

	@Override
	public void execute(Control control, UI ui) {
		ArrayList<String> editorial = Conexion.instance().obtenerListCampo("SELECT * FROM EDITORIAL", "nombre");
		String[] vectorTema = new String[editorial.size()];
		editorial.toArray(vectorTema);
		String resp = (String) JOptionPane.showInputDialog(null, "Seleccione la editorial que desea eliminar",
				"Eliminar Editorial", JOptionPane.DEFAULT_OPTION, null, vectorTema, vectorTema[0]);
		if (resp != null) {
			if (!control.editorialEnUso(resp)) {
				control.eliminarEditorial(resp);
				ui.actualizarComboEditorial();
			} else {
				Utiles.mensajeError("Editorial en uso");
			}
		}
	}

}
