package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modelo.Libro;
import modelo.Referencia;
import modelo.Tematica;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridLayout;
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

	protected JButton btnNuevo = new JButton("NUEVO");
	protected JButton btnEliminar = new JButton("ELIMINAR");
	protected JButton btnSalir = new JButton("SALIR");

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

	protected String[][] datos;

	protected JTable table = new JTable();
	private JScrollPane scrollPane;

	public UI() {

		this.groupFormato.add(this.rdbtnCartone);
		this.groupFormato.add(this.rdbtnRustica);
		this.groupFormato.add(this.rdbtnDigital);

		this.groupEstado.add(this.rdbtnNovedad);
		this.groupEstado.add(this.rdbtnReedicion);

		ready();

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 713);
		contentPane = new JPanel();
		contentPane.setBackground(this.colorFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);

		JLabel lblNewLabel = new JLabel("Librería");
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
		panelDatos.setLayout(new GridLayout(0, 1, 0, 35));

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
		verticalBox_1.add(rdbtnNovedad);
		verticalBox_1.add(rdbtnReedicion);
		verticalBox.add(lblNewLabel_1);
		verticalBox.add(rdbtnCartone);
		verticalBox.add(rdbtnRustica);
		verticalBox.add(rdbtnDigital);

		panelBtn.add(btnNuevo);
		panelBtn.add(btnEliminar);
		panelBtn.add(btnSalir);

		personalizarBtn(this.btnNuevo);
		personalizarBtn(this.btnEliminar);
		personalizarBtn(this.btnSalir);

		personalizarRadioBtn(this.rdbtnNovedad);
		personalizarRadioBtn(this.rdbtnReedicion);
		personalizarRadioBtn(this.rdbtnCartone);
		personalizarRadioBtn(this.rdbtnRustica);
		personalizarRadioBtn(this.rdbtnDigital);

		rellenarPanelDatos();

		scrollPane.add(this.table);
		scrollPane.setViewportView(this.table);
		this.table.setRowHeight(25);
		this.table.setFont(new Font("Bookman Old Style", Font.ITALIC, 18));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		
		
		ListSelectionModel model = this.table.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!model.isSelectionEmpty()) {
					int indice = model.getMinSelectionIndex();
					String[] dato = new String[6];
					dato[0] = datos[indice][0];
					dato[1] = datos[indice][1];
					dato[2] = obtenerTematica().toString();
					dato[3] = datos[indice][2];
					dato[4] = datos[indice][3];
					dato[5] = datos[indice][4];
					DiagoInfo diagoInfo = new DiagoInfo(dato);
				}
			}
		});
		

		revalidate();

	}

	protected HashMap<Referencia, String> obtenerMap() {
		HashMap<Referencia, String> map = new HashMap<Referencia, String>();
		map.put(Referencia.titulo, this.listFields.get(0).getText());
		map.put(Referencia.autor, this.listFields.get(1).getText());
		map.put(Referencia.paginas, this.listFields.get(3).getText());
		map.put(Referencia.isbn, this.listFields.get(4).getText());
		map.put(Referencia.precio, this.listFields.get(5).getText());
		map.put(Referencia.formato, obtenerFormato());
		map.put(Referencia.estado, obtenerEstado());
		return map;
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

	protected boolean isSelectFormato() {
		if (this.rdbtnCartone.isSelected() || this.rdbtnRustica.isSelected() || this.rdbtnDigital.isSelected())
			return true;
		WarningMessage("Debes marcar formato.");
		return false;
	}

	protected boolean isSelectEstado() {
		if (this.rdbtnNovedad.isSelected() || this.rdbtnReedicion.isSelected())
			return true;
		WarningMessage("Debes marcar estado.");
		return false;
	}

	protected void vaciarCampos() {
		this.groupFormato.clearSelection();
		this.groupEstado.clearSelection();
		for (JTextField field : this.listFields) {
			field.setText(null);
		}
	}

	protected Tematica obtenerTematica() {
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

	protected void rellenarTable(ArrayList<Libro> libros, JTable table) {
		String[] camposTable = { "ISBN", "Titulo", "Tematica" };
		this.datos = new String[libros.size()][camposTable.length];
		int indice = 0;
		for (Libro libro : libros) {
			this.datos[indice][0] = libro.getISBN();
			this.datos[indice][1] = libro.getTITULO();
			this.datos[indice][2] = libro.getTema().toString();
			indice++;
		}
		DefaultTableModel model = new DefaultTableModel(this.datos, camposTable);
		table.setModel(model);
		revalidate();
	}

	protected void limpiarVista() {
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

//	public void actualizarPantalla() {
//		try {
//			JPanel temp = (JPanel) this.getContentPane();
//			SwingUtilities.updateComponentTreeUI(temp);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

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
	}

	private void personalizarBtn(JButton button) {
		button.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
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
}
