package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.SwingConstants;

public class PanelInfo extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private ArrayList<JTextField> fields;
	private ArrayList<JLabel> labels;

	private String[] datos;
	private String[] nombreCampos = { "Titulo : ", "Autor : ", "Tematica : ", "Paginas : ", "ISBN : ", "Precio : " };

	public PanelInfo(String[] datos) {
		this.datos = datos;
		crearCampos();
		personalizarCampos();
		setVisible(true);
		setBackground(new Color(200, 200, 200));
		setBounds(100, 100, 508, 670);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		setResizable(false);

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
		for (int i = 0; i < this.fields.size(); i++) {
			this.labels.get(i).setFont(new Font("Bookman Old Style", Font.BOLD, 20));
			this.labels.get(i).setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			this.labels.get(i).setText(this.nombreCampos[i]);
			this.labels.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			this.contentPanel.add(this.labels.get(i));
			this.fields.get(i).setFont(new Font("Bookman Old Style", Font.BOLD, 20));
			this.fields.get(i).setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			this.fields.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			this.fields.get(i).setForeground(Color.BLUE);
			this.fields.get(i).setText(this.datos[i]);
			this.contentPanel.add(this.fields.get(i));
		}
	}

}
