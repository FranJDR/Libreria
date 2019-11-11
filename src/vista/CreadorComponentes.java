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
	private Color colorJRadioButton = new Color(238, 236, 226);
	private int fontSize = 20;

	public JTextField dameJTextField() {
		JTextField field = new JTextField();
		field.setText(null);
		field.setForeground(new Color(106, 93, 77));
		field.setFont(new Font("Monospaced", Font.BOLD, this.fontSize));
		field.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		return field;
	}

	public JButton dameJButton(String title) {
		JButton btn = new JButton();
		btn.setText(title);
		btn.setFont(new Font("Microsoft JhengHei", Font.BOLD, this.fontSize));
		btn.setBackground(this.colorJButton);
		btn.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		return btn;
	}

	public JRadioButton dameJRadioButton(String title) {
		JRadioButton button = new JRadioButton();
		button.setText(title);
		button.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, this.fontSize));
		button.setBackground(this.colorJRadioButton);
		return button;
	}

	public JComboBox dameJComboBox() {
		JComboBox box = new JComboBox();
		box.setForeground(Color.BLACK);
		box.setFont(new Font("Monospaced", Font.BOLD, this.fontSize));
		box.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		box.setBackground(Color.white);
		return box;
	}

	public JLabel dameJLabel(String title) {
		JLabel jLabel = new JLabel(title);
		jLabel.setForeground(Color.BLACK);
		jLabel.setFont(new Font("Book Antiqua", Font.ITALIC, this.fontSize));
		return jLabel;
	}

}
