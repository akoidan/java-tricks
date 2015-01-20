package iopack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IOTest {
	public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException, InstantiationException { 
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		User u = new User("Ololo", 12, (float) 14.33);
		
		BufferedWriter bufferedWriter;
		DataInputStream dataInputStream;
		DataOutputStream dataOutputStream;
		ObjectInputStream objectInputStream;
		ObjectOutputStream objectOutputStream;
		Properties properties = new Properties();
		File file = new File("tkash.txt");
		if (!file.createNewFile()) System.out.println("File exists"); else
			System.out.println("File doesn't exist");
		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);		
		System.out.println(bufferedReader.readLine());
		
		
		
		
		File propFile = new File("propFile");
		if (!propFile.createNewFile()) System.out.println("File exists"); else
			System.out.println("File doesn't exist");
		Class clazz = User.class;
		FileWriter fileWriter= new FileWriter(propFile);
		bufferedWriter = new BufferedWriter(fileWriter);
		
		Field [] fields=clazz.getDeclaredFields();
		for (Field field : fields) {
//			System.out.println(field.get(u)+": "+field.getName());
		properties.setProperty(field.getName(),  field.get(u).toString());
		}
		properties.store(bufferedWriter, "Test");
		fileWriter.close();
		bufferedWriter.close();
		
		fileReader = new FileReader(propFile);
		bufferedReader = new BufferedReader(fileReader);		
		
		Properties lastProperties= new Properties();
		properties.load(bufferedReader);
		Enumeration<?> e= properties.propertyNames();
	
		
		
		
		while (e.hasMoreElements()) {
			String propertyName = (String)e.nextElement();
			Field f=clazz.getField(propertyName);
			Class<?> fieldType = f.getType();
			System.out.println(fieldType.getName());
			Class lol=Class.forName(fieldType.getName());

//			f.set(u2, lol);			
		
		}
		
			
		}
		
		 
	
}
