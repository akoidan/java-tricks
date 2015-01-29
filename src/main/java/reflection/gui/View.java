package reflection.gui;

import reflection.clazz.JarLoader;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import reflection.tree.LinkedNode;
import reflection.tree.LinkedTreeModel;

public class View extends JFrame implements UpdateUI{
	
	//Variable declaration
	JPanel jPanel;
	JTextArea jTextArea;
	JTree jTree;
	JFileChooser jFileChooser;
	JButton addJarButton;
	GridLayout gridInnerLayout;
	LinkedTreeModel treeModel;
	LinkedNode lastSelectedNode;
	//End of variable declaration
	
	public View() {
		GridLayout gridLayout = new GridLayout(1,2);
		setLayout(gridLayout);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500,300));
		Container contetnPain= getContentPane();
		addComponents(contetnPain);
		pack();
		setVisible(true);
	}
	
	
    public static void main(String[] args) {
		View main= new View();
    }

	 
	 
	private void addComponents(Container contetnPain) {
		jTree = new JTree();
		jPanel= new JPanel();
		jTextArea= new JTextArea();	
		contetnPain.add(jTree);
		contetnPain.add(jPanel);
		addJarButton= new JButton("Add Jar");
		addJarButton.setSize(50, 20);
		contetnPain.add(jPanel);
		gridInnerLayout = new GridLayout(2,1);
		jPanel.setLayout(gridInnerLayout);
		jPanel.add(addJarButton);
		jPanel.add(jTextArea);
		jFileChooser= new JFileChooser();
		jTree.addTreeSelectionListener(new TreeSelectionListener(){
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				changedSelectedNode();
			}

		
		});

		
		addJarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				JButtonMouseClick();
			}
		});
	}
	
	
	private void changedSelectedNode() {
		lastSelectedNode=(LinkedNode) jTree.getLastSelectedPathComponent();
		jTextArea.setText((String) lastSelectedNode.getData());
	}
		
		
	private void JButtonMouseClick()  {
		String nonStandardPath;
//		jFileChooser.showOpenDialog(null);
//		File file= jFileChooser.getSelectedFile();
//		nonStandardPath =file.getPath();
		Thread AddJarThread= new Thread (new Runnable() {
			@Override
			public void run() {
			String standardPath = "/home/andrew/NetBeansProjects/JTAP_lab1/CompiledSimpleJar.jar";		
			LinkedNode rootTreeNode = new LinkedNode("CompiledSimpleJar.jar");
			treeModel = new LinkedTreeModel(rootTreeNode);
			jTree.setModel(treeModel);
				try {
					JarLoader.main(standardPath, treeModel, View.this);
				} catch (IOException ex) {
					System.err.println("no such file");
				} catch (ClassNotFoundException ex) {
					System.err.println("NO SUCH CLASS\n"+ex.getMessage());
				}
			}
		});
		AddJarThread.start();
		System.out.println("Wait till class load");
	}

	@Override
	public void updateUI() {
		jTree.updateUI();
		System.out.println("Class load is done");
	}

}
