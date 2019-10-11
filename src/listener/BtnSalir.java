package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Control;
import control.ParaUI;

public class BtnSalir implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
