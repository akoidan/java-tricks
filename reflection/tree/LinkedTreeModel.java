package reflection.tree;

import java.util.Vector;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class LinkedTreeModel implements TreeModel{
private Vector<TreeModelListener> treeModelListeners = new Vector<TreeModelListener>();
private LinkedNode tree;

	public LinkedTreeModel(LinkedNode tree) {
		if (tree!=null){
		this.tree = tree;
		}else {
		tree=new LinkedNode("I'm father");
		}
	}

	public LinkedTreeModel(String name, String data) {
		tree=new LinkedNode(name,data);
	}


	
	public LinkedTreeModel() {
		tree=new LinkedNode("I'm Father");
		this.tree = tree;
	}
	
	@Override
	public Object getRoot() {
		return tree;
	}

	@Override
	public Object getChild(Object o, int i) {
		LinkedNode ln= (LinkedNode)o;
		return ln.getChildAt(i);
	}

	public void removeBranch(Object o) {
	if (o==this.getRoot()) return ;
	LinkedNode ln = (LinkedNode) o;
	ln.parent.removeChild(ln);
	}

	@Override
	public int getChildCount(Object o) {
		LinkedNode ln= (LinkedNode)o;
		return ln.getChildCount();
	}

	@Override
	public boolean isLeaf(Object o) {
		LinkedNode ln= (LinkedNode)o;
		return ln.isLeaf();
	}

	@Override
	public void valueForPathChanged(TreePath tp, Object o) {
		System.err.println("valueForPathChanged");
	}

	@Override
	public int getIndexOfChild(Object o, Object o1) {
		LinkedNode ln= (LinkedNode)o;
		return ln.getIndex((TreeNode) o1);
	}

	@Override
	public void addTreeModelListener(TreeModelListener tl) {
		treeModelListeners.addElement(tl);
	}

	@Override
	public void removeTreeModelListener(TreeModelListener tl) {
			treeModelListeners.removeElement(tl);
	}

}
