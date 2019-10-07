package vista;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class DiagoInfo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String[] datos;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutor;
	private JTextField textFieldTematica;
	private JTextField textFieldPaginas;
	private JTextField textFieldIsbn;
	private JTextField textFieldPrecio;

	public DiagoInfo(String[] datos) {
		this.datos = datos;
		setTitle("DATOS");
		setBackground(new Color(200, 200, 200));
		setResizable(false);
		setVisible(true);
		setBounds(100, 100, 400, 407);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(new BorderLayout(0, 0));

		JLabel lblPrecio_1 = new JLabel("Precio :      ");
		lblPrecio_1.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		panel_5.add(lblPrecio_1, BorderLayout.WEST);

		textFieldPrecio = new JTextField();
		textFieldPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPrecio.setText((String) null);
		textFieldPrecio.setEditable(false);
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBackground(Color.WHITE);
		panel_5.add(textFieldPrecio, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 10));

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));

		textFieldTitulo = new JTextField();
		textFieldTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTitulo.setBackground(Color.WHITE);
		textFieldTitulo.setEditable(false);
		panel.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);

		JLabel lblNewLabel = new JLabel("Titulo :        ");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		panel.add(lblNewLabel, BorderLayout.WEST);
		contentPanel.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblAutor = new JLabel("Autor :        ");
		lblAutor.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		panel_1.add(lblAutor, BorderLayout.WEST);

		textFieldAutor = new JTextField();
		textFieldAutor.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAutor.setBackground(Color.WHITE);
		textFieldAutor.setEditable(false);
		textFieldAutor.setColumns(10);
		panel_1.add(textFieldAutor, BorderLayout.CENTER);
		contentPanel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new BorderLayout(0, 0));

		JLabel lblTematica = new JLabel("Tematica :  ");
		lblTematica.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		panel_2.add(lblTematica, BorderLayout.WEST);

		textFieldTematica = new JTextField();
		textFieldTematica.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTematica.setBackground(Color.WHITE);
		textFieldTematica.setEditable(false);
		textFieldTematica.setColumns(10);
		panel_2.add(textFieldTematica, BorderLayout.CENTER);
		contentPanel.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new BorderLayout(0, 0));

		JLabel lblIsbn = new JLabel("Paginas :    ");
		lblIsbn.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		panel_3.add(lblIsbn, BorderLayout.WEST);

		textFieldPaginas = new JTextField();
		textFieldPaginas.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPaginas.setBackground(Color.WHITE);
		textFieldPaginas.setEditable(false);
		textFieldPaginas.setColumns(10);
		panel_3.add(textFieldPaginas, BorderLayout.CENTER);
		contentPanel.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(new BorderLayout(0, 0));

		JLabel lblPrecio = new JLabel("ISBN :        ");
		lblPrecio.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		panel_4.add(lblPrecio, BorderLayout.WEST);
		contentPanel.setBackground(new Color(200, 200, 200));

		textFieldIsbn = new JTextField();
		textFieldIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIsbn.setBackground(Color.WHITE);
		textFieldIsbn.setEditable(false);
		textFieldIsbn.setColumns(10);
		panel_4.add(textFieldIsbn, BorderLayout.CENTER);
		contentPanel.add(panel_4);
		contentPanel.add(panel_5);
		setLocationRelativeTo(null);

		panel.setBackground(new Color(200, 200, 200));
		panel_1.setBackground(new Color(200, 200, 200));
		panel_2.setBackground(new Color(200, 200, 200));
		panel_3.setBackground(new Color(200, 200, 200));
		panel_4.setBackground(new Color(200, 200, 200));
		panel_5.setBackground(new Color(200, 200, 200));

//		lblAutor.setForeground(new Color(238, 231, 23));

		rellenarDatos();
	}

	private void rellenarDatos() {
		setBackground(new Color(246, 247, 246));

		this.textFieldTitulo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		this.textFieldAutor.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		this.textFieldTematica.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		this.textFieldPaginas.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		this.textFieldIsbn.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		this.textFieldPrecio.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));

		this.textFieldTitulo.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		this.textFieldAutor.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		this.textFieldTematica.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		this.textFieldPaginas.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		this.textFieldIsbn.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		this.textFieldPrecio.setFont(new Font("Bookman Old Style", Font.BOLD, 20));

		this.textFieldTitulo.setText(this.datos[0]);
		this.textFieldAutor.setText(this.datos[1]);
		this.textFieldTematica.setText(this.datos[2]);
		this.textFieldPaginas.setText(this.datos[3]);
		this.textFieldIsbn.setText(this.datos[4]);
		this.textFieldPrecio.setText(this.datos[5]);
	}

	private void crearComunicador(JPanel jPanel) {
		Component[] components = jPanel.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (components[i] instanceof JTextField) {
			}
		}
	}

}
