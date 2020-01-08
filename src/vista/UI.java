package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import modelo.listener.Evento;
import modelo.listener.EventoKeyAdapter;
import modelo.enums.Libro;
import modelo.enums.NombreEvento;
import utiles.Utiles;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class UI extends JFrame {

	private JPanel contentPane;

	private Color colorFondo = new Color(254, 243, 196);

	private JDialogAltaLibro altaLibro = new JDialogAltaLibro(this);
	private JDialogHistoricoLibro historicoLibro = new JDialogHistoricoLibro(this);

	private JTable tabla = new JTable();

	private String[][] datos;

	private JTextField textbusquedaISBN;

	private JMenuItem itemNuevoLibro = this.crearJMenuItem("Registrar Nuevo Libro");
	private JMenuItem itemMasCantidad = this.crearJMenuItem("Comprar Libros");
	private JMenuItem itemMenosCantidad = this.crearJMenuItem("Vender Libros");
	private JMenuItem itemModificarLibro = this.crearJMenuItem("Modificar Precio");
	private JMenuItem itemNuevaTematica = this.crearJMenuItem("Resgistrar Tema");
	private JMenuItem itemEliminarTema = this.crearJMenuItem("Eliminar Tema");
	private JMenuItem itemNuevaEditorial = this.crearJMenuItem("Registrar Editorial");
	private JMenuItem itemEliminarEditorial = this.crearJMenuItem("Eliminar Editorial");
	private JMenuItem itemEliminarLibro = this.crearJMenuItem("Eliminar Libro");
	private JMenuItem itemHistoricoLibro = this.crearJMenuItem("Ver Historico Libro");

	public UI() {
		setVisible(true);
		setBackground(this.colorFondo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		setLocationRelativeTo(null);

		// ***************************************************************

		JMenuBar miMenu = new JMenuBar();
		miMenu.setBackground(Color.DARK_GRAY);
		setJMenuBar(miMenu);

		JMenu menuOpciones = this.crearJMenur("Libro");
		JMenu menuTema = this.crearJMenur("Tema");
		JMenu menuEditorial = this.crearJMenur("Editorial");
		JMenu menuHistorico = this.crearJMenur("Historico");

		miMenu.add(menuOpciones);
		miMenu.add(menuTema);
		miMenu.add(menuEditorial);
		miMenu.add(menuHistorico);

		menuOpciones.add(this.itemNuevoLibro);
		menuOpciones.add(this.itemMasCantidad);
		menuOpciones.add(this.itemMenosCantidad);
		menuOpciones.add(this.itemModificarLibro);
		menuOpciones.add(this.itemEliminarLibro);

		menuTema.add(this.itemNuevaTematica);
		menuTema.add(this.itemEliminarTema);

		menuEditorial.add(this.itemNuevaEditorial);
		menuEditorial.add(this.itemEliminarEditorial);

		menuHistorico.add(this.itemHistoricoLibro);

		// ***************************************************************

		contentPane = new JPanel();
		this.contentPane.setBackground(this.colorFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		scrollPane.setBackground(this.colorFondo);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		scrollPane.add(this.tabla);
		scrollPane.setViewportView(this.tabla);

		JPanel panel = new JPanel();
		panel.setBackground(this.colorFondo);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("BUSQUEDA POR ISBN :      ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		panel.add(lblNewLabel, BorderLayout.WEST);

		this.textbusquedaISBN = new JTextField();
		this.textbusquedaISBN.setBackground(Color.WHITE);
		this.textbusquedaISBN.setForeground(new Color(106, 93, 77));
		this.textbusquedaISBN.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.textbusquedaISBN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.textbusquedaISBN.setHorizontalAlignment(SwingConstants.CENTER);
		this.textbusquedaISBN.setColumns(10);
		this.longitudMax(this.textbusquedaISBN, 13);
		this.soloNumeros(this.textbusquedaISBN);

		JLabel lblNewLabel_1 = new JLabel(" ");
		JLabel lblNewLabel_2 = new JLabel(" ");
		panel.add(this.textbusquedaISBN, BorderLayout.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.SOUTH);
		panel.add(lblNewLabel_2, BorderLayout.NORTH);
		scrollPane.setBorder(new LineBorder(Color.black, 2));

		this.actualizarTabla(null);
		this.crearEventos();
		this.setExtendedState(MAXIMIZED_BOTH);
		this.personalizarTabla();
	}

	public void actualizarTabla(String[][] datos) {
		String[] nombreColumnas = { "ISBN", "TITULO", "AUTOR", "PAGINAS", "PRECIO", "TEMATICA", "EDITORIAL",
				"FORMATO", "ESTADO", "CANTIDAD" };
		this.datos = datos;
		DefaultTableModel model = new DefaultTableModel(datos, nombreColumnas);
		this.tabla.setModel(model);
		revalidate();
	}

	public HashMap<Libro, String> obtenerDatosAltaLibro() {
		return this.altaLibro.obtenerDatos();
	}

	public void actualizarTableHistorico() {
		this.historicoLibro.actualizarTable();
	}

	public boolean isSelectRowTable() {
		if (this.tabla.getSelectedRow() != -1)
			return true;
		Utiles.mensajeError("Debes seleccionar una fila de la tabla");
		return false;
	}

	private void personalizarTabla() {
		this.tabla.setBackground(this.colorFondo);
		this.tabla.setForeground(Color.black);
		this.tabla.setRowHeight(30);
		this.tabla.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 15));
		this.tabla.setDefaultEditor(Object.class, null); // no te deja editar la tabla
		this.tabla.setBackground(Color.LIGHT_GRAY);
		this.tabla.setForeground(Color.BLACK);
		this.tabla.setGridColor(Color.LIGHT_GRAY);

		JTableHeader cabecera = this.tabla.getTableHeader();
		cabecera.setBorder(new LineBorder(Color.DARK_GRAY, 5));
		cabecera.setOpaque(true);
		cabecera.setFont(new Font("Arial Blac", Font.BOLD, 15));
		cabecera.setBackground(Color.DARK_GRAY);
		cabecera.setForeground(Color.WHITE);
		cabecera.setSize(50, 50);
		cabecera.setPreferredSize(new Dimension(6, cabecera.getWidth()));
	}

	private JMenuItem crearJMenuItem(String titulo) {
		JMenuItem item = new JMenuItem(titulo);
		item.setFont(new Font("Arial", Font.BOLD, 20));
		item.setHorizontalAlignment(SwingConstants.CENTER);
		item.setForeground(Color.black);
		item.setBackground(Color.LIGHT_GRAY);
		item.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
		return item;
	}

	private JMenu crearJMenur(String titulo) {
		JMenu menu = new JMenu(titulo);
		menu.setForeground(Color.WHITE);
		menu.setFont(new Font("Arial", Font.BOLD, 25));
		return menu;
	}

	private void longitudMax(JTextField field, int longitud) {
		field.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (field.getText().length() == longitud)
					e.consume();
			}
		});
	}

	private void soloNumeros(Component component) {
		component.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < '0' || e.getKeyChar() > '9'))
					e.consume();
			}
		});
	}

	private void crearEventos() {
		this.itemMasCantidad.addActionListener(new Evento(NombreEvento.ComprarLibros));
		this.itemMenosCantidad.addActionListener(new Evento(NombreEvento.VenderLibros));
		this.itemModificarLibro.addActionListener(new Evento(NombreEvento.ModificarPrecioLibro));
		this.itemEliminarLibro.addActionListener(new Evento(NombreEvento.EliminarLibro));
		this.itemNuevaTematica.addActionListener(new Evento(NombreEvento.NuevoTema));
		this.itemNuevaEditorial.addActionListener(new Evento(NombreEvento.NuevaEditorial));
		this.itemEliminarTema.addActionListener(new Evento(NombreEvento.EliminarTema));
		this.itemEliminarEditorial.addActionListener(new Evento(NombreEvento.EliminarEditorial));
		this.textbusquedaISBN.addKeyListener(new EventoKeyAdapter(NombreEvento.BusquedaPorISBN));
		this.altaLibro.getOkButton().addActionListener(new Evento(NombreEvento.NuevoLibro));
		this.itemNuevoLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaLibro.setVisible(true);
			}
		});
		this.itemHistoricoLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				historicoLibro.setVisible(true);
			}
		});
	}

	public String obtenerISBNTable() {
		return this.datos[this.tabla.getSelectedRow()][0];
	}

	public void actualizarComboEditorial() {
		this.altaLibro.actualizarComboEditorial();
	}

	public void actualizarComboTema() {
		this.altaLibro.actualizarComboTema();
	}

	public void limpiarVista() {
		this.altaLibro.limpiarCampos();
	}

	public JTextField getTextbusquedaISBN() {
		return textbusquedaISBN;
	}

	public JTable getTabla() {
		return tabla;
	}

	public String[][] getDatos() {
		return datos;
	}

}
