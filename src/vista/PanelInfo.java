package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import modelo.enums.ReferenciaDatos;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.SwingConstants;

public class PanelInfo extends JDialog {

	private ArrayList<JTextField> fields;
	private ArrayList<JLabel> labels;

	private String[] datos;
	private String[] nombreCampos = { "Titulo : ", "Autor : ", "Tematica : ", "Paginas : ", "ISBN : ", "Precio : ",
			"Cantidad : ", "Editorial : " };

	private JButton btnModificar = new JButton("MODIFICAR");
	private JPanel panelBtn = new JPanel();
	private JPanel panelCampos = new JPanel();

	public PanelInfo(String[] datos, JButton btn, JFrame frame) {
		super(frame);
		this.btnModificar = btn;
		this.datos = datos;
		setVisible(true);
		setBackground(new Color(200, 200, 200));
		setBounds(100, 100, 450, 350);

		getContentPane().setLayout(new BorderLayout());
		setMinimumSize(new Dimension(400, 400));
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null);
		setModal(true);
		getContentPane().add(panelCampos, BorderLayout.CENTER);
		panelCampos.setLayout(new GridLayout(0, 2, 0, 0));
		getContentPane().add(panelBtn, BorderLayout.SOUTH);

		JLabel lblDatos = new JLabel("DATOS");
		lblDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatos.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
//		lblDatos.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		getContentPane().add(lblDatos, BorderLayout.NORTH);
		panelBtn.setLayout(new GridLayout(0, 1, 0, 0));

		this.btnModificar.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		this.btnModificar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		this.panelBtn.add(this.btnModificar);
		crearCampos();
		personalizarCampos();
	}

	public HashMap<ReferenciaDatos, String> getHashMap() {
		HashMap<ReferenciaDatos, String> retorno = new HashMap<ReferenciaDatos, String>();
		retorno.put(ReferenciaDatos.TITULO, this.fields.get(0).getText());
		retorno.put(ReferenciaDatos.AUTOR, this.fields.get(1).getText());
		retorno.put(ReferenciaDatos.PAGINAS, this.fields.get(3).getText());
		retorno.put(ReferenciaDatos.ISBN, this.fields.get(4).getText());
		retorno.put(ReferenciaDatos.PRECIO, this.fields.get(5).getText());
		return retorno;
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
		this.bloquearFields();
		for (int i = 0; i < this.fields.size(); i++) {
			this.labels.get(i).setFont(new Font("Bookman Old Style", Font.BOLD, 20));
			this.labels.get(i).setBorder(new MatteBorder(2, 2, 0, 0, (Color) new Color(0, 0, 0)));
			this.labels.get(i).setText(this.nombreCampos[i]);
			this.labels.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			this.panelCampos.add(this.labels.get(i));
			this.fields.get(i).setFont(new Font("Bookman Old Style", Font.BOLD, 20));
			this.fields.get(i).setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
			this.fields.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			if (i == 5) {
				this.fields.get(i).setForeground(Color.red);
			} else {
				this.fields.get(i).setForeground(Color.BLUE);
			}
			this.fields.get(i).setText(this.datos[i]);
			this.panelCampos.add(this.fields.get(i));
		}
	}

	private void bloquearFields() {
		this.fields.get(0).setFocusable(false);
		this.fields.get(1).setFocusable(false);
		this.fields.get(2).setFocusable(false);
		this.fields.get(3).setFocusable(false);
		this.fields.get(4).setFocusable(false);
		this.fields.get(6).setFocusable(false);
		this.fields.get(7).setFocusable(false);
	}

}
