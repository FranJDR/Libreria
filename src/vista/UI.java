package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import modelo.Libro;
import modelo.Tematica;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;

public class UI extends JFrame {

	protected ArrayList<JLabel> listLabel = new ArrayList<JLabel>();
	protected ArrayList<JTextField> listCampos = new ArrayList<JTextField>();

	private final String[] campos = { "  Titulo :   ", "  Autor :    ", "  Tematica : ", "  Paginas :  ",
			"  ISBN :     ", "  Precio :   " };

	private JPanel contentPane = new JPanel();

	protected JComboBox<Tematica> comboTematica = new JComboBox<Tematica>();

	private Color colorFondo = new Color(232, 225, 146);
	private Color colorBtn = new Color(197, 225, 58);

	protected JButton btnNuevo = new JButton("NUEVO");
	protected JButton btnAlta = new JButton("ALTA");
	protected JButton btnBaja = new JButton("BAJA");
	protected JButton btnSalir = new JButton("SALIR");

	private JPanel panel = new JPanel();
	private JPanel panelDatos = new JPanel();
	private JPanel panel_1 = new JPanel();

	private JRadioButton rdbtnNovedad = new JRadioButton("Novedad");
	private JRadioButton rdbtnReedicion = new JRadioButton("Reedici\u00F3n");
	private JRadioButton rdbtnCartone = new JRadioButton("Carton\u00E9");
	private JRadioButton rdbtnRustica = new JRadioButton("Rustica");
	private JRadioButton rdbtnDigital = new JRadioButton("Digital");
	
	private DefaultTableModel model;
	
	private final JPanel panel_2 = new JPanel();

	protected JTable table = new JTable();

	public UI() {
		ready();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(this.colorFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);

		JLabel lblNewLabel = new JLabel("Librer�a");
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(this.colorBtn);
		lblNewLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
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
		verticalBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		verticalBox.setBackground(this.colorBtn);
		verticalBox.setOpaque(true);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		verticalBox_1.setBackground(this.colorBtn);
		verticalBox_1.setOpaque(true);

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(15)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(verticalBox, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE).addGap(10)
								.addComponent(verticalBox_1, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
				.addGap(15)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(10)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(verticalBox_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(verticalBox, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGap(15)));
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
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
		panelBtn.add(btnAlta);
		panelBtn.add(btnBaja);
		panelBtn.add(btnSalir);

		personalizarBtn(this.btnNuevo);
		personalizarBtn(this.btnAlta);
		personalizarBtn(this.btnBaja);
		personalizarBtn(this.btnSalir);

		personalizarRadioBtn(this.rdbtnNovedad);
		personalizarRadioBtn(this.rdbtnReedicion);
		personalizarRadioBtn(this.rdbtnCartone);
		personalizarRadioBtn(this.rdbtnRustica);
		personalizarRadioBtn(this.rdbtnDigital);

		rellenarPanelDatos();

		scrollPane.add(this.table);

		revalidate();

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

	protected void rellenarTable(Libro[] libros, JTable table) {
		String[] camposTable = { "ISBN", "Titulo", "Tematica" };
		String[][] datos = new String[libros.length][camposTable.length];
		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = libros[i].getISBN();
			datos[i][1] = libros[i].getTitulo();
			datos[i][2] = libros[i].getTema().toString();
		}
		model = new DefaultTableModel(datos, camposTable);
		table.setModel(model);
		revalidate();
	}

	protected void limpiarVista() {
		for (JTextField field : this.listCampos) {
			field.setText("");
		}
	}

	public void ready() {
		for (int i = 0; i < this.campos.length; i++) {
			this.listCampos.add(insertarJText());
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
				boxAux.add(this.listCampos.get(i));
			}
			this.panelDatos.add(boxAux);
		}
		this.panelDatos.add(new JLabel());
		revalidate();
	}

	private void personalizarBtn(JButton button) {
		button.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
		button.setBackground(this.colorBtn);
		button.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	}

	private void personalizarRadioBtn(JRadioButton radioBtn) {
		radioBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
		radioBtn.setBackground(this.colorBtn);
	}

	private JLabel insertarLabel(int i) {
		JLabel jLabel = new JLabel();
		jLabel.setText(this.campos[i]);
		jLabel.setForeground(Color.BLACK);
		jLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		return jLabel;
	}

	private JComboBox<Tematica> insertarComboTematica() {
		this.comboTematica = new JComboBox<Tematica>();
		this.comboTematica.setForeground(Color.BLACK);
		this.comboTematica.setFont(new Font("Monospaced", Font.BOLD, 20));
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
		field.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		return field;
	}

	private JLabel insertarTitulo() {
		JLabel jLabel = new JLabel();
		jLabel.setText(" DATOS");
		jLabel.setForeground(Color.BLACK);
		jLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
		return jLabel;
	}
}

class TableroLibro extends AbstractTableModel {

	private int numFilas;
	private int numColumnas;

	public TableroLibro(int numFilas, int numColumnas) {
		super();
		this.numFilas = numFilas;
		this.numColumnas = numColumnas;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnName(int arg0) {
		return super.getColumnName(arg0);
	}

}
