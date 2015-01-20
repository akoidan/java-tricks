/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tkash;

/**
 *
 * @author andrew
 */
public class ConstructChild extends  ConstructSuper {

	public ConstructChild() {
	 System.out.println("Contrusctor chield");
	}
	public ConstructChild(int lol) {
		super(555);
		System.out.println("ContructorChild "+lol);
	}
		
}
