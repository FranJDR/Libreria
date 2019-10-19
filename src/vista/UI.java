package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Referencia;
import modelo.Tematica;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JButton;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UI extends JFrame {

	private GestorVista gestor = new GestorVista();

	private JPanel contentPane = new JPanel();

	protected JComboBox<Tematica> comboTematica = new JComboBox<Tematica>();

	private Color colorFondo = new Color(254, 243, 196); // 232, 225, 146
	private Color colorBtn = new Color(238, 236, 226);

	private JPanel panel = new JPanel();
	private JPanel panelDatos = new JPanel();
	private JPanel panel_1 = new JPanel();

	private final JPanel panel_2 = new JPanel();

	private String[][] datos;

	private JTable table = new JTable();
	private JScrollPane scrollPane;

	protected PanelInfo panelInfo;
	private JTextField fieldBusquedaISBN;
	private JPanel panelLabel;
	private JPanel panelField;

	public UI() {
		this.gestor = new GestorVista();

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setMinimumSize(new Dimension(800, 800));
		contentPane = new JPanel();
		contentPane.setBackground(this.colorFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);

		JLabel lblNewLabel = new JLabel("Librer�a");
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(this.colorBtn);
		lblNewLabel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panelBtn = new JPanel();
		panelBtn.setBackground(this.colorFondo);
		panelBtn.setMinimumSize(new Dimension(100, 50));
		contentPane.add(panelBtn, BorderLayout.SOUTH);
		panelBtn.setLayout(new GridLayout(1, 0, 10, 30));

		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		panelDatos.setBackground(this.colorFondo);
		panel.add(panelDatos);

		JLabel lblRegistrarNuevoLibro = new JLabel("REGISTRAR NUEVO LIBRO");
		lblRegistrarNuevoLibro.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		lblRegistrarNuevoLibro.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		panelLabel = new JPanel();
		panelLabel.setBackground(this.colorFondo);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		verticalBox.setBackground(this.colorBtn);
		verticalBox.setOpaque(true);

		JLabel lblNewLabel_1 = new JLabel("FORMATO");
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		lblNewLabel_1.setBackground(this.colorBtn);
		lblNewLabel_1.setOpaque(true);
		verticalBox.add(lblNewLabel_1);
		verticalBox.add(this.gestor.getRadioBtn(Referencia.RADIOBTN_CARTONE));
		verticalBox.add(this.gestor.getRadioBtn(Referencia.RADIOBTN_RUSTICA));
		verticalBox.add(this.gestor.getRadioBtn(Referencia.RADIOBTN_DIGITAL));

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		verticalBox_1.setBackground(this.colorBtn);
		verticalBox_1.setOpaque(true);

		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		lblEstado.setBackground(this.colorBtn);
		lblEstado.setOpaque(true);

		verticalBox_1.add(lblEstado);
		verticalBox_1.add(this.gestor.getRadioBtn(Referencia.RADIOBTN_NOVEDAD));
		verticalBox_1.add(this.gestor.getRadioBtn(Referencia.RADIOBTN_REEDICION));

		panelField = new JPanel();
		panelField.setBackground(this.colorFondo);
		GroupLayout gl_panelDatos = new GroupLayout(panelDatos);
		gl_panelDatos.setHorizontalGroup(
			gl_panelDatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDatos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDatos.createSequentialGroup()
							.addComponent(panelLabel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelField, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
						.addGroup(gl_panelDatos.createSequentialGroup()
							.addComponent(verticalBox, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
							.addGap(20)
							.addComponent(verticalBox_1, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
						.addComponent(lblRegistrarNuevoLibro))
					.addContainerGap())
		);
		gl_panelDatos.setVerticalGroup(
			gl_panelDatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDatos.createSequentialGroup()
					.addGap(15)
					.addComponent(lblRegistrarNuevoLibro, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
						.addComponent(panelField, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
						.addComponent(panelLabel, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
						.addComponent(verticalBox_1, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
						.addComponent(verticalBox, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelField.setLayout(new GridLayout(0, 1, 0, 30));
		panelLabel.setLayout(new GridLayout(0, 1, 0, 30));
		panelDatos.setLayout(gl_panelDatos);

		panel_1.setBackground(this.colorFondo);
		panel.add(panel_1);

		fieldBusquedaISBN = new JTextField();
		fieldBusquedaISBN.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		fieldBusquedaISBN.setHorizontalAlignment(SwingConstants.CENTER);
		fieldBusquedaISBN.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		fieldBusquedaISBN.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Busqueda por ISBN :");
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_2.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(15)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel_2).addGap(30)
								.addComponent(fieldBusquedaISBN, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
				.addGap(15)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(20)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(fieldBusquedaISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
						.addGap(20).addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE).addGap(15)));
		panel_2.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		panel_1.setLayout(gl_panel_1);

		panelBtn.add(this.gestor.getBtn(Referencia.BTN_NUEVO));
		panelBtn.add(this.gestor.getBtn(Referencia.BTN_ALTA));
		panelBtn.add(this.gestor.getBtn(Referencia.BTN_BAJA));
		panelBtn.add(this.gestor.getBtn(Referencia.BTN_VERDETALLES));
		panelBtn.add(this.gestor.getBtn(Referencia.BTN_ELIMINAR));
		panelBtn.add(this.gestor.getBtn(Referencia.BTN_SALIR));

		scrollPane.add(this.table);
		scrollPane.setViewportView(this.table);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));

		this.table.setRowHeight(25);
		this.table.setFont(new Font("Bookman Old Style", Font.ITALIC, 15));
		this.table.setDefaultEditor(Object.class, null); // no te deja editar la tabla
		personalizarComboTematica();
		rellenarPanelDatos();
		revalidate();
		repaint();
	}

	public void limpiarVista() {
		this.gestor.limpiarVista();
	}

	public boolean isSelectFormato() {
		return this.gestor.isSelectFormato();
	}

	public boolean isSelectEstado() {
		return this.gestor.isSelectEstado();
	}

	public HashMap<Referencia, String> getMapPanelInfo() {
		return this.panelInfo.getHashMap();
	}

	public HashMap<Referencia, String> getDatosField() {
		return this.gestor.getDatosField();
	}

	public Tematica obtenerTematica() {
		switch (this.comboTematica.getSelectedItem().toString()) {
		case "Poesia":
			return Tematica.Poesia;
		case "Fantasia":
			return Tematica.Fantasia;
		case "Ficcion":
			return Tematica.Ficcion;
		case "Economia":
			return Tematica.Economia;
		case "Psicologia":
			return Tematica.Psicologia;
		case "Historia":
			return Tematica.Historia;
		case "Ciencia":
			return Tematica.Ciencia;
		default:
			return Tematica.Poesia;
		}
	}

	public void rellenarTable(String[][] datos, JTable table) {
		String[] camposTable = { "ISBN", "TITULO", "TEMATICA", "CANTIDAD", "PRECIO" };
		this.datos = datos;
		String[][] aux = new String[this.datos.length][camposTable.length];
		for (int i = 0; i < this.datos.length; i++) {
			aux[i][0] = this.datos[i][4];
			aux[i][1] = this.datos[i][0];
			aux[i][2] = this.datos[i][2];
			aux[i][3] = this.datos[i][6];
			aux[i][4] = this.datos[i][5] + "$";
		}
		DefaultTableModel model = new DefaultTableModel(aux, camposTable);
		table.setModel(model);
		revalidate();
	}

	private void rellenarPanelDatos() {
		this.panelLabel.add(newLabel("Titulo : ", 14));
		this.panelField.add(this.gestor.getField(Referencia.FIELD_TITULO));
		this.panelLabel.add(newLabel("Autor : ", 14));
		this.panelField.add(this.gestor.getField(Referencia.FIELD_AUTOR));
		this.panelLabel.add(newLabel("Tematica : ", 8));
		this.panelField.add(this.comboTematica);
		this.panelLabel.add(newLabel("ISBN : ", 14));
		this.panelField.add(this.gestor.getField(Referencia.FIELD_ISBN));
		this.panelLabel.add(newLabel("Num.Paginas : ", 1));
		this.panelField.add(this.gestor.getField(Referencia.FIELD_PAGINAS));
		this.panelLabel.add(newLabel("Precio : ", 14));
		this.panelField.add(this.gestor.getField(Referencia.FIELD_PRECIO));
		revalidate();
		repaint();
	}

	private JLabel newLabel(String titulo, int cantidad) {
		for (int i = 0; i < cantidad; i++) {
			titulo += " ";
		}
		JLabel jLabel = new JLabel(titulo);
		jLabel.setForeground(Color.BLACK);
		jLabel.setFont(new Font("Book Antiqua", Font.ITALIC, 20));
		return jLabel;
	}

	private void personalizarComboTematica() {
		this.comboTematica = new JComboBox<Tematica>();
		this.comboTematica.setForeground(Color.BLACK);
		this.comboTematica.setFont(new Font("Monospaced", Font.BOLD, 20));
		this.comboTematica.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		this.comboTematica.setBackground(Color.white);
		this.panelDatos.add(this.comboTematica);
		for (Tematica tematica : Tematica.values()) {
			this.comboTematica.addItem(tematica);
		}
	}

	public JButton getBtn(Referencia referencia) {
		return this.gestor.getBtn(referencia);
	}

	public JTable getTable() {
		return table;
	}

	public String[][] getDatos() {
		return datos;
	}

	public PanelInfo getPanelInfo() {
		return panelInfo;
	}

	public void setPanelInfo(PanelInfo panelInfo) {
		this.panelInfo = panelInfo;
	}
}
