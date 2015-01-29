package reflection.clazz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import reflection.gui.UpdateUI;
import reflection.tree.LinkedNode;
import reflection.tree.LinkedTreeModel;

public class JarLoader {

	/**
	 * @param path path to Jar file
	 * @param treeModel fit the information to treemodel
	 * @param meth update JTree after all is done
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String path, LinkedTreeModel treeModel, UpdateUI meth) throws FileNotFoundException, IOException, ClassNotFoundException {

		ClassLoader loader = new MyClassLoader(path);
		JarFile f = new  JarFile(path);
		Enumeration<JarEntry> enumiration = f.entries(); 
		String s;
		Class c;
		JarEntry e;
		while(enumiration.hasMoreElements()){
			LinkedNode root= (LinkedNode) treeModel.getRoot();
			root.setData(path);
			LinkedNode element = new LinkedNode();
			root.addSon(element);
			e = enumiration.nextElement();						
			if (e.getName().contains(".class")) {
				StringBuilder stringBuilderName= new StringBuilder(e.getName());
				int lastSlesh= stringBuilderName.lastIndexOf("/")+1;
				int length=stringBuilderName.length()-6;
				element.setName(stringBuilderName.substring(lastSlesh, length));
				StringBuilder stringBuilder = new StringBuilder("class\n");
//				element.setData(stringBuilder.toString());
				s = e.getName().replaceAll("/", ".");
				s = s.substring(0, s.length()-6);
				try{
					c = Class.forName(s, false, loader);				
					if (c!=null){
						stringBuilder.append(ClassDetail.getInfo(c));
						element.setData(stringBuilder.toString());
					}
				}catch(ClassNotFoundException e2){
					System.out.println("Error:"+e2.getMessage());
				}
				element.setData(stringBuilder.toString());
			}else{
				//System.out.println(e.getName());
			}
		}
		f.close();
		meth.updateUI();
	}
}