package reflection.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;

public class OpenAction extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("ButtonClicked");//To change body of generated methods, choose Tools | Templates.
	}

	public OpenAction() {
	}

	public OpenAction(String string) {
		super(string);
	}

	public OpenAction(String string, Icon icon) {
		super(string, icon);
	}

}
