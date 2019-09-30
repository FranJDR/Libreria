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
		Libro[] libros = new Libro[3];
		libros[0] = new Libro("asdasd", "asd", "asas", "asdas", Tematica.Ciencia, "yukmgh");
		libros[1] = new Libro("asdasd", "asd", "asas", "asdas", Tematica.Ciencia, "yukmgh");
		libros[2] = new Libro("asdasd", "asd", "asas", "asdas", Tematica.Ciencia, "yukmgh");
		rellenarTable(libros, table);

		control.insertarLibro(new Libro("asdasd", "asd", "1", "asdas", Tematica.Ciencia, "yukmgh"));
		control.insertarLibro(new Libro("asdasd", "asd", "2", "asdas", Tematica.Ciencia, "yukmgh"));
		control.insertarLibro(new Libro("asdasd", "asd", "3", "asdas", Tematica.Ciencia, "yukmgh"));

		control.eliminarLibro("3");

		control.mostrarLibros();

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
				control.mostrarLibros();
			}
		});

	}

}
