package modelo.eventos;

import control.Control;
import modelo.interfaces.Ejecutable;
import vista.UI;

import javax.swing.*;

public class EliminarLibro implements Ejecutable {

    public static String name = "eliminarLibro";

    @Override
    public void execute(Control control, UI ui) {
        if (ui.isSelectRowTable()) {
            int respuesta = JOptionPane.showConfirmDialog(null, "�Est� seguro que quieres eliminarlo?");
            if (respuesta == 0) {
                control.eliminarLibro(ui.obtenerISBNTable());
                ui.actualizarTabla(control.obtenerDatosLibros());
                ui.actualizarTableHistorico();
            }
        }
    }

}
