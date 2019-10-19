package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import control.Control;
import control.ParaUI;
import modelo.Referencia;

public class BtnModificar implements ActionListener {

	private Control control;
	private ParaUI paraUI;

	public BtnModificar(Control control, ParaUI paraUI) {
		super();
		this.control = control;
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		HashMap<Referencia, String> map = this.paraUI.getMapPanelInfo();
		this.control.modificarLibro(map.get(Referencia.ISBN), map);
		this.paraUI.rellenarTable(control.obtenerDatosLibros());
	}

}
