package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.ParaUI;
import modelo.Referencia;
import vista.PanelInfo;

public class BtnVerDetalles implements ActionListener {

	private ParaUI paraUI;

	public BtnVerDetalles(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int indice = this.paraUI.getTable().getSelectedRow();
		if (indice != -1) {
			String[] datos = new String[6];
			for (int i = 0; i < datos.length; i++)
				datos[i] = this.paraUI.getDatos()[indice][i];
			this.paraUI.setPanelInfo(new PanelInfo(datos, this.paraUI.getBtn(Referencia.BTN_MODIFICAR)));
		} else
			JOptionPane.showMessageDialog(null, "Selecciona un fila de la tabla.", "error de datos ",
					JOptionPane.WARNING_MESSAGE);
	}

}
