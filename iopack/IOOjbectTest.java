package iopack;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class IOOjbectTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

		 
		 
		 	User u2 = new User("Ania", 19, (float) 1.44);
			
			File f = new File("asd");
			if (!f.createNewFile()) System.err.println("FIle already exists");
		FileOutputStream outputStream = new FileOutputStream(f);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(u2);
		objectOutputStream.close();
		FileInputStream fileInputStream = new FileInputStream(f);
		ObjectInputStream objectinptStream = new ObjectInputStream(fileInputStream);
 		User u3= (User) objectinptStream.readObject();
		 System.out.println(u3.age);
    }

}
