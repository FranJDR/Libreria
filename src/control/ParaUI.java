package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Libro;
import modelo.Tematica;
import vista.UI;

public class ParaUI extends UI {

	private Control control = new Control();

	public ParaUI() {
		super();
		listenerBtn();
	}

	private void listenerBtn() {

		this.btnNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = listCampos.get(0).getText();
				String autor = listCampos.get(1).getText();
				String paginas = listCampos.get(3).getText();
				Tematica tematica = obtenerTematica();
				String ISBN = listCampos.get(4).getText();
				String precio = listCampos.get(5).getText();
				control.insertarLibro(new Libro(titulo, autor, ISBN, paginas, tematica, precio));
				rellenarTable(control.getLibros(), table);
			}
		});

	}

}
