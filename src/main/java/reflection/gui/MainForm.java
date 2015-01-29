package reflection.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainForm extends JFrame{

	public MainForm () {
	super();
		 setTitle("I'm main");
		 
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		
//		 add(new JButton("im button"));
		 addComponents(getContentPane());
//		 setLocationRelativeTo(null);
		 setPreferredSize(new Dimension(600, 400));
		 pack();
		 setVisible(true);
	}

	public static void main(String[] args) {
		 MainForm mf=new MainForm();
	
	 }

	JTextField jTextValue;
	JTextField jTextField;
	OpenAction openAction;
	private void addComponents(Container contentPane) {
		GridLayout myLayout = new GridLayout(2, 2);
		contentPane.setLayout(myLayout);
		JButton buttonPerform= new JButton();
		openAction = new OpenAction("Ho-Ho");
		JButton buttonMyAction= new JButton(openAction);
		jTextField = new JTextField("simple text field");
		jTextValue = new JTextField("value");
		contentPane.add(buttonPerform);
		contentPane.add(jTextField);
		contentPane.add(jTextValue);
		contentPane.add(buttonMyAction);
		buttonPerform.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				jTextField.setText(jTextValue.getText());
				openAction.setEnabled(false);
			}
		});
		
	}

}
