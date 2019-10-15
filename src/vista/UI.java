package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Referencia;
import modelo.Tematica;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;

public class UI extends JFrame {

	protected ArrayList<JLabel> listLabel = new ArrayList<JLabel>();
	protected ArrayList<JTextField> listFields = new ArrayList<JTextField>();

	private final String[] campos = { "  Titulo :       ", "  Autor :       ", "  Tematica :  ", "  Paginas :    ",
			"  ISBN :        ", "  Precio :       " };

	private JPanel contentPane = new JPanel();

	protected JComboBox<Tematica> comboTematica = new JComboBox<Tematica>();

	private Color colorFondo = new Color(200, 200, 200); // 232, 225, 146
	private Color colorBtn = new Color(208, 222, 237);

	private JButton btnNuevo = new JButton("Nuevo");
	private JButton btnAdd = new JButton("Alta ISBN / Alta");
	private JButton btnBaja = new JButton("Baja ISBN / Baja");
	private JButton btnVerDetalles = new JButton("Ver Detalles");
	private JButton btnModificar = new JButton("Modificar");
	private JButton btnEliminar = new JButton("Eliminar");
	private JButton btnSalir = new JButton("Salir");

	private JPanel panel = new JPanel();
	private JPanel panelDatos = new JPanel();
	private JPanel panel_1 = new JPanel();

	private JRadioButton rdbtnNovedad = new JRadioButton("Novedad");
	private JRadioButton rdbtnReedicion = new JRadioButton("Reedici\u00F3n");
	private JRadioButton rdbtnCartone = new JRadioButton("Carton\u00E9");
	private JRadioButton rdbtnRustica = new JRadioButton("Rustica");
	private JRadioButton rdbtnDigital = new JRadioButton("Digital");

	private ButtonGroup groupFormato = new ButtonGroup();
	private ButtonGroup groupEstado = new ButtonGroup();

	private final JPanel panel_2 = new JPanel();

	private String[][] datos;

	private JTable table = new JTable();
	private JScrollPane scrollPane;

	protected PanelInfo panelInfo;

