package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class CreadorComponentes {

	public JTextField dameJTextField() {
		JTextField field = new JTextField();
		field.setText(null);
		field.setForeground(new Color(106, 93, 77));
		field.setFont(new Font("Monospaced", Font.BOLD, 20));
		field.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		return field;
	}

}
