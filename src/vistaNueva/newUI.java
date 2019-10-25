package vistaNueva;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Referencia;
import modelo.Tematica;
import vista.CreadorComponentes;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

public class newUI extends JFrame {

	private JPanel contentPane;

	private CreadorComponentes creador;

	private JTable jTable;

	private JComboBox<Tematica> comboTematica;

	private HashMap<Referencia, JButton> button;
	private HashMap<Referencia, JRadioButton> redioButton;

	private String[][] datosTable;

	private ButtonGroup formato;
	private ButtonGroup estado;
	private JTextField textFieldbbusqueda;

	private VentanaNuevoLibro ventanaNuevoLibro;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newUI frame = new newUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public newUI() {
		iniciarComponentes();
		ventanaNuevoLibro = new VentanaNuevoLibro();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(30, 0));

		JLabel lblNewLabel = new JLabel("Libreria");
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.ITALIC, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("Busqueda por ISBN:  ");
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.ITALIC, 20));
		panel_2.add(lblNewLabel_1, BorderLayout.WEST);

		textFieldbbusqueda = this.creador.dameJTextField();
		textFieldbbusqueda.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(textFieldbbusqueda, BorderLayout.CENTER);
		textFieldbbusqueda.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		JPanel panelBtn = new JPanel();
		contentPane.add(panelBtn, BorderLayout.SOUTH);
		scrollPane.add(this.jTable);
		scrollPane.setViewportView(this.jTable);

		panelBtn.setLayout(new GridLayout(1, 0, 20, 0));
		panelBtn.add(this.button.get(Referencia.BTN_NUEVO));
		panelBtn.add(this.button.get(Referencia.BTN_ALTA));
		panelBtn.add(this.button.get(Referencia.BTN_BAJA));
		panelBtn.add(this.button.get(Referencia.BTN_VERDETALLES));
		panelBtn.add(this.button.get(Referencia.BTN_ELIMINAR));
	}

	private void iniciarComponentes() {
		this.creador = new CreadorComponentes();
		this.redioButton = new HashMap<Referencia, JRadioButton>();
		this.button = new HashMap<Referencia, JButton>();
		this.jTable = new JTable();
		this.formato = new ButtonGroup();
		this.estado = new ButtonGroup();

		this.comboTematica = this.creador.dameJComboBox();
		for (Tematica tema : Tematica.values()) {
			this.comboTematica.addItem(tema);
		}

//		soloLetras(this.fields.get(Referencia.FIELD_AUTOR));
//		soloNumeros(this.fields.get(Referencia.FIELD_PRECIO));
//		soloNumeros(this.fields.get(Referencia.FIELD_PAGINAS));
//		soloNumeros(this.fields.get(Referencia.FIELD_BUSQUEDAISBN));
//		soloNumeros(this.fields.get(Referencia.FIELD_ISBN));
//		longitudMax(this.fields.get(Referencia.FIELD_ISBN), 13);
//		longitudMax(this.fields.get(Referencia.FIELD_BUSQUEDAISBN), 13);
		
		this.button.put(Referencia.BTN_NUEVO, this.creador.dameJButton("Añadir libro"));
		this.button.put(Referencia.BTN_ALTA, this.creador.dameJButton("Añadir"));
		this.button.put(Referencia.BTN_BAJA, this.creador.dameJButton("Quitar"));
		this.button.put(Referencia.BTN_VERDETALLES, this.creador.dameJButton("Ver Detalles"));
		this.button.put(Referencia.BTN_MODIFICAR, this.creador.dameJButton("Modificar"));
		this.button.put(Referencia.BTN_ELIMINAR, this.creador.dameJButton("Eliminar"));

	}

	public void rellenarTable(String[][] datosLibros) {
		this.datosTable = datosLibros;
		String[] nombreColumnas = { "TITULO", "AUTOR", "TEMA", "PAGINAS", "ISBN", "PRECIO", "CANTIDAD" };
		DefaultTableModel model = new DefaultTableModel(this.datosTable, nombreColumnas);
		this.jTable.setModel(model);
	}

	public boolean isEmptyField(Referencia referencia) {
		return this.ventanaNuevoLibro.isEmptyField(referencia);
	}

	public JTextField getField(Referencia referencia) {
		return this.ventanaNuevoLibro.getField(referencia);
	}

	public String getTextField(Referencia referencia) {
		return this.ventanaNuevoLibro.getTextField(referencia);
	}

}
