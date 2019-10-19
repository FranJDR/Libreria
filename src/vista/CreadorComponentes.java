package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class CreadorComponentes {

	private Color colorJButton = new Color(238, 236, 226);

	public JTextField dameJTextField() {
		JTextField field = new JTextField();
		field.setText(null);
		field.setForeground(new Color(106, 93, 77));
		field.setFont(new Font("Monospaced", Font.BOLD, 20));
		field.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		return field;
	}

	public JButton dameJButton(String title) {
		JButton btn = new JButton();
		btn.setText(title);
		btn.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		btn.setBackground(this.colorJButton);
		btn.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		return btn;
	}

	public JRadioButton dameJRadioButton(String title) {
		JRadioButton button = new JRadioButton();
		button.setText(title);
		button.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		button.setBackground(new Color(238, 236, 226));
		return button;
	}

	public JComboBox dameJComboBox() {
		JComboBox box = new JComboBox();
		box.setForeground(Color.BLACK);
		box.setFont(new Font("Monospaced", Font.BOLD, 20));
		box.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		box.setBackground(Color.white);
		return box;
	}

	public JLabel dameJLabel(String title, int longitud) {
		for (int i = 0; i < longitud; i++)
			title += " ";
		JLabel jLabel = new JLabel(title);
		jLabel.setForeground(Color.BLACK);
		jLabel.setFont(new Font("Book Antiqua", Font.ITALIC, 20));
		return jLabel;
	}

}
