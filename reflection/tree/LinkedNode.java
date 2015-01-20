package reflection.tree;

import java.util.Enumeration;
import javax.swing.tree.TreeNode;

public class LinkedNode implements TreeNode{

	private String data;
	private String name;

	//brother > current> sister 
	public LinkedNode son;
	public LinkedNode brother;
	public LinkedNode parent;
	public LinkedNode sister;
	
	
	public boolean addSon(String name, String data) {
		LinkedNode son = new LinkedNode(name, data);
		addSon(son);
		return true;
	}
	
	
	public boolean addSon(LinkedNode son) {
		int childCount=this.getChildCount();
		son.parent=this;
		son.brother=null;
		if (childCount==0) {
			son.sister=null;
			this.son=son;
			return true;
		}
		son.sister =this.getChildAt(childCount-1);
		son.sister.brother=son;
		return false;
	}

		
	public void removeChild(LinkedNode child) {
		int index=this.getIndex((TreeNode)child);
		if (index==-1) return;	
		if (index==0){
			this.son=child.brother;
			if (child.brother!=null) {
				child.brother.sister=null;
			}
			return;	
		} else {
			if (child.brother!=null){
				child.brother.sister=child.sister;
			}
			child.sister.brother=child.brother;
		}
	}
	
	
	
	@Override
	public String toString(){
		return name.toString();
	}

	public LinkedNode(String name) {
		this();
		this.name = name;
	}

	public LinkedNode(String name, String data) {
		this();
		this.name = name;
		this.data = data;
	}
	
	public LinkedNode() {
		this.name= "ain't set";
		this.data= "ain't set";
		this.son=null;
		this.brother=null;
		this.parent=null;
		this.sister=null;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
		public LinkedNode getChildAt(int i) {
		if (i>=getChildCount()) {
			return null;
		} 
		LinkedNode returns = null;
		Enumeration<LinkedNode> el= this.children();
		for (int current=0;current<=i;current++){///OMG OMG OMG
			returns=el.nextElement();
		}
		return returns;
	}	
	

	@Override
	public int getChildCount() {
		int i=0;
		Enumeration<LinkedNode> el= this.children();
		while (el.hasMoreElements()) {
			el.nextElement();
			i++;
		}	
		return i;
	}

	@Override
	public TreeNode getParent() {
		return this.parent;
	}

	@Override
	public int getIndex(TreeNode tn) {
		for (int i=0;i<this.getChildCount();i++){
			if (this.getChildAt(i)==(LinkedNode)tn){
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean getAllowsChildren() {
		System.out.println("getAllowsChildren");
		return false;
	}

	@Override
	public boolean isLeaf() {
		return this.son==null;
	}

	@Override
	public Enumeration<LinkedNode> children() {
		return new Enumeration() {
			
			private LinkedNode current;
			{
				this.current = son;
			}
			
			@Override
			public boolean hasMoreElements() {
				return current!=null;
			}

			@Override
			public LinkedNode nextElement() {
				LinkedNode ln=current;
				current=current.brother;
				return ln;
			}
		};
	}



	
}