	public UI() {

		this.groupFormato.add(this.rdbtnCartone);
		this.groupFormato.add(this.rdbtnRustica);
		this.groupFormato.add(this.rdbtnDigital);

		this.groupEstado.add(this.rdbtnNovedad);
		this.groupEstado.add(this.rdbtnReedicion);

		ready();

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
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
		panelDatos.setLayout(new GridLayout(0, 1, 0, 28));

		panel_1.setBackground(this.colorFondo);
		panel.add(panel_1);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		verticalBox.setBackground(this.colorBtn);
		verticalBox.setOpaque(true);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		verticalBox_1.setBackground(this.colorBtn);
		verticalBox_1.setOpaque(true);

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(15)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(verticalBox, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE).addGap(10)
								.addComponent(verticalBox_1, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
				.addGap(15)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(10)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(verticalBox_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addComponent(verticalBox, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE).addGap(15)));
		panel_2.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblEstado.setBackground(this.colorBtn);
		lblEstado.setOpaque(true);

		JLabel lblNewLabel_1 = new JLabel("FORMATO");
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblNewLabel_1.setBackground(this.colorBtn);
		lblNewLabel_1.setOpaque(true);

		panel_1.setLayout(gl_panel_1);

		verticalBox_1.add(lblEstado);
		verticalBox_1.add(this.rdbtnNovedad);
		verticalBox_1.add(this.rdbtnReedicion);
		verticalBox.add(lblNewLabel_1);
		verticalBox.add(this.rdbtnCartone);
		verticalBox.add(this.rdbtnRustica);
		verticalBox.add(this.rdbtnDigital);

		panelBtn.add(this.btnNuevo);
		panelBtn.add(this.btnAdd);
		panelBtn.add(this.btnBaja);
		panelBtn.add(this.btnVerDetalles);
		panelBtn.add(this.btnEliminar);
		panelBtn.add(this.btnSalir);

		personalizarBtn(this.btnNuevo);
		personalizarBtn(this.btnEliminar);
		personalizarBtn(this.btnSalir);
		personalizarBtn(this.btnAdd);
		personalizarBtn(this.btnVerDetalles);
		personalizarBtn(this.btnBaja);

		personalizarRadioBtn(this.rdbtnNovedad);
		personalizarRadioBtn(this.rdbtnReedicion);
		personalizarRadioBtn(this.rdbtnCartone);
		personalizarRadioBtn(this.rdbtnRustica);
		personalizarRadioBtn(this.rdbtnDigital);

		rellenarPanelDatos();

		scrollPane.add(this.table);
		scrollPane.setViewportView(this.table);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));

		this.table.setRowHeight(25);
		this.table.setFont(new Font("Bookman Old Style", Font.ITALIC, 15));
		this.table.setDefaultEditor(Object.class, null); // no te deja editar la tabla

		soloLetras(this.listFields.get(1));
		soloLetras(this.listFields.get(0));
		soloNumeros(this.listFields.get(3));
		soloNumeros(this.listFields.get(4));
		soloNumeros(this.listFields.get(5));

		this.listFields.get(4).addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (listFields.get(4).getText().length() == 13) {
					e.consume();
				}
			}
		});

		revalidate();
		repaint();
	}

	public void soloLetras(Component component) {
		component.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < 'a' || e.getKeyChar() > 'z') && (e.getKeyChar() < 'A' || e.getKeyChar() > 'Z')) {
					e.consume();
				}
			}
		});
	}

	public void soloNumeros(Component component) {
		component.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < '0' || e.getKeyChar() > '9')) {
					e.consume();
				}
			}
		});
	}

	public HashMap<Referencia, String> obtenerMap() {
		HashMap<Referencia, String> map = new HashMap<Referencia, String>();
		map.put(Referencia.TITULO, this.listFields.get(0).getText());
		map.put(Referencia.AUTOR, this.listFields.get(1).getText());
		map.put(Referencia.PAGINAS, this.listFields.get(3).getText());
		map.put(Referencia.ISBN, this.listFields.get(4).getText());
		map.put(Referencia.PRECIO, this.listFields.get(5).getText());
		map.put(Referencia.FORMATO, obtenerFormato());
		map.put(Referencia.ESTADO, obtenerEstado());
		return map;
	}

	public HashMap<Referencia, String> getMapPanelInfo() {
		return this.panelInfo.getHashMap();
	}

	private String obtenerFormato() {
		if (this.rdbtnCartone.isSelected())
			return this.rdbtnCartone.getText();
		if (this.rdbtnRustica.isSelected())
			return this.rdbtnRustica.getText();
		if (this.rdbtnDigital.isSelected())
			return this.rdbtnDigital.getText();
		return null;
	}

	private String obtenerEstado() {
		if (this.rdbtnNovedad.isSelected())
			return this.rdbtnNovedad.getText();
		if (this.rdbtnReedicion.isSelected())
			return this.rdbtnReedicion.getText();
		return null;
	}

	public boolean isSelectFormato() {
		if (this.rdbtnCartone.isSelected() || this.rdbtnRustica.isSelected() || this.rdbtnDigital.isSelected())
			return true;
		WarningMessage("Debes marcar formato.");
		return false;
	}

	public boolean isSelectEstado() {
		if (this.rdbtnNovedad.isSelected() || this.rdbtnReedicion.isSelected())
			return true;
		WarningMessage("Debes marcar estado.");
		return false;
	}

	public void vaciarCampos() {
		this.groupFormato.clearSelection();
		this.groupEstado.clearSelection();
		for (JTextField field : this.listFields) {
			field.setText(null);
		}
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

	public void limpiarVista() {
		for (JTextField field : this.listFields) {
			field.setText("");
		}
	}

	private void ready() {
		for (int i = 0; i < this.campos.length; i++) {
			this.listFields.add(insertarJText());
			this.listLabel.add(insertarLabel(i));
		}
	}

	private void WarningMessage(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "error de datos ", JOptionPane.WARNING_MESSAGE);
	}

	private void rellenarPanelDatos() {
		this.panelDatos.add(new JLabel());
		this.panelDatos.add(insertarTitulo());
		Box boxAux = Box.createHorizontalBox();
		for (int i = 0; i < this.campos.length; i++) {
			boxAux = Box.createHorizontalBox();
			if (i == 2) {
				boxAux.add(this.listLabel.get(i));
				boxAux.add(insertarComboTematica());
			} else {
				boxAux.add(this.listLabel.get(i));
				boxAux.add(this.listFields.get(i));
			}
			this.panelDatos.add(boxAux);
		}
		this.panelDatos.add(new JLabel());
		revalidate();
		repaint();
	}

	private void personalizarBtn(JButton button) {
		button.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		button.setBackground(this.colorBtn);
		button.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
	}

	private void personalizarRadioBtn(JRadioButton radioBtn) {
		radioBtn.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 15));
		radioBtn.setBackground(this.colorBtn);
	}

	private JLabel insertarLabel(int i) {
		JLabel jLabel = new JLabel();
		jLabel.setText(this.campos[i]);
		jLabel.setForeground(Color.BLACK);
		jLabel.setFont(new Font("Book Antiqua", Font.ITALIC, 20));
		return jLabel;
	}

	private JComboBox<Tematica> insertarComboTematica() {
		this.comboTematica = new JComboBox<Tematica>();
		this.comboTematica.setForeground(Color.BLACK);
		this.comboTematica.setFont(new Font("Monospaced", Font.BOLD, 20));
		this.comboTematica.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		this.comboTematica.setBackground(Color.WHITE);
		this.panelDatos.add(this.comboTematica);
		for (Tematica tematica : Tematica.values()) {
			this.comboTematica.addItem(tematica);
		}
		return this.comboTematica;
	}

	private JTextField insertarJText() {
		JTextField field = new JTextField();
		field.setText(null);
		field.setForeground(Color.BLUE);
		field.setFont(new Font("Monospaced", Font.BOLD, 20));
		field.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		return field;
	}

	private JLabel insertarTitulo() {
		JLabel jLabel = new JLabel();
		jLabel.setText(" DATOS :");
		jLabel.setForeground(Color.BLACK);
		jLabel.setFont(new Font("Book Antiqua", Font.ROMAN_BASELINE, 30));
//		jLabel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		return jLabel;
	}

	public JTable getTable() {
		return table;
	}

	public String[][] getDatos() {
		return datos;
	}

	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnVerDetalles() {
		return btnVerDetalles;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnBaja() {
		return btnBaja;
	}

	public PanelInfo getPanelInfo() {
		return panelInfo;
	}

	public void setPanelInfo(PanelInfo panelInfo) {
		this.panelInfo = panelInfo;
	}

}
