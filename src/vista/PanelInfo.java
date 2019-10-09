package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import modelo.Referencia;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.SwingConstants;

public class PanelInfo extends JDialog {

	private ArrayList<JTextField> fields;
	private ArrayList<JLabel> labels;

	private String[] datos;
	private String[] nombreCampos = { "Titulo : ", "Autor : ", "Tematica : ", "Paginas : ", "ISBN : ", "Precio : " };

	private JButton btnModificar = new JButton("MODIFICAR");
	private JPanel panelBtn = new JPanel();
	private JPanel panelCampos = new JPanel();
	private HashMap<Referencia, String> map = new HashMap<Referencia, String>();

	public PanelInfo(String[] datos, JButton btn) {
		this.btnModificar = btn;
		this.datos = datos;
		crearCampos();
		personalizarCampos();
		setVisible(true);
		setBackground(new Color(200, 200, 200));
		setBounds(100, 100, 508, 670);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setResizable(false);
		getContentPane().add(panelCampos, BorderLayout.CENTER);
		panelCampos.setLayout(new GridLayout(0, 2, 0, 0));
		getContentPane().add(panelBtn, BorderLayout.SOUTH);

		JLabel lblDatos = new JLabel("DATOS");
		lblDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatos.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
		lblDatos.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		getContentPane().add(lblDatos, BorderLayout.NORTH);
		panelBtn.setLayout(new GridLayout(0, 1, 0, 0));

		this.btnModificar.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		this.btnModificar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		this.panelBtn.add(this.btnModificar);

		rellenarHashMap();
	}

	private void rellenarHashMap() {
		this.map.put(Referencia.titulo, this.fields.get(0).getText());
		this.map.put(Referencia.autor, this.fields.get(1).getText());
		this.map.put(Referencia.paginas, this.fields.get(3).getText());
		this.map.put(Referencia.isbn, this.fields.get(4).getText());
		this.map.put(Referencia.precio, this.fields.get(5).getText());
	}

	private void crearCampos() {
		this.labels = new ArrayList<JLabel>();
		this.fields = new ArrayList<JTextField>();
		for (int i = 0; i < this.datos.length; i++) {
			this.labels.add(new JLabel());
			this.fields.add(new JTextField());
		}
	}

	private void personalizarCampos() {
		this.fields.get(0).setFocusable(false);
		this.fields.get(1).setFocusable(false);
		this.fields.get(2).setFocusable(false);
		this.fields.get(3).setFocusable(false);
		this.fields.get(4).setFocusable(false);
		for (int i = 0; i < this.fields.size(); i++) {
			this.labels.get(i).setFont(new Font("Bookman Old Style", Font.BOLD, 20));
			this.labels.get(i).setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			this.labels.get(i).setText(this.nombreCampos[i]);
			this.labels.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			this.panelCampos.add(this.labels.get(i));
			this.fields.get(i).setFont(new Font("Bookman Old Style", Font.BOLD, 20));
			this.fields.get(i).setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			this.fields.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			this.fields.get(i).setForeground(Color.BLUE);
			this.fields.get(i).setText(this.datos[i]);
			this.panelCampos.add(this.fields.get(i));
		}
	}

	public HashMap<Referencia, String> getMap() {
		return this.map;
	}

}
