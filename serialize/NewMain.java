package serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NewMain {

    public static void main(String[] args) throws Exception {
		 DataObject obj= new DataObject();
		 obj.setMyData("asdasds");
		 File file = new File("store.bin");
		 FileOutputStream fos= new FileOutputStream(file);
		 ObjectOutputStream oos = new ObjectOutputStream(fos);
		 oos.writeObject(obj);
		 oos.flush();
		 oos.close();
		 FileInputStream fis = new FileInputStream(file);
		 ObjectInputStream ois= new ObjectInputStream(fis);
		 DataObject readedObj= (DataObject) ois.readObject();
		 ois.close();
    }

}
