package serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.imageio.IIOException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name ="dataObj")
public class DataObject extends NonSeriazable  implements Serializable{

@XmlAttribute
 private int i=5;
@XmlElement
 private String s="aaa";

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}




 public transient String[] def={"1","2"};
 public CustomObject co = new CustomObject();
 
 private void writeObject (ObjectOutputStream out ) throws IOException {
	 out.defaultWriteObject();
	 out.writeObject(getMyData());
 }
 
 private void readObject (ObjectInputStream in ) throws IOException, ClassNotFoundException{
  in.defaultReadObject();
   super.setMyData((String) in.readObject());
 }
}
