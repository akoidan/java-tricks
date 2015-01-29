package thread;

//import gui.OpenAction;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class NewMain extends JFrame{

	public NewMain () {
		super();
		 setTitle("I'm main");	 
		 setDefaultCloseOperation(EXIT_ON_CLOSE);	
		 addComponents(getContentPane());
		 setPreferredSize(new Dimension(600, 400));
		 pack();
		 setVisible(true);
	}
	
	MyNewThread myNewThread;
	Object lock ;
	Thread t1;
    public static void main(String[] args) throws InterruptedException {
		 NewMain nm = new NewMain();
		 nm.lock = new Object();
		 nm.myNewThread=new MyNewThread(nm.lock);
		 nm.t1= new Thread(nm.myNewThread);
		 nm.t1.start();
		Thread.sleep(10000);
		 System.out.println("MAIN is DONE");
	}


private void addComponents(Container contentPane) {
		GridLayout myLayout = new GridLayout(2, 2);
		contentPane.setLayout(myLayout);
		JButton buttonPerform= new JButton();
		contentPane.add(buttonPerform);
		buttonPerform.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				
					t1.notify();
				
			}
		});
		
	}
}


