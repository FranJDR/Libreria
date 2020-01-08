package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Conexion;
import modelo.enums.Libro;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;

public class JDialogAltaLibro extends JDialog {

    private final JPanel contentPanel = new JPanel();

    private Color colorFondo = new Color(254, 243, 196);

    private int sizeLetra = 18;

    private String[] nombreCampos = {"ISBN : ", "Titulo : ", "Autor : ", "N� de Paginas : ", "Precio : ",
            "Tematica : ", "Editorial : ", "Formato : ", "Estado : "};

    private JComboBox<String> comboTema = new JComboBox<String>();
    private JComboBox<String> comboEditorial = new JComboBox<String>();
    private JComboBox<String> comboFormato = new JComboBox<String>();
    private JComboBox<String> comboEstado = new JComboBox<String>();

    private ArrayList<JTextField> fields = new ArrayList<JTextField>();

    private JPanel panelLabel;
    private JPanel panelCampo;
    private JButton okButton;

    public JDialogAltaLibro(JFrame padre) {
        super(padre, true);
        setBackground(this.colorFondo);
        setTitle("Alta Libro");
        setResizable(false);
        setBounds(100, 100, 600, 600);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        {
            JPanel panel = new JPanel();
            panel.setBackground(this.colorFondo);
            contentPanel.add(panel, BorderLayout.CENTER);
            panelLabel = new JPanel();
            panelCampo = new JPanel();
            GroupLayout gl_panel = new GroupLayout(panel);
            gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
                    .createSequentialGroup().addGap(30)
                    .addComponent(panelLabel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE).addGap(18)
                    .addComponent(panelCampo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(30)));
            gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
                    gl_panel.createSequentialGroup().addGap(30)
                            .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                                    .addComponent(panelCampo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 471,
                                            Short.MAX_VALUE)
                                    .addComponent(panelLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 0,
                                            Short.MAX_VALUE))
                            .addGap(30)));
            panelLabel.setLayout(new GridLayout(0, 1, 0, 10));
            panel.setLayout(gl_panel);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(this.colorFondo);
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                okButton = new JButton("OK"); // hay que ponerle la accion
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        limpiarCampos();
                        setVisible(false);
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }

        this.contentPanel.setBackground(this.colorFondo);
        this.panelCampo.setBackground(this.colorFondo);
        this.panelLabel.setBackground(this.colorFondo);

        this.crearLabelNombreCampos();
        this.crearCampos();
        this.rellenarCombos();

        this.comboEditorial.setBackground(Color.white);
        this.comboEstado.setBackground(Color.white);
        this.comboFormato.setBackground(Color.white);
        this.comboTema.setBackground(Color.white);

        this.comboEditorial.setFont(new Font("Arial Blac", Font.BOLD, this.sizeLetra));
        this.comboEstado.setFont(new Font("Arial Blac", Font.BOLD, this.sizeLetra));
        this.comboFormato.setFont(new Font("Arial Blac", Font.BOLD, this.sizeLetra));
        this.comboTema.setFont(new Font("Arial Blac", Font.BOLD, this.sizeLetra));

        this.comboEditorial.setForeground(new Color(106, 93, 77));
        this.comboEstado.setForeground(new Color(106, 93, 77));
        this.comboFormato.setForeground(new Color(106, 93, 77));
        this.comboTema.setForeground(new Color(106, 93, 77));
    }

    public void limpiarCampos() {
        for (JTextField jTextField : this.fields) {
            jTextField.setText(null);
        }
    }

    public void actualizarComboEditorial() {
        this.comboEditorial.removeAll();
        ArrayList<String> editorial = Conexion.instance().obtenerListCampo("SELECT * FROM EDITORIAL", "nombre");
        for (String valor : editorial)
            this.comboEditorial.addItem(valor);
    }

    public void actualizarComboTema() {
        this.comboTema.removeAll();
        ArrayList<String> tema = Conexion.instance().obtenerListCampo("SELECT * FROM TEMA", "nombre");
        for (String valor : tema)
            this.comboTema.addItem(valor);
    }

    private void rellenarCombos() {
        String[] formato = {"Cartone", "Rustica", "Digital"};
        String[] estado = {"Novedad", "Reedicion"};
        for (String valor : formato)
            this.comboFormato.addItem(valor);
        for (String valor : estado)
            this.comboEstado.addItem(valor);
        this.actualizarComboEditorial();
        this.actualizarComboTema();
    }

    public HashMap<Libro, String> obtenerDatos() {
        HashMap<Libro, String> datos = new HashMap<Libro, String>();
        datos.put(Libro.ISBN, this.fields.get(0).getText());
        datos.put(Libro.TITULO, this.fields.get(1).getText());
        datos.put(Libro.AUTOR, this.fields.get(2).getText());
        datos.put(Libro.PAGINAS, this.fields.get(3).getText());
        datos.put(Libro.PRECIO, this.fields.get(4).getText());
        datos.put(Libro.TEMATICA, String.valueOf(this.comboTema.getSelectedIndex() + 1));
        datos.put(Libro.EDITORIAL, String.valueOf(this.comboEditorial.getSelectedIndex() + 1));
        datos.put(Libro.ESTADO, this.comboEstado.getSelectedItem().toString());
        datos.put(Libro.FORMATO, this.comboFormato.getSelectedItem().toString());
        datos.put(Libro.CANTIDAD, "1");
        return datos;
    }

    private void crearLabelNombreCampos() {
        for (int i = 0; i < this.nombreCampos.length; i++) {
            this.panelLabel.add(this.dameJLabel(this.nombreCampos[i]));
        }
    }

    private void crearCampos() {
        for (int i = 0; i < this.nombreCampos.length - 4; i++) {
            this.fields.add(this.dameJTextField());
            this.panelCampo.add(this.fields.get(i));
        }

        this.soloNumeros(this.fields.get(0));
        this.soloNumeros(this.fields.get(3));
        this.soloNumeros(this.fields.get(4));
        this.longitudMax(this.fields.get(0), 13);
        this.soloLetras(this.fields.get(2));

        panelCampo.setLayout(new GridLayout(0, 1, 0, 10));
        this.panelCampo.add(this.comboTema);
        this.panelCampo.add(this.comboEditorial);
        this.panelCampo.add(this.comboFormato);
        this.panelCampo.add(this.comboEstado);
    }

    private JLabel dameJLabel(String title) {
        JLabel jLabel = new JLabel(title);
        jLabel.setForeground(Color.BLACK);
        jLabel.setFont(new Font("Arial Black", Font.CENTER_BASELINE, this.sizeLetra));
        return jLabel;
    }

    private JTextField dameJTextField() {
        JTextField field = new JTextField();
        field.setText(null);
        field.setForeground(new Color(106, 93, 77));
        field.setFont(new Font("Arial Blac", Font.BOLD, this.sizeLetra));
        return field;
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

    private void soloLetras(Component component) {
        component.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
                        && !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE))
                    e.consume();
            }
        });
    }

    public JButton getOkButton() {
        return okButton;
    }

}
