package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import modelo.Conexion;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JDialogHistoricoLibro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final String[] nombreColumnas = { "ISBN", "Operacion", "Fecha" };
	private Color colorFondo = new Color(254, 243, 196);
	
	private JTable table = new JTable();

	public JDialogHistoricoLibro(JFrame padre) {
		super(padre, true);
		setResizable(false);
		setBackground(this.colorFondo);
		setTitle("HISTORICO");
		this.contentPanel.setBackground(this.colorFondo);
		setBounds(100, 100, 826, 663);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		this.personalizarJTable();
		this.actualizarTable();
	}

	private void personalizarJTable() {
		this.table.setRowHeight(30);
		this.table.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 15));
		this.table.setDefaultEditor(Object.class, null); // no te deja editar la tabla
		this.table.setBackground(Color.LIGHT_GRAY);
		this.table.setForeground(Color.BLACK);
		this.table.setGridColor(Color.LIGHT_GRAY);

		JTableHeader cabecera = this.table.getTableHeader();
		cabecera.setBorder(new LineBorder(Color.DARK_GRAY, 5));
		cabecera.setOpaque(true);
		cabecera.setFont(new Font("Arial Blac", Font.BOLD, 15));
		cabecera.setBackground(Color.DARK_GRAY);
		cabecera.setForeground(Color.WHITE);
		cabecera.setSize(50, 50);
		cabecera.setPreferredSize(new Dimension(6, cabecera.getWidth()));
	}

	public void actualizarTable() {
		DefaultTableModel model = new DefaultTableModel(Conexion.instance().obtenerTablaHistorico(), this.nombreColumnas);
		this.table.setModel(model);
		revalidate();
	}

}
